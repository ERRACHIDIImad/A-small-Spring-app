package couche_DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Util.HibernateUtil;

public class DAO_Impl implements IDAO {

	private SessionFactory Sf = HibernateUtil.getSessionFactory();
	private Session S;

	public void addClient(Client clt) {
		this.S = Sf.getCurrentSession();
		this.S.beginTransaction();
		this.S.save(clt);
		this.S.getTransaction().commit();
	}
	public void addCompte(Compte c, int codeClient) {
		this.S = Sf.getCurrentSession();
		this.S.beginTransaction();
		Client clt = (Client) this.S.get(Client.class, codeClient);
		clt.addCompte(c);
		this.S.save(c);
		this.S.getTransaction().commit();
	}

	public void addOperation(Operation Opr, int numCompte) {
		this.S = Sf.getCurrentSession();
		this.S.beginTransaction();
		Compte c = (Compte) this.S.get(Compte.class, numCompte);

		if (Opr.getDesignation().equals("Versment")) {
			c.setSolde(c.getSolde() + Opr.getMontant());
			c.addOperation(Opr);
			this.S.save(Opr);
			this.S.getTransaction().commit();
		}

		if (Opr.getDesignation().equals("Retrait")) {

			if (c.getSolde() > Opr.getMontant()) {
				c.setSolde(c.getSolde() - Opr.getMontant());
				c.addOperation(Opr);
				this.S.save(Opr);
				this.S.getTransaction().commit();
			} else {
				this.S.close();
				System.out.print("Solde insufficient !");
			}

		}

	}

	public Client getClient(int codeClient) {
		this.S = Sf.getCurrentSession();
		this.S.beginTransaction();
		Client clt = (Client) this.S.get(Client.class, codeClient);
		S.close();
		return clt;
	}

	public void deleteOperation(int code) {
		this.S = Sf.getCurrentSession();
		this.S.beginTransaction();
		Operation c = (Operation) this.S.get(Operation.class, code);
		this.S.delete(c);
		this.S.getTransaction().commit();
	}

	public void updteClient(int Codeclient, Client client) {
		this.S = Sf.getCurrentSession();
		Client c = this.getClient(Codeclient);

		c.setNom(client.getNom());
		c.setPrenom(client.getPrenom());
		c.setTel(client.getTel());
		S.load(Client.class, Codeclient);
		this.S.getTransaction().commit();

	}

	public List<Operation> getOperations(int numCompte) {
		this.S = Sf.getCurrentSession();
		this.S.beginTransaction();
		Compte c = (Compte) this.S.get(Compte.class, numCompte);
		Query<Operation> req = this.S.createQuery("select opr from Operation opr where opr.compte=:v");
		req.setParameter("v", c);
		List<Operation> operations = req.getResultList();
		S.close();
		return operations;

	}

	public List<Client> getClientsByFirstName(String FirstName) {
		S = Sf.getCurrentSession();
		S.beginTransaction();
		Query req = S.createQuery(" select clt from Client clt where clt.prenom=:v");
		req.setParameter("v", FirstName);
		List<Client> clients = req.getResultList();
		S.close();
		return clients;

	}

}

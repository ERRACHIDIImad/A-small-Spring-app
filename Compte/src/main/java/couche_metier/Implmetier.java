package couche_metier;

import java.util.List;

import couche_DAO.*;

public class Implmetier implements Imetier {
	private IDAO Dao;

	public void setDao(IDAO dao) {
		Dao = dao;
	}

	public void addClient(String Nom, String Prenom, String TEL) {
		Dao.addClient(new Client(Nom, Prenom, TEL));
	}

	public void addCurrent(int Solde, String Date_création, int découvert, int NumClient) {
		Dao.addCompte(new Courant(Solde, Date_création, découvert), NumClient);
	}

	public void addEpargn(int Solde, String Date_création, int Taut_intéret, int NumClient) {
		Dao.addCompte(new Epargne(Solde, Date_création, Taut_intéret), NumClient);
	}

	public void addOpertion(double montant, String designation, String datecreation, int NumAccount) {

		Dao.addOperation(new Operation(montant, designation, datecreation), NumAccount);

	}

	public void UpdateClient(String Nom, String Prénom, String TEL, int NumClient) {
		Dao.updteClient(NumClient, new Client(Nom, Prénom, TEL));
	}

	public List<Operation> getOperations(int NumAccount) {
		return Dao.getOperations(NumAccount);
	}

	public List<Client> getClientsByFirstName(String FirstName) {
		return Dao.getClientsByFirstName(FirstName);

	}


	public Client getClient(int NumClient) {
		return Dao.getClient(NumClient);
	}

}

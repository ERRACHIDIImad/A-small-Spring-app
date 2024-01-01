package couche_DAO;

import java.util.List;

public interface IDAO {

	public void addClient(Client clt);

	public void addCompte(Compte c, int codeClient);

	public void addOperation(Operation Opr, int numCompte);

	public Client getClient(int codeClient);

	public void deleteOperation(int code);

	public void updteClient(int Codeclient, Client client);

	public List<Operation> getOperations(int numCompte);
	
	
	
	public List<Client> getClientsByFirstName(String FirstName);

}

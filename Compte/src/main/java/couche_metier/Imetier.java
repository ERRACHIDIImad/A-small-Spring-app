package couche_metier;

import java.util.List;

import couche_DAO.Client;
import couche_DAO.Operation;

public interface Imetier {

	public void addClient(String Nom, String Prenom, String TEL);

	public void addCurrent(int Solde, String Date_création, int découvert, int NumClient);

	public void addEpargn(int Solde, String Date_création, int Taut_intéret, int NumClient);

	public void addOpertion(double montant, String designation, String datecreation, int NumAccount);

	public void UpdateClient(String Nom, String Prénom, String TEL, int NumClient);

	public List<Operation> getOperations(int NumAccount);

	public Client getClient(int NumClient);

	public List<Client> getClientsByFirstName(String FirstName);

}

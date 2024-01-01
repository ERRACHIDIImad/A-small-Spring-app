

import couche_metier.Imetier;
import couche_metier.Implmetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tets {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Imetier Metier = (Imetier) Context.getBean("Metier");
	 Metier.addClient("imad", "AMOUDA", "12541543456789");
//		  
//		  Metier.addCurrent(440,"2020/05/16" ,1000 , 6);

//		 Metier.addEpargn(700, "2021/05/16", 500, 6);
		// Metier.addOpertion(2000, "Retrait", "2021/04/12", 5);
//		List<Client> clients = Metier.getClientsByFirstName("AMOUDA");
//		Set<Compte> Comptes;
//		for (Client clt : clients) {
//			System.out.println(clt.getNom());
//			Comptes = clt.getComptes();
//			for (Compte c : Comptes) {
//				System.out.println(c.getNum() + "   " + c.getSolde() + "   " + c.getDatecreation());
//			}
//		}

	}

}

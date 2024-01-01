package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import couche_metier.Imetier;

@Controller()
public class Clients {

	@Autowired
	private Imetier metier;

	@RequestMapping(value = "/Acceuil")
	public String Acceuil() {
		return ("Acceuil");
	}
	
	@RequestMapping(value = "/GetClientByFirstName")
	public String getClientByPRENOM(@RequestParam(value = "prenom") String Prenom, Model model) {
		model.addAttribute("Clients", metier.getClientsByFirstName(Prenom));
		model.addAttribute("Prénom", Prenom);
		return "Acceuil";

	}

}
package couche_DAO;

import java.util.Set;

import jakarta.persistence.*;
import java.util.HashSet;
import java.io.Serializable;


@Entity()
@Table(name = "clients")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENT")
	private int codeClient;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="TEL")
	private String tel;
	
	@OneToMany(mappedBy = "client" , targetEntity= Compte.class ,fetch = FetchType.LAZY )
	private Set<Compte> comptes = new HashSet<Compte>();

	public Client() {
		super();

	}

	public Client( String nom, String prenom, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Client [codeClient=" + codeClient + ", nom=" + nom + ", prénom=" + prenom + ", tel=" + tel + "]";
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prénom) {
		this.prenom = prénom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	
	public void setComptes(Set<Compte>  comptes) {
		this.comptes=  comptes;
	}
	public void addCompte(Compte c) {
		comptes.add(c);
		c.setClient(this);
	}

}

package couche_DAO;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "operations")
public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_OPERATION")
	private int code;

	@Column(name = "FUND")
	private double montant;

	@Column(name = "DESIGNATION")
	private String designation;
	
	@Column(name = "DATE_CREATION")
	private String datecreation;

	@ManyToOne()
	@JoinColumn(name="ID_ACCOUNT")
	private Compte compte;

	public Operation() {
		super();
	}

	public Operation(double montant, String designation , String datecreation) {
		super();
		this.montant = montant;
		this.designation = designation;
		this.datecreation=datecreation;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Compte getCompte() {
		return compte;
	}

	
	public String getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Operation [code=" + code + ", Montant=" + montant + ", Désigntion=" + designation + "]";
	}

}

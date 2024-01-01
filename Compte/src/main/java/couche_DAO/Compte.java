package couche_DAO;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.io.Serializable;

@Entity()
@Table(name = "comptes")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="ACCOUNT_TYPE" , discriminatorType = DiscriminatorType.STRING,length = 13)
public class Compte implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "ID_ACCOUNT")
	private int num;
	
	@Column(name="SOLDE")
	private double solde;
	
	@Column(name="CREATION_DATE")
	private String datecreation;
	
	@ManyToOne()
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	
	@OneToMany(mappedBy ="compte"  ,  fetch=FetchType.LAZY)
	private Set<Operation> operations = new HashSet<Operation>();

	public Compte() {
		super();
	}

	public Compte( double solde, String datecreation) {
		super();
		this.solde = solde;
		this.datecreation = datecreation;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client Client) {
		this.client = Client;
	}

	@Override
	public String toString() {
		return "Compte [num=" + num + ", solde=" + solde + ", datecréation=" + datecreation + "]";
	}

	public Set<Operation> getOperations() {
		return operations;
	}
	
	
	void addOperation(Operation o) {
		operations.add(o);
		o.setCompte(this);
	}
	
	public void setOperations(Set<Operation> operations) {
		this.operations=operations;;
	}



}

package couche_DAO;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Current")
public class Courant extends Compte {
	
	@Column(name="DECOUVERT")
	private int decouvert;

	public Courant() {
		super();
	}

	public Courant(int solde, String date_creation, int decouvert) {
		super(solde, date_creation);
		this.decouvert = decouvert;

	}

	public int getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}

}

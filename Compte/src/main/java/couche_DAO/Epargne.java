package couche_DAO;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Epargne")
public class Epargne extends Compte {

	@Column(name="TAUT_INTERET")
	private int taut_interet;

	public Epargne() {
		super();
	}

	public Epargne( int solde, String date_creation, int taut_interet) {
		super( solde, date_creation);
		this.taut_interet = taut_interet;

	}

	public int getTaut_interet() {
		return taut_interet;
	}

	public void setTaut_interet(int taut_interet) {
		this.taut_interet = taut_interet;
	}

}

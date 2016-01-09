package org.glsid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")

@XmlType(name="CE")
public class CompteEpargne extends Compte {
	private static final long serialVersionUID = 1L;

	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String codeCompte, Date dateCreation, double solde) {
		super(codeCompte, dateCreation, solde);
		// TODO Auto-generated constructor stub
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}

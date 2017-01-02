package com.moustaid.entities;

import java.io.Serializable;
import java.util.Date;


public class OrdreVente extends Ordre implements Serializable {

	public OrdreVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdreVente(Date dateOrdre, int nombreActions, double prixAction, Societe societe) {
		super(dateOrdre, nombreActions, prixAction, societe);
		// TODO Auto-generated constructor stub
	}

}

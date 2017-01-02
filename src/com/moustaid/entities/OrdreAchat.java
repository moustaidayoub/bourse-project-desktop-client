package com.moustaid.entities;

import java.io.Serializable;
import java.util.Date;


public class OrdreAchat extends Ordre implements Serializable {

	public OrdreAchat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdreAchat(Date dateOrdre, int nombreActions, double prixAction, Societe societe) {
		super(dateOrdre, nombreActions, prixAction, societe);
		// TODO Auto-generated constructor stub
	}

	
	

}

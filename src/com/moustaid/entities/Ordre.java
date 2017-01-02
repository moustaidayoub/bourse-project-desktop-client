package com.moustaid.entities;

import java.io.Serializable;
import java.util.Date;



public abstract class Ordre implements Serializable {
	
	protected Long numeroOrdre;
	protected Date dateOrdre;
	   protected int nombreActions;
	   protected double prixAction;
	   protected Societe societe;
	  protected String typeOrdre;
	public Ordre(Date dateOrdre, int nombreActions, double prixAction,Societe societe) {
		super();
		this.dateOrdre = dateOrdre;
		this.nombreActions = nombreActions;
		this.prixAction = prixAction;
		this.societe=societe;
	}
	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumeroOrdre() {
		return numeroOrdre;
	}
	public void setNumeroOrdre(Long numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}
	public Date getDateOrdre() {
		return dateOrdre;
	}
	public void setDateOrdre(Date dateOrdre) {
		this.dateOrdre = dateOrdre;
	}
	public int getNombreActions() {
		return nombreActions;
	}
	public void setNombreActions(int nombreActions) {
		this.nombreActions = nombreActions;
	}
	public double getPrixAction() {
		return prixAction;
	}
	public void setPrixAction(double prixAction) {
		this.prixAction = prixAction;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getTypeOrdre() {
		return typeOrdre;
	}
	public void setTypeOrdre(String typeOrdre) {
		this.typeOrdre = typeOrdre;
	}
	
	   

}

package com.moustaid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Societe implements Serializable {
   private Long numeroSociete;
	 private String codeSociete;
	   private String nomSociete;
	   private List<Ordre> orders;

	public Societe(String codeSociete, String nomSociete) {
		super();
		this.codeSociete = codeSociete;
		this.nomSociete = nomSociete;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getNumeroSociete() {
		return numeroSociete;
	}

	public void setNumeroSociete(Long numeroSociete) {
		this.numeroSociete = numeroSociete;
	}

	public String getCodeSociete() {
		return codeSociete;
	}

	public void setCodeSociete(String codeSociete) {
		this.codeSociete = codeSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	public List<Ordre> getOrders() {
		if(orders==null)
			return new ArrayList();
		return orders;
	}
	public void setOrders(List<Ordre> orders) {
		this.orders = orders;
	}
	   
}

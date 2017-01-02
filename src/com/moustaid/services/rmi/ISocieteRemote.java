package com.moustaid.services.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.moustaid.entities.Societe;

public interface ISocieteRemote extends Remote {
	Societe addSociete(Societe societe) throws RemoteException;
	Societe findSociete(Long numeroSociete) throws RemoteException;
	Societe findByCode(String codeSociete) throws RemoteException;
	List<Societe> findAll() throws RemoteException;
}

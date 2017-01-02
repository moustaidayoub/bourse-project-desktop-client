package com.moustaid.view;

import com.moustaid.entities.Ordre;
import com.moustaid.entities.OrdreAchat;
import com.moustaid.entities.OrdreVente;
import com.moustaid.entities.Societe;
import com.moustaid.services.rmi.ISocieteRemote;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<Societe> societeTable;

    @FXML
    private TableColumn<Societe, String> codeColumn;

    @FXML
    private TableColumn<Societe, String> nameColumn;

    @FXML
    private TableView<Ordre> ordreTable;

    @FXML
    private TableColumn<Ordre, Number> actionsCountColumn;

    @FXML
    private TableColumn<Ordre, Number> actionPriceColumn;

    @FXML
    private TableColumn<Ordre, String> dateColumn;


    private ISocieteRemote societeRemote;
    private ObservableList<Societe> societesObservableList;
    private Societe selectedSociete;

    @FXML
    private void initialize() throws RemoteException, NotBoundException, MalformedURLException {
        societeRemote = (ISocieteRemote) Naming.lookup("rmi://localhost:1099/societeRmiService");
        setSocieteTableCells();
        setOrdreTableCells();
        //init test avec des societes
        initSocietesToTest();
        societeTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedSociete = newValue;
            if(selectedSociete!=null)
                setOrdres();
        });
    }
    @FXML
    public void findAllSocietes() throws RemoteException {
        societesObservableList = FXCollections.observableArrayList(societeRemote.findAll());
        societeTable.setItems(societesObservableList);
        societeTable.getSelectionModel().select(0);
        selectedSociete = societeTable.getSelectionModel().getSelectedItem();
    }


    private void setOrdreTableCells() {
        actionsCountColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNombreActions()));
        actionPriceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrixAction()));
        dateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateOrdre()));

    }

    private void setSocieteTableCells() {
       codeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodeSociete()));
       nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomSociete()));
    }

    private void setOrdres() {
       ordreTable.setItems(FXCollections.observableList(selectedSociete.getOrders()));
    }


    @FXML
    public void searchingSocietes() throws RemoteException {
        String code = searchTextField.getText();
        societeTable.getSelectionModel().clearSelection();
        selectedSociete = societeRemote.findByCode(code);
        setOrdres();
    }
    private void initSocietesToTest(){
        List<Societe> societesListTest=new ArrayList<>();
        Societe societe=new Societe("MA00019","Banque Populaire");
        //creation Ordres
        Ordre ordre1=new OrdreAchat(new Date(),10,4.5,societe);
        Ordre ordre2=new OrdreAchat(new Date(),5,8,societe);
        Ordre ordre3=new OrdreVente(new Date(),8,11,societe);
        Ordre ordre4=new OrdreVente(new Date(),10,5,societe);
        List<Ordre> ordres=new ArrayList<>();
        ordres.add(ordre1);
        ordres.add(ordre2);
        ordres.add(ordre3);
        ordres.add(ordre4);
        societe.setOrders(ordres);
        societesListTest.add(societe);
        societe=new Societe("MA00209","Marjane");
        //creation Ordres
        ordre1=new OrdreAchat(new Date(),30,120,societe);
        ordre2=new OrdreAchat(new Date(),1,18,societe);
        ordre3=new OrdreVente(new Date(),7,99,societe);
        ordre4=new OrdreVente(new Date(),19,13,societe);
        ordres=new ArrayList<>();
        ordres.add(ordre1);
        ordres.add(ordre2);
        ordres.add(ordre3);
        ordres.add(ordre4);
        societe.setOrders(ordres);
        societesListTest.add(societe);
        societesObservableList = FXCollections.observableArrayList(societesListTest);
        societeTable.setItems(societesObservableList);
        societeTable.getSelectionModel().select(0);
        selectedSociete = societeTable.getSelectionModel().getSelectedItem();
    }
}

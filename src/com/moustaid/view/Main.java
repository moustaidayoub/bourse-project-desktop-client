package com.moustaid.view;

import com.moustaid.services.rmi.ISocieteRemote;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.Naming;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ISocieteRemote soc= (ISocieteRemote) Naming.lookup("rmi://localhost:1099/societeRmiService");
        System.out.println("Rmi Societe Service(Client) :"+soc);
        Parent root = FXMLLoader.load(getClass().getResource("bourse.fxml"));
        primaryStage.setTitle("Projet Bourse - Client JavaFX");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

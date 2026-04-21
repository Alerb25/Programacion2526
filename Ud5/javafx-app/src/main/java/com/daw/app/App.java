package com.daw.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        //hemos creado una etuiqueta para el nombre
        Label lblNombre = new Label("Nombre");
        //input de texto pal usuario
        TextField txtNombre = new TextField();
        //boton cualquiera
        Button btnAccion = new Button("Accion");
        //panel para añadir los elementos
        VBox vPanel = new VBox();

        //añadir los elementos a la escena
        var scene = new Scene(vPanel);
        
        stage.setTitle("aplicación mutante");
        stage.setHeight(500);
        stage.setWidth(900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
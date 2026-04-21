package com.daw.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
        Label lblResultado = new Label();
        Label lblBanner = new Label("App Mutante");
        Label lblSlider = new Label();
        lblBanner.setScaleX(4);
        lblBanner.setScaleY(4);

        //input de texto pal usuario
        TextField txtNombre = new TextField();
        //boton cualquiera
        Button btnAccion = new Button("Accion");
        Slider sldPuntuacion = new Slider(0, 100, 50);
          //panel para añadir los elementos
        VBox vPanel = new VBox();
        BorderPane panelPrincipal = new BorderPane();

        //para que aparezcán las cosas  en el panel  
        vPanel.getChildren().addAll(lblNombre, txtNombre, btnAccion);

       
        btnAccion.setOnAction( e ->{
            lblResultado.setText("Bienvenido a tu primera app " + txtNombre.getText());
            vPanel.getChildren().add(lblResultado);
        });
        
        sldPuntuacion.setOnMouseDragged(e ->{
           lblSlider.setText("Valor:" + (int)sldPuntuacion.getValue());
        });

        txtNombre.setMaxWidth(200);
        vPanel.setPadding(new Insets(20));
        vPanel.setSpacing(10);
        


        panelPrincipal.setCenter(vPanel);
        panelPrincipal.setPadding(new Insets(20));
        panelPrincipal.setAlignment(lblBanner, Pos.CENTER);
        panelPrincipal.setTop(lblBanner);
        panelPrincipal.setBottom(sldPuntuacion);
        panelPrincipal.setRight(lblSlider);
        //añadir los elementos a la escena
        var scene = new Scene(panelPrincipal);
        
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
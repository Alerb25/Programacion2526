package com.daw.app;

import com.daw.app.Panels.PeliculaPanel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploPaneles extends Application {

    @Override
    public void start(Stage stage) {

        PeliculaPanel peliculaPanel = new PeliculaPanel();
        Scene scene = new Scene(peliculaPanel, 800, 600);

        // como el stage ya se tiene lo que hacemos es simplemente añadirle la escena
        stage.setScene(scene);
        stage.setTitle("Ejemplo Paneles");
        // hay que mostrar el stage porque o sino no pasa nada
        stage.show();

    

    }

    public static void main(String[] args) {
        launch();
    }

}
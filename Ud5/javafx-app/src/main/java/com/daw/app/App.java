package com.daw.app;

import com.daw.app.Panels.PeliculaPanel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        // hemos creado una etuiqueta para el nombre
        Label lblNombre = new Label("Nombre");
        Label lblResultado = new Label();
        Label lblBanner = new Label("Gestor de Películas");
        Label lblSlider = new Label();
        lblBanner.setScaleX(4);
        lblBanner.setScaleY(4);

        // input de texto pal usuario
        TextField txtNombre = new TextField();
        // boton cualquiera
        Button btnAccion = new Button("Accion");
        Slider sldPuntuacion = new Slider(0, 100, 50);
        // panel para añadir los elementos
        VBox vPanel = new VBox();
        PeliculaPanel panelPrincipal = new PeliculaPanel();

        // para que aparezcán las cosas en el panel
        vPanel.getChildren().addAll(lblNombre, txtNombre, btnAccion);

        btnAccion.setOnAction(e -> {
            lblResultado.setText("Bienvenido a tu primera app " + txtNombre.getText());
            vPanel.getChildren().add(lblResultado);
        });

        sldPuntuacion.setOnMouseDragged(e -> {
            lblSlider.setText("Valor:" + (int) sldPuntuacion.getValue());
        });

        txtNombre.setMaxWidth(200);
        vPanel.setPadding(new Insets(20));
        vPanel.setSpacing(10);

 // El panel de pestañas contiene pestañas
        // Por defecto se pueden cerrar, con setclosable se quita la opcion
        // Hay que añadir las pestañas al panel de pestañas para que se muestren
        // Hay que añadir contenido a las pestañas con setContent

        BorderPane pPrincipal = new BorderPane();
        PeliculaPanel pPelicula = new PeliculaPanel();
        TabPane tPane = new TabPane();

        Tab tPelicula = new Tab("Crear Pelicula");
        Tab tFicheros = new Tab("Abrir Fichero");
        Tab tBot = new Tab("Agente IA");

        tPelicula.setClosable(false);
        tFicheros.setClosable(false);
        tPane.getTabs().addAll(tPelicula, tFicheros, tBot);

        // Metemos el panelPelicula en la primera pestaña
        tPelicula.setContent(pPelicula);

        /***********************
         * MENUS
         ************************/
        MenuBar mbPrincipal = new MenuBar();
        // Menus
        Menu mArchivo = new Menu("Archivo");
        Menu mBD = new Menu("Ver");
        Menu mOpciones = new Menu("Opciones");
        Menu mAyuda = new Menu("Ayuda");
        Menu mOperaciones = new Menu("Operaciones");
        // MenuItems
        MenuItem miAbrir = new MenuItem("Abrir..");
        MenuItem miGuardar = new MenuItem("Guardar..");
        MenuItem miSalir = new MenuItem("Cerrar..");
        SeparatorMenuItem separador = new SeparatorMenuItem();

        mArchivo.getItems().addAll(miAbrir, miGuardar, separador, miSalir);
        MenuItem miCrearPelicula = new MenuItem("Crear Pelicula");
        MenuItem miBorrarPelicula = new MenuItem("Borrar Pelicula");
        mBD.getItems().add(mOperaciones);
        mOperaciones.getItems().addAll(miCrearPelicula, miBorrarPelicula);

        // Cargamos en la barra de menus lso menus
        mbPrincipal.getMenus().addAll(mArchivo, mBD, mOpciones, mAyuda);

        /*****************************
         * EVENTOS
         ************************/
        miSalir.setOnAction(e -> {
            stage.close();
        });

        miCrearPelicula.setOnAction(e -> {
            // Seleccionamos la pestaña primer del panel
            // Que es la de insertar pelicula
            tPane.getSelectionModel().select(tPelicula);
        });

        // Ponemos en la posicion central del borderpane
        // Nuestro Tabpane
        pPrincipal.setCenter(tPane);
        // Ponemos en la parte superior del borderpane el menu
        pPrincipal.setTop(mbPrincipal);

        // Creamos una escena que contiene al panel pricipal (borderpane)
        Scene scene = new Scene(pPrincipal, 800, 600);
        // Asignamos la escena al stage
        stage.setScene(scene);
        stage.setTitle("Ejemplo Paneles");
        // Mostramos la app
        stage.show();
    }
     

    public static void main(String[] args) {
        launch();
    }

}
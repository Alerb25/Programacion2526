package com.daw.app.Panels;

import java.sql.SQLException;

import com.daw.app.model.PeliculasDAO;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PeliculaPanel extends GridPane {
    // Para peliculas, añadimos etiquetas y los campos a rellenar
    private Label lblTitulo;
    private Label lblClasificacion;
    private Label lblDuracion;
    private Label lblSipnosis;

    public TextField txtTitulo = new TextField("Escriba un título: ");
    public ComboBox<String> cmbClasificacion = new ComboBox<String>();
    public Slider sldDuracion = new Slider(30, 600, 120);
    public TextArea txtSipnosis = new TextArea("Escriba la sipnosis: ");
    public Button btnReset;
    public Button btnMostrar;
    public Button btnGuardar = new Button("Guardar");

    public PeliculaPanel() {
        this.setHgap(10);
        this.setVgap(8);
        this.setPadding(new Insets(20));
        lblTitulo = new Label("Título");
        lblClasificacion = new Label("Clasificacion");
        lblDuracion = new Label("Duracion");
        lblSipnosis = new Label("sipnosis");
        btnReset = new Button("Borrar");
        btnGuardar = new Button("Guardar");
        btnMostrar = new Button("Mostrar");

        cmbClasificacion.getItems().addAll("Todos lo publicos", "+3", "+6", "+9", "+12", "+14", "+18",
                "Jubilados only");
        txtSipnosis.setPrefWidth(500);
        txtSipnosis.setPrefHeight(300);

        // añadir los elementos al gridpane
        this.add(lblTitulo, 0, 0);
        this.add(txtTitulo, 1, 0);
        this.add(lblClasificacion, 0, 1);
        this.add(cmbClasificacion, 1, 1);
        this.add(lblDuracion, 0, 2);
        this.add(sldDuracion, 1, 2);
        this.add(lblSipnosis, 0, 3, 3, 3);
        this.add(txtSipnosis, 1, 3);

        this.add(btnGuardar, 0, 6);
        this.add(btnReset, 1, 6);
        this.add(btnMostrar, 2, 6);

        // evento para llamar a rest() cuando pulsamos el boton
        btnReset.setOnAction(e -> {
            reset();
        });

        btnGuardar.setOnAction(e -> {
            guardar();
        });

        btnMostrar.setOnAction(e ->{
            mostrar();
        });

    }

    // metodo del reset
    private void reset() {
        this.txtTitulo.clear();
        this.txtSipnosis.clear();
        this.cmbClasificacion.getSelectionModel().select(0);
        this.sldDuracion.setValue(120);

    }

    // metodo guardar
    private int guardar() {
        int resultado = -1;
        try (PeliculasDAO peliculasDAO = new PeliculasDAO()) {
           resultado = peliculasDAO.crearPelicula(txtTitulo.getText(), cmbClasificacion.getSelectionModel().getSelectedIndex(),
                    (int) sldDuracion.getValue(), txtSipnosis.getText());
        } catch (Exception e) {

        }

        return resultado;
    }

    //metodo mostrar datos
    private String mostrar(){
        String resultado;
        return resultado =( "El titulo es" +this.txtTitulo.getText()+ " La duración es de "+ this.sldDuracion.getValue() +" La sipnosis:  "+ this.txtSipnosis.getText() + " y la clasificacion "+cmbClasificacion.getSelectionModel());
    }
}

package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Libro;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.LibroDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class GestionLibroFXMLController implements Initializable{
	@FXML
	private TextField txtCodigo;
	@FXML
	private TextField txtTitulo;
	@FXML
	private TextField txtAutor;
	@FXML
	private TextField txtEditorial;
	@FXML
	private ComboBox <String> cmbBoxEstado;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	
	private ObservableList<String> data;
	private Libro l;
	private LibroDAO cLibro;

	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {

			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String editorial = txtEditorial.getText();
			int codigo = Integer.parseInt(txtCodigo.getText());
			String estado = cmbBoxEstado.getSelectionModel().getSelectedItem();
			
			l = new Libro (codigo,titulo, autor, editorial, estado,0);
			
			
		
			Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
			myStage.close();
		
		
	}
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
	}
	
	public void setLibro (Libro lib) {
		l = lib;
		txtTitulo.setText(l.getTitulo());
		txtCodigo.setText(l.getCodigo() + "");
		txtAutor.setText(l.getAutor());
		txtEditorial.setText(l.getEditorial());
		cmbBoxEstado.getSelectionModel().select(l.getEstado());

	}
	
	public Libro getLibro () {
		return l;
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		data = FXCollections.observableArrayList();
		data.addAll("Nuevo","Usado nuevo", "Usado seminuevo", "Usado estropeado", "Restaurado");
		cmbBoxEstado.setItems(data);
		
		cLibro = new LibroDAO();
	}
}

package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.AlumnoDAO;
import dao.LibroDAO;
import dao.PrestamoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Alumno;
import model.Libro;
import model.Prestamo;

public class GestionPrestamosFXMLController implements Initializable{
	@FXML
	private ComboBox <Libro> cmbBoxLibro;
	@FXML
	private ComboBox <Alumno> cmbBoxAlumno;
	@FXML
	private Button btnCancelar;
	@FXML
	private Button btnAceptar;
	
	private ObservableList<Alumno> dataAlumno;
	private AlumnoDAO cAlumno;
	private ObservableList<Libro> dataLibro;
	private LibroDAO cLibro;
	
	private PrestamoDAO cPrestamo;
	
	private Prestamo p;

	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
	}
	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
		Alumno alum = cmbBoxAlumno.getSelectionModel().getSelectedItem();
		Libro lib = cmbBoxLibro.getSelectionModel().getSelectedItem();
		
		p = new Prestamo(0, alum, lib, LocalDate.now());
			
		try {
			cPrestamo.insertPrestamo(p);
		} catch (SQLException e) {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.initOwner(this.btnCancelar.getScene().getWindow());
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Ha ocurrido un error en la realizacion del prestamo");
			alert.showAndWait();
		}
		
		Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cAlumno = new AlumnoDAO();
		cLibro = new LibroDAO ();
		cPrestamo = new PrestamoDAO();
		
		cargarAlumnos();
		cargarLibros();
		
	}
	
	public Prestamo getPrestamo () {
		return p;
	}
	
	private void cargarAlumnos () {
		dataAlumno = FXCollections.observableArrayList();
		cmbBoxAlumno.setItems(dataAlumno);
		ArrayList<Alumno> lstAlumnos = cAlumno.selectAlumnos();
		
		dataAlumno.clear();
		dataAlumno.addAll(lstAlumnos);
	}
	
	private void cargarLibros () {
		dataLibro = FXCollections.observableArrayList();
		cmbBoxLibro.setItems(dataLibro);
		ArrayList <Libro> lstLibros = cLibro.selectLibrosDisponibles();
		
		dataLibro.clear();
		dataLibro.addAll(lstLibros);
	}
}

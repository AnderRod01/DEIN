package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class PersonaFXMLController implements Initializable {
	@FXML
	private TableView <Persona> tblPersona;
	@FXML
	private TableColumn<Persona,String> colNombre;
	@FXML
	private TableColumn<Persona,String> colApellidos;
	@FXML
	private TableColumn<Persona,Integer> colEdad;
	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnModificar;
	@FXML
	private Button btnEliminar;
	@FXML
	private TextField txtFiltro;
	
	private ObservableList<Persona> data;
	private int iSeleccionado=-1;
	
	private Persona p;
	
	

	// Event Listener on TableView[#tblPersona].onMouseClicked
	@FXML
	public void seleccionarFila(MouseEvent event) {
		if (tblPersona.getSelectionModel().getSelectedItem() != null) {
			btnModificar.setDisable(false);
			btnEliminar.setDisable(false);
			iSeleccionado = tblPersona.getSelectionModel().getSelectedIndex();
			p = tblPersona.getSelectionModel().getSelectedItem();
		}
	}
	
	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregarPersona(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AgregarPersonaFXML.fxml"));
			Parent root =loader.load();
			AgregarPersonaFXMLController controller = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage =(Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Agregar persona");
			stage.showAndWait();
			
			p = controller.getPersona();
			
			if (!data.contains(p)) {
				data.add(p);
			}
			
			else {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnAgregar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Persona existente");
				alert.showAndWait();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificarPersona(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AgregarPersonaFXML.fxml"));
			Parent root = loader.load();
			AgregarPersonaFXMLController controller = loader.getController();
			controller.setPersona(p);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage =(Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Agregar persona");
			stage.showAndWait();
			
			p=controller.getPersona();
			
			if (!data.contains(p)) {
				data.set(iSeleccionado, p);
				btnModificar.setDisable(true);
				btnEliminar.setDisable(true);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#btnEliminar].onAction
	@FXML
	public void eliminarPersona(ActionEvent event) {
		data.remove(iSeleccionado);
		
		
		btnModificar.setDisable(true);
		btnEliminar.setDisable(true);
	}
	
	
	// Event Listener on Button[#btnImportar].onAction
	@FXML
	public void importar(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Abrir fichero");
		File f =  fc.showOpenDialog(null);
		
		
		BufferedReader br;
		try {
			br =  new BufferedReader (new FileReader(f));
			
			String linea = br.readLine();
			
			while (linea!=null) {
				String [] split = linea.split(",");
				Persona p =  new Persona(split[0], split[1], Integer.parseInt(split[2]));
				if (!data.contains(p)) {
					data.add(p);
				}
				linea = br.readLine();
			}
			tblPersona.refresh();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Event Listener on Button[#btnExportar].onAction
	@FXML
	public void exportar(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExportarFXML.fxml"));
		Parent root;
		try {
			root = loader.load();
			ExportarFXMLController controller = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage =(Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Exportar");
			stage.showAndWait();
			
			String fich = controller.getFichero();
			
			File f = new File (fich);
			
			if (!new File(fich).exists()) {
				exportarDatos(fich);
			}
			else {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.initOwner(this.btnEliminar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("Confirmación");
				alert.setContentText(fich + " ya existe. ¿Desea sobrescribirlo?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					exportarDatos(fich);
				} else {
					 
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	private void exportarDatos (String ruta) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
			for (Persona p:data) {
				bw.write(p.getNombre() + "," + p.getApellidos() + "," + p.getEdad());
				bw.newLine();
			}
			bw.close();
			
			
		} catch (IOException e) {
			Alert alert =  new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Error al crear fichero");
			alert.setTitle("ERROR");
			alert.showAndWait();
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		tblPersona.setItems(data);
		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
		colEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
		btnModificar.setDisable(true);
		btnEliminar.setDisable(true);
		
		
		
		//Filtro
		FilteredList<Persona> filteredData = new FilteredList<>(data, p -> true);
		
		
		txtFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (person.getApellidos().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false; 
			});
		});
		

		SortedList<Persona> sortedData = new SortedList<>(filteredData);
		

		sortedData.comparatorProperty().bind(tblPersona.comparatorProperty());
		

		tblPersona.setItems(sortedData);
		
		
		
		
		
	}
}

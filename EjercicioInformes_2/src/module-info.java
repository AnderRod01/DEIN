module EjercicioInformes_2 {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires jasperreports;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
}

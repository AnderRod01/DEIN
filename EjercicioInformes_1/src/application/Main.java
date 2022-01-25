package application;
	
import config.ConexionDB;
import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ConexionDB con = new ConexionDB();
			JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/reportePaises.jasper"));
			JasperPrint jprint = JasperFillManager.fillReport(report, null, con.getConexion());
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

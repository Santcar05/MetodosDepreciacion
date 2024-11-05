package application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EscenariosController {
	private Stage stagePrincipal;
	private AnchorPane anchorPane;
	
	
	public EscenariosController() {
		super();
	}


	public EscenariosController(Stage stagePrincipal) {
		super();
		this.stagePrincipal = stagePrincipal;
	}
	
	
	public void cargarEscenarioPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("EscenaPrincipal.fxml"));
		anchorPane = (AnchorPane) loader.load();
		Scene s = new Scene(anchorPane);
		stagePrincipal.setScene(s);
		stagePrincipal.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	public void cargarEscenario() {
		FXMLLoader = new FXMLLoader();
		loader.setLocation(getClass().getResource("EscenaPrincipal.fxml"))
	}
	*/
}

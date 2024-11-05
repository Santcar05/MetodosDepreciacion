package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaPrincipal.fxml"));
            AnchorPane root = loader.load();

            // Crear la escena con el AnchorPane cargado
            Scene scene = new Scene(root, 400, 400);

            // Configurar el título y la escena del escenario principal
            primaryStage.setTitle("MÉTODOS DE DEPRECIACIÓN");
            primaryStage.setScene(scene);
            primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EscenaPrincipalController {
	@FXML
	private AnchorPane panel;
	@FXML
	private Label titulo;
	@FXML
	private Button lineaRecta;
	@FXML
	private Button sumaDigitos;
	@FXML
	private Button reduccionSaldos;
	@FXML
	private Button unidadesProducidas;

	// Event Listener on Button[#lineaRecta].onAction
	@FXML
	public void activarLineaRecta(ActionEvent event) {
		try {
			// Cargar el archivo FXML de la segunda escena
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaLineaRecta.fxml"));
			Parent escena2Root = loader.load();

			// Obtener el stage actual a partir del bot�n presionado
			Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

			// Crear una nueva escena con el dise�o de Escena2 y asignarla al stage
			Scene escena2 = new Scene(escena2Root);
			stage.setScene(escena2);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	// Event Listener on Button[#sumaDigitos].onAction
	@FXML
	public void activarSumaDigitos(ActionEvent event) {
		try {
			// Cargar el archivo FXML de la segunda escena
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaSumaDigitos.fxml"));
			Parent escena2Root = loader.load();

			// Obtener el stage actual a partir del bot�n presionado
			Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

			// Crear una nueva escena con el dise�o de Escena2 y asignarla al stage
			Scene escena2 = new Scene(escena2Root);
			stage.setScene(escena2);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#reduccionSaldos].onAction
	@FXML
	public void activarReduccionSaldos(ActionEvent event) {
		try {
			// Cargar el archivo FXML de la segunda escena
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaReduccionSaldos.fxml"));
			Parent escena2Root = loader.load();

			// Obtener el stage actual a partir del bot�n presionado
			Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

			// Crear una nueva escena con el dise�o de Escena2 y asignarla al stage
			Scene escena2 = new Scene(escena2Root);
			stage.setScene(escena2);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#unidadesProducidas].onAction
	@FXML
	public void activarUnidadesProducidas(ActionEvent event) {
		try {
			// Cargar el archivo FXML de la segunda escena
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaUnidadesProducidas.fxml"));
			Parent escena2Root = loader.load();

			// Obtener el stage actual a partir del bot�n presionado
			Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

			// Crear una nueva escena con el dise�o de Escena2 y asignarla al stage
			Scene escena2 = new Scene(escena2Root);
			stage.setScene(escena2);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

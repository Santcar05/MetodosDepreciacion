package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class EscenaReduccionSaldosController {
	@FXML
	private Label titulo;
	@FXML
	private Label instruccionInfo;
	@FXML
	private TextField valorActivo;
	@FXML
	private Label panelActivo;
	@FXML
	private TextField valorResidual;
	@FXML
	private Label panelResidual;
	@FXML
	private TextField valorVidaUtil;
	@FXML
	private Label panelVidaUtil;
	@FXML
	private Button botonReduccionSaldos;
	@FXML
	private Label mensajeValorActivo;
	@FXML
	private Label mensajeValorResidual;
	@FXML
	private Label mensajeVidaUtil;

	 private DepreciacionReduccionSaldos dep = new DepreciacionReduccionSaldos();
		
		
	    // Event Listener on TextField[#valorActivo].onKeyPressed
	    @FXML
	    public void verificarActivo(KeyEvent event) throws Exception {
	        BigDecimal vActivo = new BigDecimal(valorActivo.getText());
	        dep.setValorActivo(vActivo);
	    }
	    
	    // Event Listener on TextField[#valorResidual].onKeyPressed
	    @FXML
	    public void verificarResidual(KeyEvent event) throws Exception {
	        BigDecimal vResidual = new BigDecimal(valorResidual.getText());
	        dep.setValorResidual(vResidual);
	    }
	    
	    // Event Listener on TextField[#valorVidaUtil].onKeyPressed
	    @FXML
	    public void verificarVidaUtil(KeyEvent event) throws Exception {
	        int vUtil = Integer.parseInt(valorVidaUtil.getText());
	        dep.setVidaUtil(vUtil);
	    }
		// Event Listener on Button[#botonReduccionSaldos].onAction
		@FXML
		public void GenerarTablaReduccionSaldos(ActionEvent event) {
	        boolean error = false;
	        try {
	            this.verificarActivo(null);
	            this.mensajeValorActivo.setText("");
	        } catch (Exception e) {
	            this.mensajeValorActivo.setText("Digite un n�mero por favor");
	            error = true;
	        }
	        try {
	            this.verificarResidual(null);
	            this.mensajeValorResidual.setText("");
	        } catch (Exception e) {
	            this.mensajeValorResidual.setText("Digite un n�mero por favor");
	            error = true;
	        }
	        try {
	            this.verificarVidaUtil(null);
	            this.mensajeVidaUtil.setText("");
	        } catch (Exception e) {
	            this.mensajeVidaUtil.setText("Digite un n�mero por favor");
	            error = true;
	        }
	        
	        // Entrar a la escena de la tabla de l�nea recta
	        if (!error) {
	            try {
	                ArrayList<TablaDepreciacionReduccionSaldos> lista = dep.calcularReduccionSaldos();
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaTablaReduccionSaldos.fxml"));
	                Parent root = loader.load();

	                // Obtener el controlador
	                EscenaTablaReduccionSaldosController controller = loader.getController();

	                // Pasar la lista al constructor
	                controller.setLista(lista); // Asumiendo que creas un m�todo setLista en tu controlador

	                // Cambiar a la nueva escena
	                Scene scene = new Scene(root);
	                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	                stage.setScene(scene);
	                stage.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		}
}

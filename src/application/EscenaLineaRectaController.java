package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EscenaLineaRectaController {
    private DepreciacionLineaRecta dep = new DepreciacionLineaRecta();
    
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
    private Button botonLineaRecta;
    @FXML
    private Label mensajeValorActivo;
    @FXML
    private Label mensajeValorResidual;

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

    // Event Listener on Button[#botonLineaRecta].onAction
    @FXML
    public void GenerarTablaLineaRecta(ActionEvent event) {
        boolean error = false;
        try {
            this.verificarActivo(null);
            this.mensajeValorActivo.setText("");
        } catch (Exception e) {
            this.mensajeValorActivo.setText("Digite un número por favor");
            error = true;
        }
        try {
            this.verificarResidual(null);
            this.mensajeValorResidual.setText("");
        } catch (Exception e) {
            this.mensajeValorResidual.setText("Digite un número por favor");
            error = true;
        }
        try {
            this.verificarVidaUtil(null);
        } catch (Exception e) {
            error = true;
        }
        
        // Entrar a la escena de la tabla de línea recta
        if (!error) {
            try {
                ArrayList<TablaDepreciacionLineaRecta> lista = dep.calcularLineaRecta();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaTablaLineaRecta.fxml"));
                Parent root = loader.load();

                // Obtener el controlador
                EscenaTablaLineaRectaController controller = loader.getController();

                // Pasar la lista al constructor
                controller.setLista(lista); // Asumiendo que creas un método setLista en tu controlador

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

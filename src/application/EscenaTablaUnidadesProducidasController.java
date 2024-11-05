package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class EscenaTablaUnidadesProducidasController {
	@FXML
	private Label titulo;
	@FXML
	private TableView<TablaDepreciacionUnidadesProducidas> tablaViewUnidadesProducidas;
	@FXML
	private Button botonDescargarArchivo;
	@FXML
	private Button botonRegresarMenu;
	ArrayList<TablaDepreciacionUnidadesProducidas> lista = new ArrayList<TablaDepreciacionUnidadesProducidas>();
	
	
	
	public Label getTitulo() {
		return titulo;
	}
	public void setTitulo(Label titulo) {
		this.titulo = titulo;
	}
	public TableView getTablaViewUnidadesProducidas() {
		return tablaViewUnidadesProducidas;
	}
	public void setTablaViewUnidadesProducidas(TableView tablaViewUnidadesProducidas) {
		this.tablaViewUnidadesProducidas = tablaViewUnidadesProducidas;
	}
	public Button getBotonDescargarArchivo() {
		return botonDescargarArchivo;
	}
	public void setBotonDescargarArchivo(Button botonDescargarArchivo) {
		this.botonDescargarArchivo = botonDescargarArchivo;
	}
	public Button getBotonRegresarMenu() {
		return botonRegresarMenu;
	}
	public void setBotonRegresarMenu(Button botonRegresarMenu) {
		this.botonRegresarMenu = botonRegresarMenu;
	}
	public ArrayList<TablaDepreciacionUnidadesProducidas> getLista() {
		return lista;
	}
	public void setLista(ArrayList<TablaDepreciacionUnidadesProducidas> lista) {
	       this.lista = lista;
	        System.out.println("La lista tiene " + lista.size());
	        ObservableList<TablaDepreciacionUnidadesProducidas> data = FXCollections.observableArrayList();
	        data.addAll(lista);
	        tablaViewUnidadesProducidas.setItems(data);
	}
	
	
    // Este método se llama automáticamente después de que el FXML se ha cargado
    @FXML
    public void initialize() {

        // Crear y configurar columnas
        TableColumn<TablaDepreciacionUnidadesProducidas, Integer> colAnio = new TableColumn<>("Año");
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        TableColumn<TablaDepreciacionUnidadesProducidas, Double> colUniProd = new TableColumn<>("Unidades Producidas");
        colUniProd.setCellValueFactory(new PropertyValueFactory<>("unidadesProducidas"));
        TableColumn<TablaDepreciacionUnidadesProducidas, BigDecimal> colCuota = createColumn("Depreciacion por Unidad", "DepreciacionPorUnidad");
        TableColumn<TablaDepreciacionUnidadesProducidas, BigDecimal> colDepAcum = createColumn("Depreciación Acumulada", "depreciacionAcumulada");
        TableColumn<TablaDepreciacionUnidadesProducidas, BigDecimal> colValorNeto = createColumn("Valor Neto", "valorNeto");

        // Añadir columnas al TableView
        tablaViewUnidadesProducidas.getColumns().addAll(colAnio, colUniProd, colCuota, colDepAcum, colValorNeto);
        
        // Configurar los datos de ejemplo
        ObservableList<TablaDepreciacionUnidadesProducidas> data = FXCollections.observableArrayList(lista);
        tablaViewUnidadesProducidas.setItems(data);
    }

    // Método auxiliar para crear columnas formateadas
    private TableColumn<TablaDepreciacionUnidadesProducidas, BigDecimal> createColumn(String title, String property) {
        TableColumn<TablaDepreciacionUnidadesProducidas, BigDecimal> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<BigDecimal>() {
            @Override
            public String toString(BigDecimal value) {
                return value != null ? String.format("%.3f", value.doubleValue()) : ""; // Formato con tres decimales
            }

            @Override
            public BigDecimal fromString(String string) {
                return string != null && !string.isEmpty() ? new BigDecimal(string) : BigDecimal.ZERO; // Conversión de String a BigDecimal
            }
        }));
        return column;
    }
	
	
	
	// Event Listener on Button[#botonDescargarArchivo].onAction
    @FXML
    public void descargarArchivo(ActionEvent event) {
        // Nombre del archivo
        String fileName = "depreciacion_unidades_producidas.csv";
        
        // Crear el archivo CSV
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            StringBuilder sb = new StringBuilder();
            
            // Agregar encabezados de las columnas
            sb.append("Año,Unidades Producidas,Depreciacion por Unidad,Depreciación Acumulada,Valor Neto\n");
            
            // Recorrer los datos de la tabla y escribir cada fila en el archivo CSV
            for (TablaDepreciacionUnidadesProducidas registro : this.getLista()) {
                sb.append(registro.getAnio()).append(",");
                sb.append(registro.getUnidadesProducidas()).append(",");
                sb.append(registro.getDepreciacionPorUnidad()).append(",");
                sb.append(registro.getDepreciacionAcumulada()).append(",");
                sb.append(registro.getValorNeto()).append("\n");
            }
            
            writer.write(sb.toString());
            System.out.println("Archivo CSV guardado exitosamente en: " + fileName);

            // Mostrar una alerta de confirmación
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Archivo guardado");
            alert.setHeaderText(null);
            alert.setContentText("El archivo CSV se ha guardado exitosamente.");
            alert.showAndWait();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el archivo CSV.");
            
            // Mostrar una alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ocurrió un error al intentar guardar el archivo.");
            alert.showAndWait();
        }
    }

	// Event Listener on Button[#botonRegresarMenu].onAction
	@FXML
	public void devolverMenu(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la segunda escena
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EscenaPrincipal.fxml"));
            Parent escena2Root = loader.load();

            // Obtener el stage actual a partir del botón presionado
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Crear una nueva escena con el diseño de Escena2 y asignarla al stage
            Scene escena2 = new Scene(escena2Root);
            stage.setScene(escena2);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

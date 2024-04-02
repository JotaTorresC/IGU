package co.edu.uniquindio.notas.controladores;

import co.edu.uniquindio.notas.modelo.Nota;
import co.edu.uniquindio.notas.modelo.NotaPrincipal;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioControlador implements Initializable {

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextArea txtNota;

    private final NotaPrincipal notaPrincipal;


    public InicioControlador() {

        notaPrincipal = new NotaPrincipal();

    }

    public void crearNota(ActionEvent e){
        try {

            notaPrincipal.agregarNota(txtTitulo.getText(), txtNota.getText(), txtCategoria.getText());
            mostrarAlerta("Nota creada correctamente", Alert.AlertType.INFORMATION);
            txtTitulo.clear();
            txtNota.clear();
            txtCategoria.clear();

        }catch (Exception ex){

            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);

        }

        tablaNotas.setItems( FXCollections.observableArrayList(notaPrincipal.listarNotas()) );

    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){

        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();

    }

    @FXML
    private TableView<Nota> tablaNotas;

    @FXML
    private TableColumn<Nota, String> colTitulo;

    @FXML
    private TableColumn<Nota, String> colCategoria;

    @FXML
    private TableColumn<Nota, String> colTexto;

    @FXML
    private TableColumn<Nota, String> colFecha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        colTexto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCreacion().toString()));

    }
}

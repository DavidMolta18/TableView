package ui;

import java.util.UUID;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Domicilios;
import model.DomiciliosData;

public class MainWindow extends Stage {

	// UI Components

	private TableView<Domicilios> tabla;
	private TextField pedidoTF;
	private TextField direccionTF;
	private TextField precioTF;
	private Button registrarBtn;
	
	//Datos
	
	private DomiciliosData domicilios;
	
	public MainWindow() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			tabla = (TableView) loader.getNamespace().get("tabla");
			pedidoTF = (TextField) loader.getNamespace().get("pedidoTF");
			direccionTF = (TextField) loader.getNamespace().get("direccionTF");
			precioTF = (TextField) loader.getNamespace().get("precioTF");
			registrarBtn = (Button) loader.getNamespace().get("registrarBtn");
			domicilios = new DomiciliosData();
			init();
			
			// Crear las coulmnas de la tabla
			TableColumn<Domicilios,String> idCol = new TableColumn<>("id");
			TableColumn<Domicilios,String> pedidoCol = new TableColumn<>("pedido");
			TableColumn<Domicilios,Double> precioCol = new TableColumn<>("precio");
			TableColumn<Domicilios,String> direccionCol = new TableColumn<>("direccion");
			
			//Enlaces con los elementos de la tabla
			idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
			pedidoCol.setCellValueFactory(new PropertyValueFactory<>("pedido"));
			precioCol.setCellValueFactory(new PropertyValueFactory<>("precio"));
			direccionCol.setCellValueFactory(new PropertyValueFactory<>("direccion"));
			
			
			tabla.getColumns ().addAll(idCol,pedidoCol,precioCol,direccionCol);
			tabla.setItems(domicilios.getData());
			
		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	public void init() {

		registrarBtn.setOnAction(event -> {

			String id = UUID.randomUUID().toString();
			String pedido = pedidoTF.getText();
			double precio = Double.parseDouble(precioTF.getText());
			String direccion = direccionTF.getText();

			Domicilios d = new Domicilios(id, pedido, precio, direccion);
			domicilios.getData().add(d);
			System.out.println("Datos: " + domicilios.getData().size());
			
		});

	}

}

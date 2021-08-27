package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DomiciliosData {
	private ObservableList<Domicilios> domicilios;
	public DomiciliosData() {
		domicilios = FXCollections.observableArrayList();

	}

	

	public ObservableList<Domicilios> getData() {

		return domicilios;
	}

}

package com.trabalho_final;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import javafx.util.StringConverter;

public class SixthController { // controlador da tela de visualizar produções

    @FXML
    private TableView<Producao> tabelaProducao;

    @FXML
    private TableColumn<Producao, String> colunaNome;

    @FXML
    private TableColumn<Producao, LocalDate> colunaData;

    @FXML
    private TableColumn<Producao, Double> colunaLitros;

    @FXML
    private ComboBox<Month> comboMeses;

    @FXML
    private ComboBox<Vaca> comboVacas;

    @FXML
    private DatePicker datePicker;

    private ObservableList<Producao> producoes; // Lista de produções carregada do banco

    // Método para inicializar os dados ao abrir a tela
    @FXML
    public void initialize() {
        configurarTabela();
        carregarProducoes();
        carregarMeses();
        carregarVacas();
    }

    // Configura as colunas da tabela
    private void configurarTabela() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaLitros.setCellValueFactory(new PropertyValueFactory<>("litros"));
    }

    // Carrega as produções do banco de dados
    private void carregarProducoes() {
        Dao<Producao> producaoDao = new Dao<>(Producao.class);
        List<Producao> listaProducoes = producaoDao.listarTodos(); // Carregar todas as produções do banco
        producoes = FXCollections.observableArrayList(listaProducoes);
        tabelaProducao.setItems(producoes);
    }

    // Carrega a lista de meses no ComboBox
    private void carregarMeses() {
        comboMeses.setItems(FXCollections.observableArrayList(Month.values()));
    }

    // Carrega a lista de vacas no ComboBox
    private void carregarVacas() {
        Dao<Vaca> vacaDao = new Dao<>(Vaca.class);
        List<Vaca> vacas = vacaDao.listarTodos();
        comboVacas.setItems(FXCollections.observableArrayList(vacas));
        
        comboVacas.setCellFactory(listView -> new ListCell<>() {  // Exibir o nome da vaca no ComboBox
            @Override
            protected void updateItem(Vaca vaca, boolean empty) {
                super.updateItem(vaca, empty);
                setText(empty || vaca == null ? null : vaca.getNome());
            }
        });
        comboVacas.setConverter(new StringConverter<>() {
            @Override
            public String toString(Vaca vaca) {
                return vaca == null ? "" : vaca.getNome();
            }

            @Override
            public Vaca fromString(String string) {
                return null; // Não é necessário implementar
            }
        });
    }

    @FXML
    private void filtrarPorMes() {
        Month mesSelecionado = comboMeses.getValue();
        if (mesSelecionado != null) {
            List<Producao> filtradas = producoes.stream()
                .filter(p -> p.getData().getMonth() == mesSelecionado)
                .collect(Collectors.toList());
            tabelaProducao.setItems(FXCollections.observableArrayList(filtradas));
        }
    }

    @FXML
    private void filtrarPorVaca() {
        Vaca vacaSelecionada = comboVacas.getValue();
        if (vacaSelecionada != null) {
            List<Producao> filtradas = producoes.stream()
                .filter(p -> p.getNome().equals(vacaSelecionada.getNome()))
                .collect(Collectors.toList());
            tabelaProducao.setItems(FXCollections.observableArrayList(filtradas));
        }
    }
    
    @FXML // Filtra as produções pela data selecionada
    private void filtrarPorData() {
        LocalDate dataSelecionada = datePicker.getValue();
        if (dataSelecionada != null) {
            List<Producao> filtradas = producoes.stream()
                .filter(p -> p.getData().equals(dataSelecionada))
                .collect(Collectors.toList());
            tabelaProducao.setItems(FXCollections.observableArrayList(filtradas));
        }
    }

    @FXML
    private void limparFiltros() {
        tabelaProducao.setItems(producoes);
        comboMeses.getSelectionModel().clearSelection();
        comboVacas.getSelectionModel().clearSelection();
        datePicker.setValue(null);
    }
    
    @FXML
    private void switchMenu() throws IOException {
        App.setRoot("menu");
    }
}

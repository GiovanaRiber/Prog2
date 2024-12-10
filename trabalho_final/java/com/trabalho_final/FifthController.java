package com.trabalho_final;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.List;

public class FifthController {  // controlador pra tela de Gravar Produções das Vacas
    
    @FXML
    private ComboBox<Vaca> comboVacas;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField litros;

    @FXML
    public void initialize() {
        carregarVacas();
        configurarComboBox(); // configura o ComboBox para exibir o nome da vaca
    }

    // método para carregar a lista de vacas do banco de dados
    private void carregarVacas() {
        Dao<Vaca> vacaDao = new Dao<>(Vaca.class);
        List<Vaca> vacas = vacaDao.listarTodos(); // método que lista todas as vacas do banco

        if (vacas != null && !vacas.isEmpty()) {
            comboVacas.getItems().addAll(vacas);
        } else {
            exibirMensagem(AlertType.WARNING, "Atenção", "Nenhuma vaca encontrada no banco de dados.");
        }
    }

    // método para configurar o ComboBox para exibir o nome das vacas
    private void configurarComboBox() {
        // define como os itens são exibidos na lista suspensa do ComboBox
        comboVacas.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Vaca vaca, boolean empty) {
                super.updateItem(vaca, empty);
                setText(empty || vaca == null ? null : vaca.getNome());
            }
        });

        // define como o item selecionado é exibido no ComboBox
        comboVacas.setConverter(new StringConverter<>() {
            @Override
            public String toString(Vaca vaca) {
                return vaca == null ? "" : vaca.getNome();
            }

            @Override
            public Vaca fromString(String string) {
                return null; 
            }
        });
    }

    @FXML
    private void gravarProducao() {
        Vaca vacaSelecionada = comboVacas.getValue();
        LocalDate dataSelecionada = datePicker.getValue();
        String litrosTexto = litros.getText();

        if (vacaSelecionada == null || dataSelecionada == null || litrosTexto == null || litrosTexto.isEmpty()) {
            exibirMensagem(AlertType.ERROR, "Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        try {
            double litros = Double.parseDouble(litrosTexto);

            Producao producao = new Producao(vacaSelecionada.getNome(), dataSelecionada, litros);

            // gravar no banco de dados
            Dao<Producao> producaoDao = new Dao<>(Producao.class);
            producaoDao.inserir(producao);

            exibirMensagem(AlertType.INFORMATION, "Sucesso", "Produção registrada com sucesso!");
            limparCampos();
        } catch (NumberFormatException e) {
            exibirMensagem(AlertType.ERROR, "Erro", "O valor de litros deve ser numérico.");
        }
    }

    @FXML
    private void limparCampos() {
        comboVacas.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        litros.clear();
    }

    // método para exibir mensagens na tela
    private void exibirMensagem(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    } 
    
    @FXML
    private void switchMenu() throws IOException {
        App.setRoot("menu");
    }
}

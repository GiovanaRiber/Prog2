package com.trabalho_final;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.util.StringConverter;
import javafx.event.ActionEvent;
import java.util.List;

public class FourthController { // controlador da Tela de Atualizar as informações das Vacas

    @FXML
    private ComboBox<Vaca> comboVacas;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoRaca;
    @FXML
    private Button botaoExcluir; // Botão para excluir a vaca

    private Dao<Vaca> daoVaca;

    public FourthController() {
        daoVaca = new Dao<>(Vaca.class);
    }

    @FXML
    public void initialize() {
        configurarComboBox();
        carregarVacas();
        comboVacas.setOnAction(e -> preencherCampos());
    }

    private void configurarComboBox() {
        comboVacas.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Vaca vaca, boolean empty) {
                super.updateItem(vaca, empty);
                setText(empty || vaca == null ? null : vaca.getBrinco());
            }
        });

        // Define como o ComboBox exibe o item selecionado
        comboVacas.setConverter(new StringConverter<>() {
            @Override
            public String toString(Vaca vaca) {
                return vaca == null ? "" : vaca.getBrinco();
            }

            @Override
            public Vaca fromString(String string) {
                return null; // Não é necessário implementar
            }
        });
    }

    private void carregarVacas() {
        try {
            List<Vaca> vacas = daoVaca.listarTodos(); // obter todas as vacas do banco
            comboVacas.getItems().clear(); // limpar lista atual
            comboVacas.getItems().addAll(vacas); // adicionar vacas ao ComboBox
        } catch (Exception e) {
            exibirMensagem("Erro", "Não foi possível carregar as vacas.", AlertType.ERROR);
        }
    }

    private void preencherCampos() {
        Vaca vacaSelecionada = comboVacas.getValue(); // Obter vaca selecionada
        if (vacaSelecionada != null) {
            campoNome.setText(vacaSelecionada.getNome());
            campoRaca.setText(vacaSelecionada.getRaca());
        }
    }

    @FXML
    private void atualizarVaca(ActionEvent event) {
        Vaca vacaSelecionada = comboVacas.getValue();
        if (vacaSelecionada == null) {
            exibirMensagem("Aviso", "Selecione uma vaca para atualizar.", AlertType.WARNING);
            return;
        }

        // Atualizar as informações da vaca selecionada
        String novoNome = campoNome.getText();
        String novaRaca = campoRaca.getText();

        if (novoNome.isBlank() || novaRaca.isBlank()) {
            exibirMensagem("Aviso", "Nome e raça não podem estar vazios.", AlertType.WARNING);
            return;
        }

        vacaSelecionada.setNome(novoNome);
        vacaSelecionada.setRaca(novaRaca);

        try {
            daoVaca.alterar("brinco", vacaSelecionada.getBrinco(), vacaSelecionada);
            exibirMensagem("Sucesso", "Informações atualizadas com sucesso!", AlertType.INFORMATION);
            carregarVacas(); // recarregar lista para refletir a atualização
        } catch (Exception e) {
            exibirMensagem("Erro", "Falha ao atualizar informações.", AlertType.ERROR);
        }
    }

    @FXML
    private void excluirVaca(ActionEvent event) {
        Vaca vacaSelecionada = comboVacas.getValue();
        if (vacaSelecionada == null) {
            exibirMensagem("Aviso", "Selecione uma vaca para excluir.", AlertType.WARNING);
            return;
        }

        try {
            boolean sucesso = daoVaca.excluir("brinco", vacaSelecionada.getBrinco());
            if (sucesso) {
                exibirMensagem("Sucesso", "Vaca excluída com sucesso!", AlertType.INFORMATION);
                carregarVacas(); // recarregar lista após exclusão
                limparCampos(); // limpar campos após exclusão
            } else {
                exibirMensagem("Erro", "Não foi possível excluir a vaca.", AlertType.ERROR);
            }
        } catch (Exception e) {
            exibirMensagem("Erro", "Erro ao excluir a vaca.", AlertType.ERROR);
        }
    }

    private void limparCampos() {
        campoNome.clear();
        campoRaca.clear();
        comboVacas.getSelectionModel().clearSelection();
    }

    private void exibirMensagem(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    private void switchMenu() throws IOException {
        App.setRoot("menu");
    }
}

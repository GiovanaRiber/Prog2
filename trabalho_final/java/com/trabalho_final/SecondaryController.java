package com.trabalho_final;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class SecondaryController { // controlador da Tela de Cadastrar Vaca
     
    @FXML
    private TextField campoNomeVaca;
    
    @FXML
    private TextField campoBrinco;
    
    @FXML
    private TextField campoRaca;
    
    @FXML
    private TextField ButtonSair;
     
    @FXML
    private TextField ButtonOk;

    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
    
    @FXML
    public void InserirVaca() { // Método para inserir a vaxa no banco de dados
        
        String nome = campoNomeVaca.getText();
        String brinco = campoBrinco.getText();
        String raca= campoRaca.getText();
        
        if (nome.isEmpty() || brinco.isEmpty() || raca.isEmpty()) {
            mensagemErro("Campos obrigatórios não preenchidos");
            return;
        }
        
        try{
            
            Dao<Vaca> dao = new Dao(Vaca.class);
            Vaca temp = dao.buscarPorChave("brinco", brinco);
            
            if(temp != null) {
                mensagemErro("Brinco ja utilizado");
                return;
            };
            
            Vaca vaca = new Vaca(brinco, nome , raca);
            dao.inserir(vaca);
            limpar();
            mensagemErro("Vaca Cadastrada");
            
        } catch (Exception e) {
            mensagemErro("Erro desconhecido: " + e.getMessage());
        }
        
    }
    
    @FXML
    private void limpar() {
        campoNomeVaca.clear();
        campoBrinco.clear();
        campoRaca.clear();
    }
    
    private void mensagemErro(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
package com.trabalho_3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorTela {
    
    private ArrayList<Clientes> listaClientes = new ArrayList<>();
    private Buscador buscador = new Buscador();
    
    @FXML
    private TextField campoNome;
    
    @FXML
    private TextField campoNumero;
    
    @FXML
    private TextField campoCEP;
    
    @FXML
    private TextField campoCidade;
    
    @FXML
    private TextField campoEstado;
    
    @FXML
    private TextField campoRua;
    
    @FXML
    private TextField campoTelefone;
    
    @FXML
    private TextField campoN;
    
    @FXML
    private void sair() {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void limpar() {
        campoNome.clear();
        campoNumero.clear();
        campoCEP.clear();
        campoCidade.clear();
        campoEstado.clear();
        campoRua.clear();
        campoTelefone.clear();
    }
    
    @FXML
    private void gerar() {
        try {
            
            Clientes cliente = new Clientes();
            
            String nome = campoNome.getText();
            String cep = campoCEP.getText();
            String telefone = campoTelefone.getText();
            String numero = campoNumero.getText();
            String rua = campoRua.getText();
            String cidade = campoCidade.getText();
            String estado = campoEstado.getText();

            if (nome.isEmpty() || cep.isEmpty() || telefone.isEmpty()) {
                mensagemErro("Campos obrigatórios não preenchidos");
                return;
            }

            Endereco endereco = new Endereco(cep, rua, numero, cidade, estado);
            
            listaClientes.add(cliente);
            campoN.setText(String.valueOf(cliente.getCodigo()));
            
            mensagemErro("Cliente cadastrado com sucesso!");
            
        } catch (Exception e) {
            mensagemErro("Não foi possível gerar o cliente: " + e.getMessage());
        }
    }
    
    @FXML
    private void buscar() {
        String cep = campoCEP.getText();

        if (cep.isEmpty()) {
            mensagemErro("Por favor, insira um CEP para buscar o endereço.");
            return;
        }

        try {
            Endereco endereco = buscador.buscar(cep);
            campoRua.setText(endereco.getRua());
            campoCidade.setText(endereco.getCidade());
            campoEstado.setText(endereco.getEstado());
        
        } catch (IllegalArgumentException e) {
            mensagemErro("Formato de CEP inválido. Utilize o formato 99999-999.");
        } catch (IOException e) {
            mensagemErro("Não foi possível conectar ao serviço de busca de CEP. Verifique sua conexão com a internet.");
        } catch (Exception e) {
            mensagemErro("Ocorreu um erro ao buscar o endereço: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    
    private void mensagemErro(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
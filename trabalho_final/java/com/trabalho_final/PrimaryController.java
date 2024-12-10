package com.trabalho_final;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PrimaryController { // controlador da Tela de Cadastrar Usuário
    
    @FXML
    private TextField campoNomeUsuario;
    
    @FXML
    private TextField campoLogin;
    
    @FXML
    private TextField campoSenha;
    
    @FXML
    private TextField ButtonSair;
     
    @FXML
    private TextField ButtonOk;
    
    @FXML
    public void InserirUsuario() { // Método pra inserir o usuário no banco de dados
        
        String nome = campoNomeUsuario.getText();
        String login = campoLogin.getText();
        String senha = campoSenha.getText();
        
        if (nome.isEmpty() || login.isEmpty() || senha.isEmpty()) {
            mensagemErro("Campos obrigatórios não preenchidos");
            return;
        }
        
        try{
            
            Dao<Usuario> dao = new Dao(Usuario.class);
            Usuario temp = dao.buscarPorChave("login", login);
            
            if(temp != null) {
                mensagemErro("Login ja utilizado");
                return;
            };
            
            Usuario usuario = new Usuario(nome, login, senha);
            dao.inserir(usuario);
            limpar();
            mensagemErro("Usuario Cadastrado");
            
        } 
        catch (Exception e) {
            mensagemErro("Erro desconhecido: " + e.getMessage());
        }
    }
    
    @FXML
    private void limpar() {
        campoNomeUsuario.clear();
        campoLogin.clear();
        campoSenha.clear();
    }
    
    private void mensagemErro(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void goToLogin() throws IOException {
        App.setRoot("loginTela");
    }
    
}

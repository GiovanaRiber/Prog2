package com.trabalho_final;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import java.io.IOException;

public class TertiaryController { // controlador da tela de Menu e Login

    private static Usuario usuarioLogado; // Variável estática para armazenar o usuário logado

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoNovoNome;

    @FXML
    private TextField campoNovaSenha;

    private Dao<Usuario> daoUsuario;

    public TertiaryController() {
        daoUsuario = new Dao<>(Usuario.class);
    }
    
     @FXML
    private void goToMenu() throws IOException {
        App.setRoot("menu"); // Navega para menu.fxml
    }

    @FXML
    private void switchMenu() throws IOException { // Ir para o menu após o login
        String login = campoNome.getText();
        String senha = campoSenha.getText();

        if (login.isBlank() || senha.isBlank()) {
            exibirMensagem("Aviso", "Por favor, preencha todos os campos.", AlertType.WARNING);
            return;
        }

        try {
            Usuario usuario = daoUsuario.buscarPorChave("login", login);
            if (usuario != null && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario; // Armazena o usuário logado
                App.setRoot("menu"); // Navega para a tela de menu
            } else {
                exibirMensagem("Erro", "Login ou senha incorretos.", AlertType.ERROR);
            }
        } catch (Exception e) {
            exibirMensagem("Erro", "Erro ao validar login.", AlertType.ERROR);
        }
    }

    // Método para navegar para a tela de cadastro de usuário
    @FXML
    private void goToUsuario() throws IOException {
        App.setRoot("cadastrarUsuario"); // Navega para cadastroUsuario.fxml
    }

    // Preenche os campos de atualização com os dados do usuário logado
    @FXML
    private void carregarDadosUsuario() {
        if (usuarioLogado != null) {
            campoNovoNome.setText(usuarioLogado.getNome()); 
            campoNovaSenha.setText(usuarioLogado.getSenha());
        }
    }

    @FXML
    private void atualizarUsuario() {
        if (usuarioLogado == null) {
            exibirMensagem("Erro", "Nenhum usuário está logado.", AlertType.ERROR);
            return;
        }

        String novoNome = campoNovoNome.getText();
        String novaSenha = campoNovaSenha.getText();

        if (novoNome.isBlank() || novaSenha.isBlank()) {
            exibirMensagem("Aviso", "Por favor, preencha todos os campos.", AlertType.WARNING);
            return;
        }

        try {
            // Atualiza apenas os campos nome e senha, sem alterar o login
            usuarioLogado.setNome(novoNome);
            usuarioLogado.setSenha(novaSenha);
            daoUsuario.alterar("login", usuarioLogado.getLogin(), usuarioLogado);
            exibirMensagem("Sucesso", "Dados do usuário atualizados com sucesso!", AlertType.INFORMATION);
        } catch (Exception e) {
            exibirMensagem("Erro", "Erro ao atualizar dados do usuário.", AlertType.ERROR);
        }
    }

    @FXML
    private void excluirUsuario() throws IOException {
        if (usuarioLogado == null) {
            exibirMensagem("Erro", "Nenhum usuário está logado.", AlertType.ERROR);
            return;
        }

        try {
            daoUsuario.excluir("login", usuarioLogado.getLogin());
            usuarioLogado = null; // Remove o usuário logado
            exibirMensagem("Sucesso", "Usuário excluído com sucesso.", AlertType.INFORMATION);
            App.setRoot("loginTela"); // Volta para a tela de login
        } catch (Exception e) {
            exibirMensagem("Erro", "Erro ao excluir usuário.", AlertType.ERROR);
        }
    }

    // Métodos relacionados ao menu
    @FXML
    private void goToVaca() throws IOException {
        App.setRoot("cadastroVaca"); // Navega para cadastroVaca.fxml
    }
    
    @FXML
    private void goToAtualizarUsuario() throws IOException {
        App.setRoot("atualizarUsuario"); // Navega para atualizarUsuario.fxml
    }

    @FXML
    private void goToCadastroProducao() throws IOException {
        App.setRoot("cadastrarProducao"); // Navega para cadastroProducao.fxml
    }

    @FXML
    private void goToAtualizarVaca() throws IOException {
        App.setRoot("atualizarVaca"); // Navega para atualizarVaca.fxml
    }

    @FXML
    private void goToListarPoducoes() throws IOException {
        App.setRoot("listarProducoes"); // Navega para listarProducoes.fxml
    }
    
    @FXML
    private void goToLogin() throws IOException {
        App.setRoot("loginTela"); // Navega para loginTela.fxml
    }

    @FXML
    private void sair() {
        Platform.exit();
        System.exit(0);
    }

    // Método auxiliar para exibir mensagens ao usuário
    private void exibirMensagem(String titulo, String mensagem, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

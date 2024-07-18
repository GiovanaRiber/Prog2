package com.trabalho_2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ControladorEstoque {
    
    @FXML
    private TextField campoEstoque;
    
    private Estoque coxinhas;
    
     @FXML
    private TextField campoEstoque2;
    
     @FXML
    private void initialize(){
        coxinhas = new Estoque(); 
        campoEstoque.setText(String.valueOf(coxinhas.getCoxinhas()));
    }
    
    @FXML
    private void abastecer(){
        
        Integer quantidade = Integer.valueOf(campoEstoque2.getText());
        
        coxinhas.abastecer(quantidade);
        campoEstoque.setText(String.valueOf(coxinhas.getCoxinhas()));
    }
    
    @FXML
    private void venderUm(){
        
        if(coxinhas.getCoxinhas() == 0){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Não há coxinhas para vender");
            alert.show();
            return; 
        }
        coxinhas.venderUm();
        campoEstoque.setText(String.valueOf(coxinhas.getCoxinhas()));
    }
    
    @FXML
    private void vender(){
        
        Integer quantidade = Integer.valueOf(campoEstoque2.getText());
        
        if(coxinhas.getCoxinhas() < quantidade){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Não há coxinhas o suficiente");
            alert.show();
            return; 
        }
        coxinhas.vender(quantidade);
        campoEstoque.setText(String.valueOf(coxinhas.getCoxinhas()));
    }
    
    @FXML
    private void zerar(){
        coxinhas.zerar();
        campoEstoque.setText(String.valueOf(coxinhas.getCoxinhas()));
    }
     
    @FXML
    private void sair(){
        Platform.exit();
        System.exit(0);
    }
  
}

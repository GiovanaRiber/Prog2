package Capitulo_4;

//Exercício 1

public class Linha {
    
    int comprimento;
    
    Linha(int comprimento){
        
        this.comprimento = comprimento;
        
    }
    
    Linha(){
        
        comprimento = 0;
        
    }
    
    void desenhar(int comprimento){
        
        for(int i = 0; i < comprimento; i++){
            
            System.out.print("_");
            
        }  
    }
    
    
    public static void main(String[] args) {

    Linha linha = new Linha();

    linha.desenhar(5);
    
    }
}

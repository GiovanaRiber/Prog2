package Capitulo_4;

//Exercício 4

public class Carro {
    
    String marca;
    String modelo;
    int ano;
    int velocidade;
    
    Carro() {
        
        marca = "";
        modelo = "";
        ano = 1920;
        velocidade = 0; 
    }
    
    Carro(String marca, String modelo, int ano, int velocidade) {
        
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = velocidade;
    }
   
    void acelerar(){
        
        if(velocidade < 200)
            velocidade++;   
    }
    
    void frear(){
        
        if(velocidade > 0)
            velocidade--;    
    }
    
    public static void main(String[] args) {
        
        Carro carro = new Carro();
        
        carro.acelerar();
        carro.acelerar();
        
        System.out.println("Velocidade: " + carro.velocidade);
    }
}

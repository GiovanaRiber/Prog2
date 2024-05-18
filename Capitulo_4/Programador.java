package Capitulo_4;

//Exercício 6

public class Programador {
    
    String nome;
    double salarioMensal, valorExtra;
    int horas;
    
    Programador() {
        
        nome = "";
        salarioMensal = 0;
        horas = 2;
        valorExtra = 0;  
    }
    
    Programador(String nome, double salarioMensal, int horas, double valorExtra) {
        
        this.nome = nome;
        this.salarioMensal = salarioMensal;
        this.horas = horas;
        this.valorExtra = valorExtra;
    }
    
    double calculaSalario(double valorExtra) {
        
        return salarioMensal + (horas * valorExtra);
    }
    
    public static void main(String[] args) {
        
        Programador programador = new Programador();
        
        System.out.println("Salario: " + programador.calculaSalario(50.00));
    }
}

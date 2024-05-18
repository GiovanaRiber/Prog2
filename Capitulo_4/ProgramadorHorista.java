package Capitulo_4;

//Exercício 3

public class ProgramadorHorista {
    
    int horasTrabalhadas;
    double valorHoras;
    
    ProgramadorHorista() {
        
        horasTrabalhadas = 0;
        valorHoras = 0;
    }
    
    ProgramadorHorista(int horasTrabalhadas, double valorHoras){
        
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHoras = valorHoras;
    }
    
    double calculaSalario(int horasTrabalhadas, double valorHoras){
       
       return horasTrabalhadas * valorHoras;
    }
    
    public static void main(String[] args) {
        
        ProgramadorHorista x = new ProgramadorHorista();
        
        System.out.println("Salario: " + x.calculaSalario(2, 50.00));
    }
}

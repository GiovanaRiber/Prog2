package Capitulo_4;

class Dupla{
    
    String aluno;
    int matricula;
    
    Dupla(){
        
        aluno = "";
        matricula = 0;
    }
    
    Dupla(String aluno, int matricula){
        
        this.aluno = aluno;
        this.matricula = matricula;  
    }  
}

public class Aluno {
    
    Dupla aluno1 = new Dupla();
    Dupla aluno2 = new Dupla();
    
    Aluno(){
       
        aluno1.aluno = "Maria";
        aluno1.matricula = 101;
        aluno2.aluno = "Jose";
        aluno2.matricula = 102;
    }
    
    void mostrarDupla(){
        
        System.out.println("Aluno A: " + aluno1.aluno + " - Matricula: " + aluno1.matricula);
        System.out.println("Aluno B: " + aluno2.aluno + " - Matricula: " + aluno2.matricula);
    }
    
    public static void main(String[] args) {
        
        Aluno aluno = new Aluno();
        
        aluno.mostrarDupla();
    } 
}

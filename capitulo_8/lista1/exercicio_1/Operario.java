package capitulo_8.lista1.exercicio_1;

import capitulo_8.lista1.exercicio_1.Funcionario;

public class Operario implements Funcionario{
    
    private double salarioDia;
    private int diasTrabalhados;
    
    public Operario(double salarioDia, int diasTrabalhados){
        this.salarioDia = salarioDia;
        this.diasTrabalhados = diasTrabalhados;
    }
    
    public void setSalarioDia(double salarioDia){
        this.salarioDia = salarioDia;
    }
    
    public double getSalarioDia(){
        return salarioDia;
    }
    
    public void setDiasTrabalhados(int diasTrabalhados){
        this.diasTrabalhados = diasTrabalhados;
    }
    
    public double geDiasTrabalhados(){
        return diasTrabalhados;
    }
    
    @Override
    public double calculaSalario(){
        return salarioDia * diasTrabalhados;
    }
}

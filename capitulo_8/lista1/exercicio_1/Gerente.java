package capitulo_8.lista1.exercicio_1;

import capitulo_8.lista1.exercicio_1.Funcionario;

public class Gerente implements Funcionario{
    
    private double salarioMes;
    
    public Gerente(double salarioMes){
        this.salarioMes = salarioMes;
    }
    
    public void setSalarioMes(double salarioMes){
        this.salarioMes = salarioMes;
    }
    
    public double getSlarioMes(){
        return salarioMes;
    }
    
    @Override
    public double calculaSalario(){
        return salarioMes + (salarioMes * 0.10);
    }
    
}

package capitulo_7.Lista1;

import capitulo_7.Lista1.Funcionario;

public class Gerente extends Funcionario{
    
    private double gratificacao;
    
    public Gerente(){
        setNome("");
        setSalario(0.0);
        setCodigo(0);
        gratificacao = 0;
    }
    
    public void setGerente(String nome, double salario, int codigo, double gratificacao){
        setNome(nome);
        setSalario(salario);
        setCodigo(codigo);
        this.gratificacao = gratificacao;
    }
    
    public double mostrarSalario(double desconto){
        return getSalario() + gratificacao - desconto;
    }
    
    public static void main(String[] args){
        
        Gerente gerente = new Gerente();
        
        gerente.setGerente("Paula", 2200.00, 120, 150);
        
        System.out.println("Salario: " + gerente.mostrarSalario(50));
    }
}

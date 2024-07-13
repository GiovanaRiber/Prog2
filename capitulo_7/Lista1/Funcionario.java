package capitulo_7.Lista1;

public class Funcionario extends Pessoa{
    
    private double salario;
    private String nome;
    private int codigo;
    
    public Funcionario(){
        nome = "";
        codigo = 0;
        salario = 0.0;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public double getSalario(){
        return salario;
    }
    
    public double mostrarSalario(double desconto){
        return salario - desconto;
    }
}

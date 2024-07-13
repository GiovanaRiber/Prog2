package capitulo_7.Lista1;

public class Pessoa {
    
    private String nome;
    private int codigo;
    
    public Pessoa(){
        nome = "";
        codigo = 0;
    }
    
    public void setPessoa(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getCodigo(){
        return codigo;
    }
}

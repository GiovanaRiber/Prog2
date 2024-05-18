package Capitulo_6;

public class SomaMult {
    
    private String codigo;
    private int num;
    
    SomaMult(){
    
        codigo = "";
        num = 0;
    }
    
    SomaMult(String codigo, int num){
    
        this.codigo= codigo;
        this.num = num;
    }
    
    public int operacao(String codigo, int ...num){
        
        int soma = 0;
        int mult = 1;
        
        if(codigo.equals("SOM")){
            
            
            for(int i: num){
               
                soma += i;
                
            }
            return soma;
        }
        
        if(codigo.equals("MULT")){
            
            
            for(int i: num){
               
                mult *= i;
                
            }
            return mult;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        
        String codigo = "MULT";
        
        SomaMult somaMult = new SomaMult();
        
        int resultado = somaMult.operacao(codigo, 1,2,4);
        
        System.out.println("Resultado: " + resultado); 
    }    
}

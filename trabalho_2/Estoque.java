package com.trabalho_2;

public class Estoque {
    
    private int coxinhas;
    
    public Estoque(){
        
        coxinhas = 0;
    }
    
    public void abastecer(int quantidade){
        
        coxinhas = quantidade;
    }
    
    public void venderUm(){
        
        if(coxinhas > 0)
            coxinhas--;
    }
    
    public void vender(int quantidade){
        
        if(coxinhas >= quantidade)
            coxinhas = coxinhas - quantidade;
    }
    
    public void zerar(){
        coxinhas = 0;
    }
    
    public int getCoxinhas(){
        return coxinhas;
    }
    
}

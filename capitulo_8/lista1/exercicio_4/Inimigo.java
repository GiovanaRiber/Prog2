package capitulo_8.lista1.exercicio_4;

import capitulo_8.lista1.exercicio_4.IPersonagem;

public class Inimigo implements IPersonagem{
    
    Ponto p1;
    
    public Inimigo(){
        
        p1 = new Ponto(6, 6); 
    }
    
    @Override
    public Ponto getPosicao(){
        
        return p1;
    }
    
}

package capitulo_8.lista1.exercicio_4;

import capitulo_8.lista1.exercicio_4.IPersonagem;

public class Heroi implements IPersonagem{
    
    Ponto p2;
    
    public Heroi(){
        
        p2 = new Ponto(5, 2);
    }
    
    @Override
    public Ponto getPosicao(){
        
        return p2;
    }
    
    

}

package capitulo_7.Teste;

public class CaminhaoBiTrem {
    
    public CaminhaoBiTrem(String marca, Integer ano, Double valor){
        
        marca = "";
        ano = 0;
        valor = 0.0;
    }
    
    public static Double calculaIPVA(Integer ano, Double valor){
        
        if(ano > 2004){
            
            return valor * 0.045;
        }
        return 0.0;
    }
    
}

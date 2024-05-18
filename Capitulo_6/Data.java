package Capitulo_6;

class Util{
    
    static String formatarData(Data localData){
        
        return localData.getDia(localData) + "/" + localData.getMes(localData) + "/" + localData.getAno(localData);
    }
}

public class Data {
    
    private int dia, mes, ano;
    
    Data() {
        
       ano = 2024;
       dia = 12;
       mes = 5;   
    }
    
    Data(int dia, int mes, int ano){
        
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public void setMudarData(Data localData, int x) {
        
        localData.ano = x;
    }
    
    public void setMudarData(Data localData, int x, int y) {
        
        localData.mes = x;
        localData.dia = y;
    }
    
    public void setMudarData(Data localData, int x, int y, int z) {
        
        localData.dia = x;
        localData.mes = y;
        localData.ano = z;
    }
    
    public int getDia(Data localData) {
        
        return  localData.dia;
    }
    
    public int getMes(Data localData) {
        
        return  localData.mes;
    }
    
    public int getAno(Data localData) {
        
        return  localData.ano;
    }
    
    
    public static void main(String[] args) {

        Data data = new Data();
        
        data.setMudarData(data, 1925);
        data.setMudarData(data, 5, 12);
        data.setMudarData(data, 1, 6, 1980);
        
        System.out.println(Util.formatarData(data));
    }
}

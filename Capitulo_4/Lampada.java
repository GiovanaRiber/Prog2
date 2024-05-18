package Capitulo_4;

class Lampadaa{

  boolean campo;

  Lampadaa(){
    
    campo = false;
  }

  void acender(){

    campo = true;
  }

  void apagar(){

    campo = false;
  }

  void mostrarCampo(){

    if(campo == true){

      System.out.println("A lampada esta acesa");

    }else{

      System.out.println("A lampada esta apagada");
    }
  }
}


public class Lampada {
    
    public static void main(String[] args) {

    Lampadaa lampada = new Lampadaa();

    lampada.acender();
    lampada.mostrarCampo();
    lampada.apagar();
    lampada.mostrarCampo();
  }
}

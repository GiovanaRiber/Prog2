package capitulo_8.lista1.exercicio_1;
import java.util.Collections;
import java.util.ArrayList;

public class FolhaPagamento {
    
    public static void main(String[] args){
        
        ArrayList<Funcionario> lista = new ArrayList();
        
        lista.add(new Operario(25.00, 6));
        lista.add(new Operario(15.00, 5));
        lista.add(new Gerente(2600.00));
        lista.add(new Gerente(2800.00));
   
        for(Funcionario a : lista){
            System.out.println(a.calculaSalario());
        }
        
        Collections.sort(lista, new SalarioComparator());
        
        for(Funcionario a : lista){
            System.out.println(a.calculaSalario());
        }
    } 
}

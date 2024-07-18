package capitulo_8.lista1.exercicio_1;
import capitulo_8.lista1.exercicio_1.Funcionario;
import java.util.Comparator;

public class SalarioComparator implements Comparator<Funcionario>{
    
    @Override
    public int compare(Funcionario x, Funcionario y){
        
        if(x.calculaSalario() < y.calculaSalario()){
            return -1;
        }
        if(x.calculaSalario() == y.calculaSalario()){
            return 0;
        }
        return 1;
    }
}

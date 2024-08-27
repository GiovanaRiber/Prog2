package capitulo_9;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Dividir {
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        while(true){
            
            try{
                System.out.println("Digite o valor de a: ");
                int a = scanner.nextInt();
            
                System.out.println("Digite o valor de b: ");
                int b = scanner.nextInt();
                
                double x = a/b;

                System.out.println("O resultado é: " + x);
                break;
                        
            }catch(ArithmeticException ae){
                System.out.println("Erro ao dividir, tente novamente !");
                
            }catch(InputMismatchException e){
                System.out.println("Caractere invalido, tente novamente !");
                scanner.next();
            }
        }
        scanner.close();
    }
}

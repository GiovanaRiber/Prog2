package Trabalho_1;

public class Main {
    
    public static void main(String[] args) {
        
        String caminho = "C:/Users/giova/OneDrive/Documentos/NetBeansProjects/Prog_II/src/main/java/Trabalho_1/Arquivo.txt";
        
        SpamDetector spamDetector =  new SpamDetector();
        
        LerArquivo lerArquivo = new LerArquivo();
        
        String conteudo = lerArquivo.lerArquivo(caminho);
        
        System.out.println("Conteudo do arquivo:");
        System.out.println(conteudo);
        
        int pontos = spamDetector.contagem(conteudo);
        
        spamDetector.resultado(pontos);
    }
}

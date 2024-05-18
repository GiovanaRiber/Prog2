package Trabalho_1;

public class SpamDetector {
    
    public static class Lista {
        
        private String[][] tabela;
        
        Lista() {
            
            tabela = new String[][] {
                
                {"voce ganhou", "8"},
                {"tentativa de entrega", "7"},
                {"emprestimo para negativa", "10"},
                {"oferta expira hoje", "4"},
                {"conforme suas informacoes", "7"},
                {"sua conta foi comprometida", "10"},
                {"voce foi selecionado", "8"},
                {"desconto exclusivo", "8"},
                {"cartao de credito", "9"},
                {"atualizacao necessaria", "7"}
            };
        }
        
        Lista(String[][] tabela){
            
            this.tabela = tabela;
        }
        
        public String[][] getTabela() {
            return tabela;
        }
    }
    
    public static int contagem(String conteudo){
        
        Lista lista = new Lista();
        
        String[][] tabela = lista.getTabela();
        
        int pontos = 0;
        
        for (String[] coluna : tabela) {
            
            if (conteudo.contains(coluna[0]))
                pontos += Integer.parseInt(coluna[1]);
        }
        return pontos;
    }
    
    public void resultado(int pontos) {
        
        if (pontos > 4 && pontos <= 30)
            System.out.println("Fracamente suspeito!");
        
        if (pontos > 30 && pontos <= 70) 
            System.out.println("Potencialmente suspeito!");
       
        if (pontos > 70) 
            System.out.println("SPAM!");
     
        if (pontos == 0)
            System.out.println("Seguro!");
    }
}

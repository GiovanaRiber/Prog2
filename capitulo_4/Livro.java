package Capitulo_4;

//Exercício 5

class Autor {
    
    String nome;
    String genero;  
}

public class Livro {
    
    int paginas;
    String titulo;
    String editora;
    
    Autor autor = new Autor();
    
    
    Livro() {
        
        paginas = 0;
        titulo = "";
        editora = "";
        autor.nome = "";
        autor.genero = ""; 
    }
    
    Livro(int paginas, String titulo, String editora, String nome, String genero) {
        
        this.paginas = paginas;
        this.titulo = titulo;
        this.editora = editora;
        nome = autor.nome;
        genero = autor.genero;
    }
}

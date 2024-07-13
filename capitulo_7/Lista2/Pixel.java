package capitulo_7.Lista2;

public class Pixel extends Ponto{
    
    private String cor;
    
    public Pixel() {
        setX(0);
        setY(0);
        cor  = "preta";
    }
    
    public Pixel(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public Pixel(int x, int y, String cor) {
        setX(x);
        setY(y);
        this.cor = cor;
    }
}

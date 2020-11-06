import java.awt.Color;

public class ColorRegion {

    static int w = 512;
	static int h = 512;
    static Image img = new Image(w, h);
    static Color color;
    
    public static void drawColor(int x, int y){
        drawColor(x, y, img.getPixel(x, y));
    }
    
    public static void drawColor(int x, int y, int corInicial){

        if(x > w || y > h || x < 0 || y < 0)
            return;

        if(img.getPixel(x,y) == corInicial)
            return;
 
        img.setPixel(x,y);
            
        drawColor(x+1, y, corInicial);
        drawColor(x-1, y, corInicial);
        drawColor(x, y+1, corInicial);
        drawColor(x, y-1, corInicial);
    }

    public static void main(String [] args){
        img.setBgColor(255, 255, 255);
        img.clear();
        img.setColor(0, 0, 0);
        img.drawLine(0,20,512,20);

        img.setColor(255,0,0);
        
        drawColor(0,0);
        
        img.save("teste.png");
    }
}

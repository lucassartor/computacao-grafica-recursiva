// Esqueleto da classe na qual devem ser implementadas as novas funcionalidades de desenho

public class ImageEx extends Image {

	public ImageEx(int w, int h, int r, int g, int b){

		super(w, h, r, g, b);
	}

	public ImageEx(int w, int h){

		super(w, h);
	}

	public static int lineSize(int x1, int y1, int x2, int y2) {
		 
		int size = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return size;
	}

	public void kochCurve(int x1, int y1, int x2, int y2, int l){

		//DeltaX e DeltaY
		int dx = x2-x1;
		int dy = y2-y1;
		
		//Ponto P
		int Px = x1;
		int Py = y1;

		//Ponto Q
		int Qx = x2;
		int Qy = y2;

		//Tamanho de PQ
		int c = lineSize(Px, Py, Qx, Qy);

		if(c < l){
			drawLine(Px, Py, Qx, Qy);
		}
		else{
			//Ponto A
			int Ax = (int) (Px + (dx/3));
			int Ay = (int) (Py + (dy/3));
			
			//Ponto C
			int Cx = (int) (Qx - (dx/3));
			int Cy = (int) (Qy - (dy/3));

			//Ponto B
			int Bx = (int) ((Px+Qx)/2 - (Math.sqrt(3.0)/6)*(Py-Qy));
			int By = (int) ((Py+Qy)/2 - (Math.sqrt(3.0)/6)*(Qx-Px));

			//Recursão
			kochCurve(Px, Py, Ax, Ay, l);
			kochCurve(Ax, Ay, Bx, By, l);
			kochCurve(Bx, By, Cx, Cy, l);
			kochCurve(Cx, Cy, Qx, Qy, l);
		}
	}

	public void regionFill(int x, int y){
		regionFill(x, y, getPixel(x, y));
	}

	public void regionFill(int x, int y, int reference_rgb){
        if(x > getWidth() || y > getHeight() || x < 0 || y < 0)
            return;

        if(getPixel(x,y) != reference_rgb)
            return;
		
        setPixel(x,y);
            
        regionFill(x+1, y, reference_rgb);
        regionFill(x-1, y, reference_rgb);
        regionFill(x, y+1, reference_rgb);
        regionFill(x, y-1, reference_rgb);
	}
}

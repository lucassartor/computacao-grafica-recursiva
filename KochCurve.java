public class KochCurve {

	static int w = 512;
	static int h = 512;
	static Image img = new Image(w, h);

	public static int lineSize(int x1, int y1, int x2, int y2) {
		int size = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		return size;
	}

	public static void drawKochCurve(int x1, int y1, int x2, int y2, int l) {
		img.setBgColor(0, 0, 0);

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
			img.drawLine(Px, Py, Qx, Qy);
			img.save("kochCurve.png");
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
			drawKochCurve(Px, Py, Ax, Ay, l);
			drawKochCurve(Ax, Ay, Bx, By, l);
			drawKochCurve(Bx, By, Cx, Cy, l);
			drawKochCurve(Cx, Cy, Qx, Qy, l);
		}
	}
}

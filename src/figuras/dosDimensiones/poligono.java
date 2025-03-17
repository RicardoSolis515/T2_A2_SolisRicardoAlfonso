package figuras.dosDimensiones;

import figuras.figura;

public class poligono {

	public rombo crearRombo(double ancho, double alto) {
		return new rombo(ancho, alto);
	}
	
	protected class rombo extends figura{
		private double ancho;
		private double alto;
		private double lado;
		
		
		
		public rombo(double ancho,double alto) {
			this.ancho = ancho;
			this.alto = alto;
			lado = Math.sqrt(Math.pow(ancho/2, 2) + Math.pow(alto/2, 2));
		}
		
		public double getPerimetro() {
			return lado*4;
		}
		
		public double getArea() {
			return ancho*alto/2;
		}
		
		public double getAncho() {
			return ancho;
		}
		
		public void setAncho(double ancho) {
			this.ancho = ancho;
		}
		
		public double getAlto() {
			return alto;
		}
		
		public void setAlto(double alto) {
			this.alto = alto;
		}
		
		
		
		
	}
	
}

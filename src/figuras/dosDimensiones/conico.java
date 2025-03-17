package figuras.dosDimensiones;

import figuras.figura;

public class conico{
	
	public circulo crearCirculo(double radio) {
		return new circulo(radio);
	}
	
	public elipse crearElipse(double semiEjeMay,double semiEjeMen) {
		return new elipse(semiEjeMay, semiEjeMen);
	}
	
	private class circulo extends figura{
		private double radio;
		
		public circulo(double radio) {
			this.radio = radio;
		}

		public double getPerimetro() {
			return Math.PI*2*radio;
		}

		

		public double getArea() {
			return Math.PI*Math.pow(radio, 2);
		}

		

		public double getRadio() {
			return radio;
		}

		public void setRadio(double radio) {
			this.radio = radio;
		}
		
	}
	
	
	
	private class elipse extends figura{
		private double semiEjeMay;
		private double semiEjeMen;
		
		public elipse(double semiEjeMay,double semiEjeMen) {
			this.semiEjeMay = semiEjeMay;
			this.semiEjeMen = semiEjeMen;
			
		}
		
		
		public double getPerimetro() {
			return Math.PI*2*Math.sqrt((Math.pow(semiEjeMay,2)+Math.pow(semiEjeMen,2))/2);
		}

		

		public double getArea() {
			return Math.PI*semiEjeMay*semiEjeMen;
		}


		public double getSemiEjeMay() {
			return semiEjeMay;
		}


		public void setSemiEjeMay(double semiEjeMay) {
			this.semiEjeMay = semiEjeMay;
		}


		public double getSemiEjeMen() {
			return semiEjeMen;
		}


		public void setSemiEjeMen(double semiEjeMen) {
			this.semiEjeMen = semiEjeMen;
		}
	}
	
}

package figuras.tresDimensiones;

import figuras.figura;

public class piramide extends figura{
	private double base;
	private double ladoBase;
	private double altura;
	private double alturaTriangulo;
	private double lado;
	
	
	public piramide(double ladoBase,double altura) {
		this.setBase(ladoBase*ladoBase);
		this.setAltura(altura);
		this.setAlturaTriangulo(altura*ladoBase/2);
		this.setLadoBase(ladoBase);
		this.setLado(ladoBase*alturaTriangulo/2);
	}

	
	public double getPerimetro() {
		return lado*4+base;
	}
	
	public double getArea() {
		return base*altura/3;
	}
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}


	public double getAlturaTriangulo() {
		return alturaTriangulo;
	}


	public void setAlturaTriangulo(double alturaTriangulo) {
		this.alturaTriangulo = alturaTriangulo;
	}


	public double getLadoBase() {
		return ladoBase;
	}


	public void setLadoBase(double ladoBase) {
		this.ladoBase = ladoBase;
	}


	public double getLado() {
		return lado;
	}


	public void setLado(double lado) {
		this.lado = lado;
	}
}

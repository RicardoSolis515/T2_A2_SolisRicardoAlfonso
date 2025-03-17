package figuras.tresDimensiones;

import figuras.figura;

public class cono extends figura{
	private double radioBase;
	private double altura;
	private double base;
	private double alturaLado;
	
	public cono(double radioBase,double altura) {
		this.setRadioBase(radioBase);
		this.setAltura(altura);
		this.setBase(radioBase*radioBase*Math.PI);
		this.setAlturaLado(Math.sqrt((radioBase*radioBase)+(altura*altura)));
	}

	public double getPerimetro() {
		return base+alturaLado*radioBase*Math.PI;
	}
	
	public double getArea() {
		return base*altura/3;
	}
	
	public double getRadioBase() {
		return radioBase;
	}

	public void setRadioBase(double radioBase) {
		this.radioBase = radioBase;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAlturaLado() {
		return alturaLado;
	}

	public void setAlturaLado(double alturaLado) {
		this.alturaLado = alturaLado;
	}
	
}

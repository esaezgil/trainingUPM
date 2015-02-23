package Curso_Android.Intro;

public class Fraccion {

	private int numerador, denominador;

	public Fraccion(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public Fraccion() {
		this(0, 0);
	}

	public Fraccion(int numerador) {
		this(numerador, numerador);
	}

	public int getNumerador() {
		return this.numerador;
	}

	public int getDenominador() {
		return this.denominador;
	}

	public boolean proper() {

		return (this.getNumerador() < this.getDenominador());
	}

	public boolean improper() {
		return false;
	}

	public void add(Fraccion fraccion) {
		if(this.denominador==fraccion.denominador){
			this.numerador += fraccion.numerador;
		}
			else if(this.denominador == fraccion.denominador){
				this.denominador = this.denominador*fraccion.denominador;
				this.numerador = this.numerador*fraccion.denominador + this.denominador*fraccion.numerador;
				}
		}
	

}

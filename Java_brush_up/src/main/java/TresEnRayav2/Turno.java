package TresEnRayav2;

import TresEnRayav2.Ficha.Color;

public class Turno {

	private Color turnoSiguiente;

	public Turno(Color color) {
		if (color == Color.ROJO) {
			this.turnoSiguiente = Color.NEGRO;
		} else if (color == Color.NEGRO) {
			this.turnoSiguiente = Color.ROJO;
		}
	}

	public Turno() {
		this(Color.ROJO);
	}

	public Color getTurnoSiguiente(Color color) {
		if (color == Color.ROJO) {
			this.turnoSiguiente = Color.NEGRO;
		} else if (color == Color.NEGRO) {
			this.turnoSiguiente = Color.ROJO;
		}
		return turnoSiguiente;	
	}
}

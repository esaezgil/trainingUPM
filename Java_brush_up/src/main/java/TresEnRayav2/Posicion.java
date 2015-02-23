package TresEnRayav2;

import java.util.ArrayList;

public class Posicion {

	private int x, y;

	public static final int MIN = 0;
	public static final int MAX = 3;

	public enum Direccion {
		VERTICAL, HORIZONTAL, DIAGONAL_PRINCIPAL, DIAGONAL_SECUNDARIA;
	}

	Direccion direccion;

	// TODO: añadir metodo comprobación de coordenadas válidas!

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public Posicion() {
		this(0, 0);
	}

	public int getFila() {
		return x;
	}

	public int getColumna() {
		return y;
	}
	
	public static ArrayList<Posicion> posicionesPosibles() {
		ArrayList<Posicion> posicionesPosibles = new ArrayList<Posicion>();
		for (int i = MIN; i < MAX; i++) {
			for (int j = MIN; j < MAX; j++) {
				posicionesPosibles.add(new Posicion(i, j));
			}
		}
		return posicionesPosibles;
	}

	public Direccion direccion(Posicion posicion) {
		// Posicion posicion = new Posicion(ficha.getFila(),ficha.getColumna());
		// Direccion direccion = Direccion.DIAG;

		if (this.getFila() == posicion.getFila()) {
			direccion = Direccion.HORIZONTAL;
		} else if (this.getColumna() == posicion.getColumna()) {
			direccion = Direccion.VERTICAL;
		} else if (this.getColumna() == posicion.getFila()
				&& this.getFila() == posicion.getColumna()) {
			direccion = Direccion.DIAGONAL_SECUNDARIA;
		} else if (this.getFila() == posicion.getColumna()
				&& this.getColumna() == posicion.getFila()) {
			direccion = Direccion.DIAGONAL_SECUNDARIA;
		} else if (this.getColumna() == posicion.getFila() + 1
				&& this.getFila() == posicion.getColumna() - 1) {
			direccion = Direccion.DIAGONAL_SECUNDARIA;
		} else if (this.getColumna() == posicion.getFila() - 1
				&& this.getFila() == posicion.getColumna() + 1) {
			direccion = Direccion.DIAGONAL_SECUNDARIA;
		} else if (this.getFila() == posicion.getFila() + 1
				&& this.getColumna() == posicion.getColumna() + 1) {
			direccion = Direccion.DIAGONAL_PRINCIPAL;
		} else if (this.getFila() == posicion.getFila() - 1
				&& this.getColumna() == posicion.getColumna() - 1) {
			direccion = Direccion.DIAGONAL_PRINCIPAL;
		}

		return direccion;
	}

	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

}

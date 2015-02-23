package TresEnRayav2;

import java.util.ArrayList;

import TresEnRayav2.Ficha.Color;

public class Tablero {
	private ArrayList<Ficha> tablero;
	//private Ficha ficha;

	public static final int MIN = 0;
	public static final int MAX = 3;

	public Tablero() {
		this.tablero = new ArrayList<Ficha>();
		//this.ficha = new Ficha();
	}

	public void ponerFicha(Ficha ficha) {
		this.tablero.add(ficha);
	}

	public void quitarFicha(Ficha ficha) {
		// TODO: comprobar que no esta ocupada la posicion donde voy a poner la
		this.tablero.remove(ficha);
	}

	public void clear() {
		this.tablero.clear();
	}

	public ArrayList<Posicion> posicionesDisponibles() {
		ArrayList<Posicion> devuelto = new ArrayList<Posicion>();
		for (int i = MIN; i < MAX; i++) {
			for (int j = MIN; j < MAX; j++) {
				devuelto.add(new Posicion(i, j));
			}
		}
		if (this.isEmpty()) {
			return devuelto;
		} else if (!this.isEmpty()) {
			for (Posicion aux : fichasActuales(Ficha.Color.ROJO)) {
				devuelto.remove(aux);
			}
			for (Posicion aux : fichasActuales(Ficha.Color.NEGRO)) {
				devuelto.remove(aux);
			}
		}
		return devuelto;
	}

	public ArrayList<Posicion> posicionesOcupadas() {
		ArrayList<Posicion> devuelto = new ArrayList<Posicion>();
		for (Posicion aux : fichasActuales(Ficha.Color.ROJO)) {
			devuelto.add(aux);
		}
		for (Posicion aux : fichasActuales(Ficha.Color.NEGRO)) {
			devuelto.add(aux);
		}
		return devuelto;
	}
	
	public ArrayList<Posicion> posicionesOcupadas(Color turno) {
		ArrayList<Posicion> devuelto = new ArrayList<Posicion>();
		for (Posicion aux : fichasActuales(turno)) {
			devuelto.add(aux);
		}
		return devuelto;
	}

	public ArrayList<Posicion> fichasActuales(Color color) {
		ArrayList<Posicion> devuelto = new ArrayList<Posicion>();
		for (Ficha aux : this.tablero) {
			if (aux.getColor() == color) {
				devuelto.add(aux.getPosicion());
			}
		}
		return devuelto;
	}

	public boolean isGanador(Color color) {
		boolean isGanador = false;
		if (this.numFichasColor(color) != 3) {
			return isGanador;
		} else if (this.numFichasColor(color) == 3) {
			ArrayList<Posicion> fichasActuales = fichasActuales(color);
			if (fichasActuales.get(0).direccion(fichasActuales.get(1)) == fichasActuales
					.get(1).direccion(fichasActuales.get(2))) {
				isGanador = true;
			}
		}
		return isGanador;
	}

	public String toString() {
		String devuelto = "";
		for (Ficha aux : tablero) {
			devuelto += aux.toString() + "\n";
		}
		return devuelto;
	}

	public boolean isEmpty() {
		return tablero.isEmpty();
	}

	public int numFichasColor(Color color) {
		int numFichas = 0;
		if (this.tablero.isEmpty()) {
			return 0;
		}
		for (Ficha aux : this.tablero) {
			if (aux.getColor() == color) {
				numFichas++;
			}
		}
		return numFichas;
	}

	public boolean isFull(Color color) {
		boolean isFull = false;
		if (this.numFichasColor(color) == 3) {
			isFull = true;
		}
		return isFull;
	}
}

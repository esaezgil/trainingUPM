package TresEnRayav2;

import java.util.ArrayList;

import TresEnRayav2.Ficha.Color;

import upm.jbb.IO;

public class TresEnRaya {

	private Tablero tablero;
	// private Ficha.Color turno;
	private ArrayList<Posicion> posicionesDisponibles = new ArrayList<Posicion>();
	Turno turnoInicial = new Turno();
	private Color turno;

	public TresEnRaya() {
		this.tablero = new Tablero();
		turno = turnoInicial.getTurnoSiguiente(turno);
	}

	public void addFicha() {
		posicionesDisponibles = tablero.posicionesDisponibles();
		boolean tableroFull = tablero.isFull(turno);
		
		if (tablero.isGanador(turno)) {
			IO.out.println("Lo siento ya hay un ganador, presione nueva partida");
			return;
		}
		else if (!tablero.isGanador(turno) && !tableroFull) {
			Posicion posiciones = (Posicion) IO.in.select(posicionesDisponibles.toArray(),
					"Elija ficha para poner");
			tablero.ponerFicha(new Ficha(posiciones, turno));
			
			if (tablero.isGanador(turno)) {
				IO.out.println("Ganador es: " + turno);
				return;
				}
			turno = turnoInicial.getTurnoSiguiente(turno);			
		    }
		else if (!tablero.isGanador(turno) && tableroFull){
			IO.out.println("Tablero lleno");
			Posicion origen = (Posicion) IO.in.select(tablero.posicionesOcupadas(turno).toArray(), "Elija ficha para mover");
			Posicion destino = (Posicion) IO.in.select(posicionesDisponibles.toArray(),
					"Elija posición de destino");
			tablero.quitarFicha(new Ficha(origen, turno));
			tablero.ponerFicha(new Ficha(destino, turno));			
			
			if (tablero.isGanador(turno)) {
				IO.out.println("Ganador es: " + turno);
				return;
			}
			turno = turnoInicial.getTurnoSiguiente(turno);
		}
	}
	public void print() {
		if (!tablero.isEmpty()) {
			IO.out.println(tablero.toString());
			if(tablero.isGanador(turno))
				IO.out.println("Ganador es: " + turno);
		} else if (tablero.isEmpty()) {
			IO.out
					.println("El tablero está vacío, introduzca fichas por favor");
		}
	}

	public void nuevaPartida() {
		this.tablero = new Tablero();
		IO.out.println("\nNueva partida iniciada\n");
	}

	public static void main(String[] args) {
		IO.in.addController(new TresEnRaya());
	}
}
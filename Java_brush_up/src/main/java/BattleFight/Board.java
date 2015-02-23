package BattleFight;

import java.util.ArrayList;
import java.util.Random;

public class Board {

	private ArrayList<Shot> board = new ArrayList<Shot>();
	private Army army;

	private static final int NUMBEROFSHIPS = 4;
	private static final int ROWS = 4;
	private static final int COLS = 4;

	public String letters = new String("ABCDEFGHIJ");

	public Board(Army army) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				this.board.add(new Shot((char) letters.charAt(i), j,
						Result.WATER));
			}
		}
		//this.meterBarcos(flota);
		this.updateBoard(army);
		this.army = army;
	}
	
	public Board() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				this.board.add(new Shot((char) letters.charAt(i), j,
						Result.WATER));
			}
		}
	}
	
	public Shot getShot(char a, int b){
		Shot shotReturned = null; 
		for (Shot auxShot : this.board){
			if(auxShot.getX() == a && auxShot.getY() == b)
				shotReturned = auxShot;
		}
		return shotReturned;
	}
	
	public Result shoot(Shot chosenShot) {
		
		Result result = this.army.shoot(chosenShot);
		if (result == Result.MISSED){
			Shot missedShot = new Shot(chosenShot.getX(), chosenShot.getY(), Result.WATER);
			this.board.get(board.indexOf(missedShot)).setContent(Result.MISSED);

		} else if (result == Result.HARM) {
			Shot accurateShot = new Shot(chosenShot.getX(), chosenShot.getY(), Result.SHIP);
			this.board.get(board.indexOf(accurateShot)).setContent(Result.HARM);
		} else{ 
			this.updateBoard(army); //update del tablero 
		}
		return result;
	}
	
	private ArrayList<Shot> getShips() {
		ArrayList<Shot> shipList = new ArrayList<Shot>();
		for (Shot shot : this.getBoard()) {
			if (shot.getContent() == Result.SHIP) {
				shipList.add(shot);
			}
		}
		return shipList;
	}

	public ArrayList<Shot> getBoard() {
		return this.board;
	}

	public boolean checkWinner() {
		boolean ganador = false;
		if (shipsAlive() == 0) {
			ganador = true;
		}
		return ganador;
	}

	public int shipsAlive() {
		int healthyPieces = 0;
		for (Shot aux : this.getBoard()) {
			//System.out.println(aux.getContenido().toString());
			if (aux.getContent().equals(Result.SHIP)){
				healthyPieces++;
			}
		}
		//System.out.println(piezasSanas);
		return healthyPieces;
	}

	public ArrayList<Shot> getPossibleShots() {
		ArrayList<Shot> possibleShots = new ArrayList<Shot>();
		for (Shot aux : this.board) {
			if (aux.getContent() == Result.WATER
					|| aux.getContent() == Result.SHIP) {
				possibleShots.add(aux);
			}
		}
		return possibleShots;
	}
	
	public void updateBoard(Army army) {
		
		ArrayList<Ship> auxShipList = army.getArmy();
		//System.out.println("Size: "+ aux.size());
		for(int i = 0; i < auxShipList.size(); i++){			
				ArrayList<Shot> availableShots = auxShipList.get(i).getShot();
				for (Shot auxShot : availableShots){
					Shot shotToModify = this.getShot(auxShot.getX(),auxShot.getY());										
					shotToModify.setContent(auxShot.getContent());
					//System.out.println("Contenido: "+auxiliar.getContenido());
				}
		}
	}

	public int getRows() {
		return ROWS;
	}

	public int getCols() {
		return COLS;
	}

}

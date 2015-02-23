package BattleFight;

import java.util.ArrayList;

import upm.jbb.IO;

public class Controller {

	private Board board;
	private Army army;
	View view;
	
	public Controller() {		
		view = new View();
	}
	public void initialize() {		
		army = new Army(4, 4); 
		board = new Board(army);
		view.showHorizontalLine(board);
		view.showShips(board);
	}

	public void play() {
		if (army == null){
			System.out.println("Press new game to start");
			return;
		}
		if (board.checkWinner()) {
			System.out.println("There's a winner already, game over");
			return;
		}

		ArrayList<Shot> possibleShots = board.getPossibleShots();
		Shot chosenShot = (Shot) IO.in.select(possibleShots.toArray(), "Choose your shot");
		board.shoot(new Shot(chosenShot.getX(),chosenShot.getY(),Result.SHIP));		
		view.showShips(board);
		if (board.checkWinner()) {
			System.out.println("There's a winner already, game over");
			return;
		}
	}

	public static void main(String[] args) {
		IO.in.addController(new Controller());
	}
}

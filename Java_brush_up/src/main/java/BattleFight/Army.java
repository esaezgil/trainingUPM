package BattleFight;

import java.util.ArrayList;
import java.util.Random;

public class Army {
	
	private ArrayList<Ship> army = new ArrayList<Ship>();
	
	private ArrayList<Shot> shotList = new ArrayList<Shot>();
	
	public String letters = new String("ABCDEFGHIJ");
	static Random rand = new Random();

	private int numShipsSize4 = 1;
	private int numShipsSize3 = 2;	
	private int numShipsSize2 = 3;
	private int numShipsSize1 = 4;
	
	private int numShipsTotal = numShipsSize4 + numShipsSize3 + numShipsSize2 + numShipsSize1;
	
	private int shipSize[] = {1,2,3,4};	
	private int numShipsSize [] = {1,1,1,1};
	private int shipsMatrix[][] = {shipSize,numShipsSize};
	
	public int getNumShipsTotal() {
		return numShipsTotal;
	}
	
	public ArrayList<Ship> getArmy() {
		return army;
	}

	public Army(int rows, int cols){ //create a randomly distributed army TODO: missing diagonal
		
		/*boolean[][] positionMatrix = new boolean[rows][cols];
		for (int i = 0; i < rows; i ++){
			for(int j = 0; j < cols; j++){
				positionMatrix [i][j] = false;
				}				
			}*/
		
		for (int i = 0; i < shipSize.length; i ++){
			for(int j = 0; j < numShipsSize[i]; j++){
				army.add(randomShipInsert(shipSize[i], rows, cols, shotList));
			}			
		}		
		
		
		/*ArrayList <Shot> shotList = new ArrayList<Shot>();
		shotList.add(new Shot((char) letters.charAt(0), 0,Result.SHIP));
		shotList.add(new Shot((char) letters.charAt(0), 1,Result.SHIP));
		//listaDisparos.add(new Disparo((char) letras.charAt(0), 2,Resultado.BARCO));
		Ship ship1 = new Ship(shotList, shotList.size());
		army.add(ship1);*/
		
	}
	
	private Ship randomShipInsert(int shipLength, int rows, int cols, ArrayList<Shot> shotList){
		
		boolean inserted = false;
		Ship insertedShip = null;
		do{
			int randomRow = randInt(0, rows);
			int randomCol = randInt(0, cols);			
			ArrayList<Shot> auxShotList;
			
			auxShotList = insertHorizontal(rows, cols, randomRow, randomCol, shipLength, shotList);
			if(auxShotList != null){
				inserted = true;
				insertedShip = new Ship(auxShotList,shipLength);
			}
			auxShotList = insertVertical(rows, cols, randomRow, randomCol, shipLength, shotList);
			if(auxShotList != null) {
				inserted = true;
				insertedShip = new Ship(auxShotList,shipLength);
			}
			/*if(checkDiagonal(positionMatrix) != null){
				inserted = true;
				return new Ship(shotListCopy,shipLength);
			}*/
			}while (!inserted);
	
		return insertedShip;
		
	}
		
	/*private Object checkDiagonal(boolean[][] positionMatrix) {		
		return null;	}*/

	private ArrayList<Shot> insertVertical(int row, int col, int randomRow, int randomCol, int shipLength, ArrayList<Shot> shotList) {
		
		int positionsLeft = shipLength;
		ArrayList<Shot> vertical= new ArrayList<Shot>();
		for(int i = randomRow; i < row; i++){
			if(!shotList.contains(new Shot ((char) letters.charAt(i), randomCol,Result.SHIP))){
				positionsLeft--;
				vertical.add(new Shot((char) letters.charAt(i), randomCol,Result.SHIP));
			}
		}
		if(positionsLeft != 0 && randomRow != 0){
			vertical.clear();
			positionsLeft = shipLength;
			for(int i = 0; i < randomRow; i++){
				if(!shotList.contains(new Shot ((char) letters.charAt(i), randomCol,Result.SHIP))){
					positionsLeft--;
					vertical.add(new Shot((char) letters.charAt(i), randomCol,Result.SHIP));
				}
			}
		}
		if(positionsLeft == 0){
			for (int i = 0; i < vertical.size(); i++){
				shotList.add(vertical.get(i));
			}
		return vertical;
	}		
		return null;
	}

	private ArrayList<Shot> insertHorizontal(int row, int col, int randomRow, int randomCol, int shipLength,  ArrayList<Shot> shotList) {
		
		int positionsLeft = shipLength;
		ArrayList<Shot> horizontal= new ArrayList<Shot>();
		for(int j = randomCol; j < col; j++){
			if(!shotList.contains(new Shot((char) letters.charAt(randomRow), j,Result.SHIP))){
				positionsLeft--;
				horizontal.add(new Shot((char) letters.charAt(randomRow), j,Result.SHIP));
			}
		}
		if(positionsLeft != 0 && randomCol != 0){
			horizontal.clear();
			positionsLeft = shipLength;
			for(int j = 0; j < randomCol; j++){
				if(!shotList.contains(new Shot((char) letters.charAt(randomRow), j,Result.SHIP))){
					positionsLeft--;
					horizontal.add(new Shot((char) letters.charAt(randomRow), j,Result.SHIP));
				}
			}
		}
		if(positionsLeft == 0){
			for (int i = 0; i < horizontal.size(); i++){
			shotList.add(horizontal.get(i));
			}
			return  horizontal;	
		}
		return null;
	}

	public static int randInt(int min, int max) { //http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
		//Random rand = new Random();
	    // nextInt is normally exclusive of the top value, so add 1 to make it inclusive
		//int randomNum = rand.nextInt((max - min) + 1) + min;
		int randomNum = rand.nextInt((max - min)) + min;
	    return randomNum;
	}
	
	public Result shoot(Shot shot){ //tengo que pasarle un disparo que contenga barco
		
		Result result = Result.MISSED;		
		for (Ship auxShip : this.getArmy()){
			ArrayList<Shot> possibleShots = auxShip.getShot();
			for (Shot possibleShot : possibleShots){
				if (possibleShot.equals(shot) && auxShip.getLength()==1){					
					auxShip.sinkShip();
					return Result.SUNK;
				} else if(possibleShot.equals(shot) && auxShip.getLength()>1){
					auxShip.harmShip(shot);
					return Result.HARM;
				}					
			}
		}
		return result;
	}
}
package BattleFight;

import java.util.ArrayList;

public class Ship {
	
	private ArrayList <Shot> shotList;
	private int length;
	
	public Ship(ArrayList <Shot> shotList, int length){
		this.shotList = shotList;
		this.length = length;
	}
	
	public Ship(){
		this(new ArrayList <Shot>(), 0);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ArrayList <Shot> getShot() {
		return shotList;
	}
	
	public void sinkShip(){
		this.length = 0;
		for (Shot auxShot : shotList){
			auxShot.setContent(Result.SUNK);
		}		
	}
	
	public void harmShip(Shot shot){ //el disparo qe recibe debe contener barco
		
		this.length = length-1;
		shotList.get(shotList.indexOf(shot)).setContent(Result.HARM);
		//cojo de la lista el disparo y lo pongo a tocado
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shotList == null) ? 0 : shotList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		ArrayList <Shot> list = other.getShot();
		
		if (shotList == null) {
			if (other.shotList != null)
				return false;
		} else if (!shotList.equals(other.shotList))
			return false;
		if(list.contains(this)){
			return true;
		}
		return false;
	}
}

package TresEnRayav2;

public class Ficha {

	private Color color;
	private Posicion posicion;

	public enum Color {
		ROJO, NEGRO, SIN_FICHA;
	}

	public Ficha(Posicion posicion, Color fichaUsada) {
		this.posicion = posicion;
		this.color = fichaUsada;
	}

	public Ficha() {
		this(new Posicion(), Color.ROJO);
	}

	public int getFila() {
		return posicion.getFila();
	}

	public int getColumna() {
		return posicion.getColumna();
	}

	public Color getColor() {
		return this.color;
	}

	/**@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((posicion == null) ? 0 : posicion.hashCode());
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
		Ficha other = (Ficha) obj;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}

	public boolean ocupada() {
		boolean ocupada = true;
		if (this.getColor() == null) {
			ocupada = false;
		}
		return ocupada;
	}
	
	
	public Posicion getPosicion(){
		return new Posicion(this.getFila(), this.getColumna());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.posicion.toString()+this.getColor().toString();
	}

	public void setColor(Color color) {
		this.color = color;
	}

}

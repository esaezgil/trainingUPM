package BattleFight;

public class Shot {
	
	private char x;
	private int y;

	private Result content;
	
	public Shot(char x, int y, Result content){
		this.x = x;
		this.y = y;
		this.content = content;
	}
	
	public Shot(){
		this('A',0, Result.WATER);
	}

	public Result getContent() {
		return this.content;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((content == null) ? 0 : content.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		Shot other = (Shot) obj;
		if (content != other.content)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shot [x=" + x + ", y=" + y + "]";
	}

	public char getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setContent(Result content) {
		this.content = content;
	}
	
}

package pacman.util;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position add(Position other) {
		return new Position(this.x + other.x, this.y + other.y);
	}
	
	public double distance(Position other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null || getClass() != other.getClass()) return false;
		
		Position position = (Position) other;
		
		if (this.x == position.x && this.y == position.y) return true;
		
		return false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	public Position multiply​(int factor) {
		return new Position(factor * this.x, factor * this.y);
	}
}

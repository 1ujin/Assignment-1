package pacman.util;

public enum Direction {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1);

    private int X;
    private int Y;

    private Direction(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    /* Gets the offset associated with this direction. ???*/
    public Position offset() {
        return new Position(this.X, this.Y);
    }

    public Direction opposite() {
        switch(this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
        }
        return null;
    }

//	public static Direction valueOf(String name) {
//		
//	}

//	public static Direction[] values() {
//		
//	}
}

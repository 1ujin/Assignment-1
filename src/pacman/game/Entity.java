package pacman.game;

import pacman.util.Direction;
import pacman.util.Position;

public class Entity implements Moveable {
    private Position position;
    private Direction direction;

    public Entity() {
        this.position = new Position(0, 0);
        this.direction = Direction.UP;
    }

    public Entity(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void setPosition​(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setDirection​(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }
}

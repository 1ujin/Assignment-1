package pacman.hunter;

import pacman.game.Entity;
import pacman.ghost.Ghost;
import pacman.ghost.Phase;
import pacman.util.Direction;
import pacman.util.Position;

public abstract class Hunter extends Entity {
    protected HunterType type;
    protected Position position;
    protected Direction direction;

    private boolean specialActive;
    private int specialDurationRemaining;
    private boolean dead;

    public Hunter() {
        this.position = new Position(0, 0);
        this.direction = Direction.UP;
        this.specialActive = false;
        this.specialDurationRemaining = 0;
        this.dead = false;
    }

    public Hunter(Hunter original) {
        this.position = original.position;
        this.direction = original.direction;
        this.specialActive = original.specialActive;
        this.specialDurationRemaining = original.specialDurationRemaining;
        this.dead = original.dead;
    }

    public boolean isSpecialActive() {
        return specialActive;
    }

    public int getSpecialDurationRemaining() {
        return specialDurationRemaining;
    }

    public void activateSpecial​(int duration) {
        if (!isSpecialActive()) {
            this.specialActive = true;
        }

        if (duration >= 0) {
            this.specialDurationRemaining -= duration;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public void hit(Ghost ghost) throws NullPointerException {
        if (position.equals(ghost.getPosition())) {
            if (ghost.getPhase() == Phase.FRIGHTENED) {
                ghost.kill();
            } else {
                this.dead = true;
            }
        }
    }

    public void reset() {
        this.position = new Position(0, 0);
        this.direction = Direction.UP;
        this.specialActive = false;
        this.specialDurationRemaining = 0;
        this.dead = false;
    }
}

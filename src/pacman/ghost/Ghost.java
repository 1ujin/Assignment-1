package pacman.ghost;

import pacman.game.Entity;
import pacman.util.Direction;
import pacman.util.Position;

public abstract class Ghost extends Entity {
    private Position position;
    private Direction direction;
    private GhostType type;
    private Phase phase;
    private int duration;
    private boolean dead;

    public Ghost() {
        this.phase = Phase.SCATTER;
        this.duration = Phase.SCATTER.getDuration();
        this.dead = false;
        direction = Direction.UP;
        position = new Position(0, 0);
    }

    public abstract String getColour();

    public void setPhase(Phase newPhase, int duration) {
        if (newPhase != null) {
            this.phase = newPhase;

            if (duration < 0) {
                this.duration = 0;
            }
        }
    }

    public String phaseInfo() {
        return String.format("PHASE:%s", phase.name());
    }

    public GhostType getType() {
        return type;
    }

    public Phase getPhase() {
        return phase;
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        dead = true;
    }

    public void reset() {
        dead = false;
        phase = Phase.SCATTER;
        duration = Phase.SCATTER.getDuration();
        direction = Direction.UP;
        position = new Position(0, 0);
    }
}

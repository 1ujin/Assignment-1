package pacman.hunter;

import pacman.ghost.Ghost;
import pacman.ghost.Phase;

public class Hungry extends Hunter {
    public Hungry() {
        super();
        this.type = HunterType.HUNGRY;
    }

    public Hungry(Hunter original) {
        super(original);
        this.type = original.type;
    }

    @Override
    public void hit(Ghost ghost) throws NullPointerException {
        if (position.equals(ghost.getPosition()) && this.isSpecialActive()) {
            ghost.kill();
        } else {
            super.hit(ghost);
        }
    }
}

package pacman.hunter;

import pacman.ghost.Ghost;
import pacman.ghost.Phase;

public class Phasey extends Hunter {

    public Phasey() {
        super();
        this.type = HunterType.PHASEY;
    }

    public Phasey(Hunter original) {
        super(original);
        this.type = original.type;
    }

    @Override
    public void hit(Ghost ghost) throws NullPointerException {
        // If Phasey's special is active and if a ghost is not Phase.FRIGHTENED
        // If Phasey's special is not active or if a ghost is Phase.FRIGHTENED
        if (!this.isSpecialActive() || ghost.getPhase() == Phase.FRIGHTENED) {
            super.hit(ghost);
        }
    }
}

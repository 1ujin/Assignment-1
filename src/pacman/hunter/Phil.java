package pacman.hunter;

import pacman.ghost.Ghost;

public class Phil extends Hunter {

    public Phil() {
        super();
        this.type = HunterType.PHIL;
    }

    public Phil(Hunter original) {
        super(original);
        this.type = original.type;
    }

    @Override
    public boolean isSpecialActive() {
        return false;
    }
}

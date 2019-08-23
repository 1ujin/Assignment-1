package pacman.hunter;

public class Speedy extends Hunter {
    public Speedy() {
        super();
        this.type = HunterType.SPEEDY;
    }

    public Speedy(Hunter original) {
        super(original);
        this.type = original.type;
    }
}

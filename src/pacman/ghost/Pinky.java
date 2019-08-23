package pacman.ghost;

public class Pinky extends Ghost {
    @Override
    public String getColour() {
        return "#c397d8";
    }

    @Override
    public GhostType getType() {
        return GhostType.PINKY;
    }
}

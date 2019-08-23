package pacman.ghost;

public class Blinky extends Ghost {
    @Override
    public String getColour() {
        return "#d54e53";
    }

    @Override
    public GhostType getType() {
        return GhostType.BLINKY;
    }
}

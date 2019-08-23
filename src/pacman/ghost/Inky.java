package pacman.ghost;

public class Inky extends Ghost {

    @Override
    public String getColour() {
        return "#7aa6da";
    }

    @Override
    public GhostType getType() {
        return GhostType.INKY;
    }
}

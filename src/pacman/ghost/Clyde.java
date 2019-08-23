package pacman.ghost;

public class Clyde extends Ghost {
    @Override
    public String getColour() {
        return "#e78c45";
    }

    @Override
    public GhostType getType() {
        return GhostType.CLYDE;
    }
}

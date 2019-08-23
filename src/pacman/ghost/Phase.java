package pacman.ghost;

public enum Phase {
    CHASE(20),
    FRIGHTENED(30),
    SCATTER(10);

    private int duration;

    Phase(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

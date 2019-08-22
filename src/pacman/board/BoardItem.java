package pacman.board;

public enum BoardItem {
    NONE(true, 0, '0'),
    WALL(false, 0, 'X'),
    DOT(true, 10, '1'),
    BIG_DOT(true, 15, 'B'),
    BIG_DOT_SPAWN(true, 0, 'b'),
    GHOST_SPAWN(true, 0, '$'),
    PACMAN_SPAWN(true, 0, 'P');

    private boolean Pathable;
    private int Score;
    private char CharKey;

    private BoardItem(boolean Pathable, int Score, char CharKey) {
        this.Pathable = Pathable;
        this.Score = Score;
        this.CharKey = CharKey;
    }

    public boolean getPathable() {
        return Pathable;
    }

    public int getScore() {
        return Score;
    }

    public char getChar() {
        return CharKey;
    }

    public static BoardItem getItem​(char key) throws IllegalArgumentException {
        for(BoardItem boardItem : BoardItem.values()) {
            if(boardItem.getChar() == key) {
                return boardItem;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(BoardItem.valueOf("DOT"));
        BoardItem[] boardItems = BoardItem.values();
        for (BoardItem boardItem : boardItems) {
            System.out.println("name:" + boardItem.name());
        }
    }
}

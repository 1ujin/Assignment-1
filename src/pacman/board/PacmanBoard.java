package pacman.board;

import pacman.util.Position;

public class PacmanBoard {
    private int width;
    private int height;
    private BoardItem[][] board;

    /*
     * Constructor taking the width and height creating a board that is filled with
     * BoardItem.NONE except a 1 block wide border wall around the entire board (
     * BoardItem.WALL ).
     */
    public PacmanBoard(int width, int height) {
        this.width = width;
        this.height = height;
        /*
         * A board with width 4 and height 4 would look like this:
         * 	    XXXX
         * 	    X00X
         *	    X00X
         * 	    XXXX
         */
        this.board = new BoardItem[width][height];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (h == 0 || w == 0 || h == height - 1 || w == width - 1) {
                    this.board[w][h] = BoardItem.WALL;
                } else {
                    this.board[w][h] = BoardItem.NONE;
                }
            }
        }
    }

    /* Constructor taking an existing PacmanBoard and making a deep copy. */
    public PacmanBoard(PacmanBoard pacmanBoard) {
        this.width = pacmanBoard.width;
        this.height = pacmanBoard.height;
        this.board = pacmanBoard.board;
    }

    public BoardItem eatDot​(Position position) throws IndexOutOfBoundsException, NullPointerException {
        BoardItem oldItem = getEntry​(position);
        switch (oldItem) {
            case DOT:
                setEntry​(position, BoardItem.NONE);
                break;
            case BIG_DOT:
                setEntry​(position, BoardItem.BIG_DOT_SPAWN);
                break;
            // default:
            //     return oldItem; // If the item is any other BoardItem then do nothing and return the item.???
        }
        return oldItem;
    }

    public BoardItem getEntry​(Position position) throws IndexOutOfBoundsException, NullPointerException {
        if (position == null) throw new NullPointerException();
        if (0 <= position.getX() && position.getX() < this.getWidth() && 0 <= position.getY() && position.getY() < this.getHeight()) {
            return this.board[position.getX()][position.getY()];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Position getGhostSpawn() {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (this.board[w][h] == BoardItem.GHOST_SPAWN) {
                    return new Position(w, h);
                }
            }
        }
        return null;
    }

    public int getHeight() {
        return height;
    }

    public Position getPacmanSpawn() {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (this.board[w][h] == BoardItem.PACMAN_SPAWN) {
                    return new Position(w, h);
                }
            }
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public boolean isEmpty() {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (this.board[w][h] == BoardItem.DOT || this.board[w][h] == BoardItem.BIG_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        for (int h = 1; h < height - 1; h++) {
            for (int w = 1; w < width - 1; w++) {
                if (this.board[w][h] == BoardItem.NONE) {
                    this.board[w][h] = BoardItem.DOT;
                } else if (this.board[w][h] == BoardItem.BIG_DOT_SPAWN) {
                    this.board[w][h] = BoardItem.BIG_DOT;
                }
            }
        }
    }

    public void setEntry​(Position position, BoardItem item) throws IndexOutOfBoundsException, NullPointerException {
        if (position == null) throw new NullPointerException();
        if (0 < position.getX() && position.getX() < this.getWidth() - 1 && 1 <= position.getY() && position.getY() < this.getHeight() - 1) {
            if (item == BoardItem.PACMAN_SPAWN) {
                for (int h = 1; h < height - 1; h++) {
                    for (int w = 1; w < width - 1; w++) {
                        if (this.board[w][h] == BoardItem.PACMAN_SPAWN) {
                            this.board[w][h] = BoardItem.NONE;
                        }
                    }
                }
            } else if (item != BoardItem.GHOST_SPAWN) {
                for (int h = 1; h < height - 1; h++) {
                    for (int w = 1; w < width - 1; w++) {
                        if (this.board[w][h] == BoardItem.GHOST_SPAWN) {
                            this.board[w][h] = BoardItem.NONE;
                        }
                    }
                }
            }

            this.board[position.getY()][position.getX()] = item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}

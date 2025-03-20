public class Ship {
    private int size;
    private boolean horizontal;
    private boolean sunk;

    public Ship(int size) {
        this.size = size;
        this.horizontal = horizontal;
        this.sunk = false;
    }

    public int getSize() {
        return size;
    }

    public char getCharSize() {
        return (char)(size + '0');
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean isSunk(Board board) {
        for (int i = 0; i < board.getSize(); ++i) {
            for (int j = 0; j < board.getSize(); ++j) {
                if (board.getGrid()[i][j] == this.getCharSize()) {
                    sunk = false;
                    return false;
                }
            }
        }
        sunk = true;
        return true;
    }
}

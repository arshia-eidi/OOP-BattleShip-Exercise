import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private char[][] grid;
    private char[][] trackingGrid;
    private int size;

    Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        this.trackingGrid = new char[size][size];

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getGrid() {
        return grid;
    }


    public char[][] getTrackingGrid() {
        return trackingGrid;
    }


    public void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~';
                trackingGrid[i][j] = '~';
            }
        }
    }


    public boolean placeShip(Ship ship, Coordinate coordinate) {

        if (ship.isHorizontal()) {
            if (coordinate.getCol() + ship.getSize() > size) return false;
            for (int c = 0; c < ship.getSize(); ++c) {
                if ((grid[coordinate.getRow()][coordinate.getCol() + c] != '~')) return false;
            }
            for (int c = 0; c < ship.getSize(); ++c) {
                grid[coordinate.getRow()][coordinate.getCol() + c] = (char) (ship.getSize() + '0');
            }
        } else {
            if (coordinate.getRow() + ship.getSize() > size) return false;
            for (int r = 0; r < ship.getSize(); ++r) {
                if (grid[coordinate.getRow() + r][coordinate.getCol()] != '~') return false;
            }
            for (int r = 0; r < ship.getSize(); ++r) {
                grid[coordinate.getRow() + r][coordinate.getCol()] = (char) (ship.getSize() + '0');
            }

        }
        return true;
    }


    public void placeShipRandomly(Ship ship) {
        Random rand = new Random();
        boolean placed = false;
        while (!placed) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            boolean horizontal = rand.nextBoolean();
            ship.setHorizontal(horizontal);
            placed = placeShip(ship, new Coordinate(row, col));
        }
    }

    public void placeShipByUser(Ship ship) {
        Scanner scanner = new Scanner(System.in);
        boolean placed = false;
        while (!placed) {
            int row = -1;
            int col = -1;
            boolean horizontal = false;
            while (row == -1) {
                try {
                    System.out.println("Row: (Enter a number (0 to " + this.size + ")): ");
                    row = scanner.nextInt();
                    if (row < 0 || row >= this.size) {
                        System.out.println("Invalid row. Please enter a number between 0 and " + this.size + ".");
                        row = -1;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error! Please enter a valid integer.");
                    scanner.next();
                }

            }

            while (col == -1) {
                try {
                    System.out.print("Col: (Enter a character (A to " + (char) ('A' + this.size - 1) + ")): ");
                    char getCol = scanner.next().charAt(0);
                    if (getCol >= 'A' && getCol <= (char) ('A' + this.size - 1)) {
                        col = getCol - 'A';
                    } else {
                        System.out.println("Invalid column. Please enter a character between A and " + (char) ('A' + this.size - 1) + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error! Please enter a valid character.");
                    scanner.next();
                }
            }

            while (true) {
                try {
                    System.out.print("Horizontal: (Enter true or false): ");
                    horizontal = scanner.nextBoolean();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error! Please enter true or false.");
                    scanner.next();
                }
            }

            ship.setHorizontal(horizontal);
            placed = placeShip(ship, new Coordinate(row, col));
            if (!placed) {
                System.out.println("Invalid ship placement: Overlap or out of bounds.");
            }
        }
    }


    public void showGrid() {
        for (int i = 0; i < size; ++i) {
            if (i == 0) {
                System.out.print("  ");
                for (char letter = 'A'; letter <= 'A' + (this.getSize() - 1); letter++) {
                    System.out.print(letter + " ");
                }
                System.out.print("\n");
            }
            for (int j = 0; j < size; ++j) {
                if (j == 0) {
                    System.out.print(i + " ");
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void showTrackingGrid() {
        for (int i = 0; i < size; ++i) {
            if (i == 0) {
                System.out.print("  ");
                for (char letter = 'A'; letter <= 'A' + (this.getSize() - 1); letter++) {
                    System.out.print(letter + " ");
                }
                System.out.print("\n");
            }
            for (int j = 0; j < size; ++j) {
                if (j == 0) {
                    System.out.print(i + " ");
                }
                System.out.print(trackingGrid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}








import java.util.Scanner;
import java.util.Random;


public class Player {
    private Board board;
    private boolean isAi;
    private int[] ships;

    public Player(Board board, boolean isAi) {
        this.board = board;
        this.isAi = isAi;
    }

    public Board getBoard() {
        return board;
    }

    public int[] getShips() {
        return ships;
    }

    public void setShips(int[] ships) {
        this.ships = ships;
    }

    public boolean isAi() {
        return isAi;
    }

    public void setAi(boolean ai) {
        isAi = ai;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void playerTurn(Board board, Player opponentPlayer) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String input2;

        while (true) {
            if (this.isAi) {
                Random rand = new Random();
                input = "" + (char) ('A' + rand.nextInt(10)) + rand.nextInt(10);
            } else {
                System.out.println("Enter target (for example A5) or Enter 1 to radar scan or Enter 2 to Multi-Strike attack: ");
                input = scanner.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("Enter target (for example A5): ");
                input2 = scanner.nextLine();
                if (Utils.isValidCoordinate(board, input2)) {
                    int col = (input2.charAt(0) - 'A');
                    String numberString = input2.substring(1);
                    int row = Integer.parseInt(numberString);
                    SpecialAttack.radarScan(opponentPlayer.getBoard(), new Coordinate(row, col));
                    break;
                } else {
                    System.out.println("Invalid coordinate");
                }
            } else if (input.equals("2")) {
                SpecialAttack.multiStrike(opponentPlayer.getBoard());
                break;
            } else if (Utils.isValidCoordinate(board, input)) {
                int col = (input.charAt(0) - 'A');
                String numberString = input.substring(1);
                int row = Integer.parseInt(numberString);
                char target = opponentPlayer.getBoard().getGrid()[row][col];
                if (target == '~') {
                    opponentPlayer.getBoard().getTrackingGrid()[row][col] = 'O';
                    opponentPlayer.getBoard().getGrid()[row][col] = 'O';
                    System.out.println("Miss!");
                    break;

                } else if (target != 'O' && target != 'X') {
                    opponentPlayer.getBoard().getTrackingGrid()[row][col] = 'X';
                    opponentPlayer.getBoard().getGrid()[row][col] = 'X';
                    System.out.println("Hit!");
                    break;

                } else {
                    System.out.println("already attacked!");
                }
            } else {
                System.out.println("Invalid coordinate!");
            }
        }
    }


}

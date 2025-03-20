import java.util.Scanner;

public class SpecialAttack {
    public static void radarScan(Board enemyBoard, Coordinate coordinate) {
        System.out.println("Radar scan activated!");
        for (int i = coordinate.getRow() - 1; i <= coordinate.getRow() + 1; i++) {
            for (int j = coordinate.getCol() - 1; j <= coordinate.getCol() + 1; j++) {
                if (i >= 0 && i < enemyBoard.getSize() && j >= 0 && j < enemyBoard.getSize()) {
                    char cell = enemyBoard.getGrid()[i][j];
                    if (cell == '~') {
                        enemyBoard.getTrackingGrid()[i][j] = 'E';
                    } else {
                        enemyBoard.getTrackingGrid()[i][j] = 'S';
                    }
                }
            }
        }
        enemyBoard.showTrackingGrid();
    }


    public static void multiStrike(Board enemyBoard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Multi-Strike attack!");
        System.out.println("Enter first target (for example A5): ");

        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();
            if (Utils.isValidCoordinate(enemyBoard, input)) {
                int col = (input.charAt(0) - 'A');
                String numberString = input.substring(1);
                int row = Integer.parseInt(numberString);

                char target = enemyBoard.getGrid()[row][col];

                while (true) {
                    if (target == '~') {
                        enemyBoard.getTrackingGrid()[row][col] = 'O';
                        enemyBoard.getGrid()[row][col] = 'O';
                        System.out.println("Miss!");
                        enemyBoard.showTrackingGrid();
                        break;

                    } else if (target != 'O' && target != 'X') {
                        enemyBoard.getTrackingGrid()[row][col] = 'X';
                        enemyBoard.getGrid()[row][col] = 'X';
                        System.out.println("Hit!");
                        enemyBoard.showTrackingGrid();
                        break;

                    } else {
                        System.out.println("already attacked!");
                    }
                }

            } else {
                System.out.println("Invalid coordinate!");
            }

        }

    }
}
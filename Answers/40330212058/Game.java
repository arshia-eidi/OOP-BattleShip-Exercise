import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    Board board1;
    Board board2;


    public void start() {
        boolean playAgain;
        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);
    }

    private boolean askReplay() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Play again? (yes/no)");
            return scanner.next().equalsIgnoreCase("yes");
        }
    }

    public void playGame() {
        chooseGridSize();
        playWithAi();
        this.player1 = new Player(board1, false);
        this.board1.initializeGrid();
        this.board2.initializeGrid();
        int[] ships = {2, 3, 4, 5};
        player1.setShips(ships);
        player2.setShips(ships);
        placeShipsForPlayer(player1);
        placeShipsForPlayer(player2);
        while (!this.isGameOver()) {
            System.out.println("Player 1's turn:");
            player1.getBoard().showTrackingGrid();
            player1.playerTurn(board1, player2);
            System.out.println("Player 2's turn:");
            player2.getBoard().showTrackingGrid();
            player2.playerTurn(board2, player1);
        }
    }


    public void chooseGridSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose grid size: ");
        int gridSize = scanner.nextInt();
        this.board1 = new Board(gridSize);
        this.board2 = new Board(gridSize);
    }


    public void playWithAi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("do you want to play with ai? (true/false)");
        boolean input = scanner.nextBoolean();
        this.player2 = new Player(board2, input);
    }


    private void placeShipsForPlayer(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.isAi() ? "AI is placing ships..." : "Do you want to place ships manually? (yes/no)");
        String response = player.isAi() ? "no" : scanner.nextLine();

        for (int size : player.getShips()) {
            Ship ship = new Ship(size);
            if (response.equalsIgnoreCase("yes")) {
                player.getBoard().placeShipByUser(ship);
            } else {
                player.getBoard().placeShipRandomly(ship);
            }
        }
    }




    public boolean allShipsSunk(Player player) {
        for (int i = 0; i < player.getShips().length; i++) {
            int size = player.getShips()[i];
            Ship myShip = new Ship(size);
            if (!myShip.isSunk(player.getBoard()))
                return false;
        }
        return true;
    }

    public boolean isGameOver() {
        if (allShipsSunk(player1)) {
            System.out.println("Player 2 is winner!");
            return true;
        }
        if (allShipsSunk(player2)) {
            System.out.println("Player 1 is winner!");
            return true;
        }
        return false;
    }


}

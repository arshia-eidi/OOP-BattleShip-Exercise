//import java.util.Scanner;
//
//public void howPlaceShips() {
//    Scanner scanner = new Scanner(System.in);
//
//    System.out.println("p1: do you want to place ships by yourself?");
//    String answer1 = scanner.nextLine();
//    if (answer1.equals("yes")) {
//        for (int i = 0; i < player1.getShips().length; i++) {
//            System.out.println("ship size: " + player1.getShips()[i]);
//            int size = player1.getShips()[i];
//            Ship ship = new Ship(size);
//            player1.getBoard().placeShipByUser(ship);
//            System.out.println("This is your grid: ");
//            player1.getBoard().showGrid();
//        }
//    } else {
//        for (int i = 0; i < player1.getShips().length; i++) {
//            int size = player1.getShips()[i];
//            Ship ship = new Ship(size);
//            player1.getBoard().placeShipRandomly(ship);
//
//        }
//    }
//
//    System.out.println("p2: do you want to place ships by yourself?");
//    String answer2 = scanner.nextLine();
//    if (answer2.equals("yes")) {
//        for (int i = 0; i < player2.getShips().length; i++) {
//            System.out.println("ship size: " + player2.getShips()[i]);
//            int size = player2.getShips()[i];
//            Ship ship = new Ship(size);
//            player2.getBoard().placeShipByUser(ship);
//            System.out.println("This is your grid: ");
//            player2.getBoard().showGrid();
//        }
//    } else {
//        for (int i = 0; i < player2.getShips().length; i++) {
//            int size = player2.getShips()[i];
//            Ship ship = new Ship(size);
//            player2.getBoard().placeShipRandomly(ship);
//
//        }
//    }
//}

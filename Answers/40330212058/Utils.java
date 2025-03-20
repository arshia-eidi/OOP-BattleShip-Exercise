public class Utils {

    public static boolean isValidCoordinate(Board board, String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'A' + (board.getSize() - 1)) && (row >= '0' && row <= '0' + (board.getSize() - 1));
    }
}

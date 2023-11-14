import java.util.Scanner;

public class BoardDriver1 {
    public static void main(String[] args) {
        Board board = new Board(5, 8);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard(true);
            System.out.println("Enter a direction (w/a/s/d) or 'q' to quit, 'r' for a new board: ");
            char direction = scanner.next().charAt(0);

            if (direction == 'r') {
                System.out.println("Resetting the board.");
                board.generateNewBoard();
                board.initializeGazoo();
                continue;
            }

            if (direction == 'q') {
                System.out.println("Quitting the game.");
                break;
            }

            boolean validMove = false;

            switch (direction) {
                case 'w', 'W':
                    validMove = board.move('w');
                    break;
                case 'a', 'A':
                    validMove = board.move('a');
                    break;
                case 's', 'S':
                    validMove = board.move('s');
                    break;
                case 'd', 'D':
                    validMove = board.move('d');
                    break;
                default:
                    System.out.println("Invalid direction. Please enter w/a/s/d and 'q' to quit 'r' for a new board.");
            }

            if (!validMove) {
                System.out.println("Invalid move. Please try again.");
            }
        }

        scanner.close();
    }
}

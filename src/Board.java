import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<ArrayList<Space>> board;
    private ArrayList<Treasure> remainingTreasures;
    private ArrayList<Healer> remainingHealers;
    private int rows;
    private int columns;
    private Explorer gazoo;
    private boolean treasureFound;


    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new ArrayList<>();
        remainingTreasures = new ArrayList<>();
        initializeBoard();
        initializeGazoo();
        initializeRemainingTreasures();

    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            ArrayList<Space> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(new Space());
            }
            board.add(row);
        }
    }

    public void initializeGazoo() {
        gazoo = new Explorer("Gazoo", 20);
        board.get(0).get(0).setOccupant(gazoo);
    }

    public String getBoardAsString() {
        StringBuilder result = new StringBuilder();
        for (ArrayList<Space> row : board) {
            for (Space space : row) {
                result.append(space.getConsoleStr());
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    public void printBoard(boolean showContents) {
        StringBuilder result = new StringBuilder();
        for (ArrayList<Space> row : board) {
            for (Space space : row) {
                if (showContents) {
                    result.append(space.getConsoleStr());
                } else {
                    if (treasureFound) {
                        result.append(ConsoleColors.YELLOW).append(space.getConsoleStr()).append(ConsoleColors.RESET);
                    } else {
                        result.append(space.getConsoleStr());
                    }
                }
            }
            result.append(System.lineSeparator());
        }
        System.out.println(result.toString());
    }


    public boolean move(char m) {
        int currentRow = -1;
        int currentCol = -1;

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j).getOccupant() != null &&
                        board.get(i).get(j).getOccupant().getName().equals("Gazoo")) {
                    currentRow = i;
                    currentCol = j;
                    break;
                }
            }
        }

        if (currentRow == -1 || currentCol == -1) {
            return false;
        }

        int newRow = currentRow;
        int newCol = currentCol;

        switch (m) {
            case 'w':
                newRow--;
                break;
            case 'a':
                newCol--;
                break;
            case 's':
                newRow++;
                break;
            case 'd':
                newCol++;
                break;
            default:
                return false;
        }

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
            board.get(currentRow).get(currentCol).setOccupant(null);
            board.get(newRow).get(newCol).setOccupant(gazoo);

            if (board.get(newRow).get(newCol).getCache() != null) {
                Treasure treasure = (Treasure) board.get(newRow).get(newCol).getCache();
                gazoo.addTreasure(treasure);
                remainingTreasures.remove(treasure);
                board.get(newRow).get(newCol).setCache(null);

                if (remainingTreasures.isEmpty()) {
                    System.out.println("Congratulations! You've found all treasures!");
                    printBoard(true);
                }
            }

            return true;
        }

        return false;
    }


    public void generateNewBoard() {
        initializeBoard();
        initializeGazoo();
        initializeRemainingTreasures();
    }

    private void initializeRemainingTreasures() {
        remainingTreasures.clear();
        for (int i = 0; i < 5; i++) {
            Treasure treasure = new Treasure("Gold", 5);
            placeTreasureRandomly(treasure);
            remainingTreasures.add(treasure);
        }
    }

    private void placeTreasureRandomly(Treasure treasure) {
        Collections.shuffle(board);
        for (ArrayList<Space> row : board) {
            Collections.shuffle(row);
            for (Space space : row) {
                if (space.getCache() == null && space.getOccupant() == null) {
                    space.setCache(treasure);
                    return;
                }
            }
        }
    }
}

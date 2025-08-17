package PlayerStrategies.concreteStrategies;

import PlayerStrategies.PlayerStrategy;
import Utility.Board;
import Utility.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;
    private String playerName;
    public HumanPlayerStrategy(String playerName)
    {
        this.playerName=playerName;
        this.scanner=new Scanner(System.in);
    }
    @Override
    public Position makeMove(Board board) {
        while(true) {
            System.out.printf("%s, enter move (row and column)", playerName);
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position move = new Position(row, col);
                if (board.isValidMove(move)) {
                    return move;
                }
                System.out.println("Invalid move. Try again");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter row and column as numbers");
                scanner.nextLine();
            }
        }
    }
}

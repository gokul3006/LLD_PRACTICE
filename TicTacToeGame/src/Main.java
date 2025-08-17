import GameController.BoardGames;
import GameController.TicTacToeGame;
import PlayerStrategies.PlayerStrategy;
import PlayerStrategies.concreteStrategies.HumanPlayerStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PlayerStrategy xStrategy=new HumanPlayerStrategy("Bod");
        PlayerStrategy oStrategy=new HumanPlayerStrategy("Tom");
        BoardGames ticTacToeGame=new TicTacToeGame(xStrategy,oStrategy,4,4);
        ticTacToeGame.play();
    }
}
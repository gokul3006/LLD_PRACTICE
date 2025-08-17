package GameController;

import GameState.GameState;
import GameState.context.GameContext;
import GameState.state.OWonState;
import GameState.state.XWonState;
import GameState.state.XturnState;
import Utility.Board;
import PlayerStrategies.PlayerStrategy;
import Utility.Player;
import Enum.Symbol;
import Utility.Position;

public class TicTacToeGame implements BoardGames{
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xStrategy,PlayerStrategy oStrategy,int rows,int cols)
    {
        board=new Board(rows,cols);
        playerX=new Player(Symbol.X,xStrategy);
        playerO =new Player(Symbol.O,oStrategy);
        currentPlayer=playerX;
        gameContext=new GameContext(new XturnState());
    }
    @Override
    public void play() {
        do {
            board.printBoard();
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            board.checkGameState(gameContext, currentPlayer);
            switchPlayer();
        }while(!gameContext.isGameOver());
        announceResult();
    }
    public void switchPlayer()
    {
        currentPlayer=(currentPlayer==playerX)?playerO:playerX;
    }
    public void announceResult(){
        GameState state=gameContext.getCurrentState();
        board.printBoard();
        if(state instanceof OWonState)
        {
            System.out.println("Player O Wins");
        }
        else if(state instanceof XWonState)
        {
            System.out.println("Player X Wins");
        }
        else
        {
            System.out.println("Match is drawn");
        }
;    }
}

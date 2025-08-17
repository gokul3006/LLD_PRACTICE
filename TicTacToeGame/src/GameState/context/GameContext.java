package GameState.context;

import GameState.GameState;
import Utility.Player;

public class GameContext {
    private GameState gameState;
    public GameContext(GameState gameState)
    {
        this.gameState=gameState;
    }
    public void setState(GameState gameState)
    {
        this.gameState=gameState;
    }
    public void next(Player player, boolean hasWon)
    {
        gameState.next(this,player,hasWon);
    }
    public boolean isGameOver()
    {
        return gameState.isGameOver();
    }
    public GameState getCurrentState()
    {
        return this.gameState;
    }
}

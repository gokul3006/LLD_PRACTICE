package GameState.state;

import GameState.GameState;
import GameState.context.GameContext;
import Utility.Player;

public class DrawState implements GameState {
    @Override
    public void next(GameContext gameContext, Player player,boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}

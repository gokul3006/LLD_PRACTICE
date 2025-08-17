package GameState.state;

import GameState.GameState;
import GameState.context.GameContext;
import Utility.Player;

public class XturnState implements GameState {
    @Override
    public void next(GameContext gameContext, Player player, boolean hasWon) {
        if(hasWon)
        {
            gameContext.setState(new XWonState());
            return;
        }

        gameContext.setState(new OTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}

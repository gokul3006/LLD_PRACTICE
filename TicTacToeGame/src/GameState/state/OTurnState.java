package GameState.state;

import GameState.GameState;
import GameState.context.GameContext;
import Utility.Player;
import Enum.Symbol;

public class OTurnState implements GameState {
    @Override
    public void next(GameContext gameContext, Player player, boolean hasWon) {
       if(hasWon)
       {
           gameContext.setState(new OWonState());
           return;
       }
       else {
           gameContext.setState(new XturnState());
       }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}

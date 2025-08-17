package GameState;

import GameState.context.GameContext;
import Utility.Player;

import javax.swing.plaf.metal.MetalBorders;

public interface GameState {
    void next(GameContext gameContext, Player player,boolean hasWon);
    boolean isGameOver();
}

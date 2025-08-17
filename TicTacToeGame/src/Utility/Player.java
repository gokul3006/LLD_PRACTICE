package Utility;
import Enum.Symbol;
import PlayerStrategies.PlayerStrategy;

public class Player {
    Symbol symbol;
    PlayerStrategy playerStrategy;
    public Player(Symbol symbol,PlayerStrategy playerStrategy)
    {
        this.symbol=symbol;
        this.playerStrategy=playerStrategy;
    }
    public Symbol getSymbol()
    {
        return this.symbol;
    }
    public PlayerStrategy getPlayerStrategy(){
        return this.playerStrategy;
    }
}

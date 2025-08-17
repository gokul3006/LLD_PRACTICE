package Utility;
import  Enum.Symbol;
import GameState.context.GameContext;
import GameState.state.DrawState;

public class Board {
    private final int rows;
    private final int cols;
    private Symbol[][] board;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Symbol[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position position)
    {
        return position.getRow()>=0 && position.getCol()>=0 && position.getRow()<rows && position.getCol()<cols && board[position.getRow()][position.getCol()]==Symbol.EMPTY;
    }
    public void makeMove(Position pos,Symbol symbol)
    {
        board[pos.getRow()][pos.getCol()]=symbol;
    }
    public boolean isWinningLine(Symbol[] symbols)
    {
        Symbol first=symbols[0];
        for(Symbol s:symbols)
        {
            if(s!=first)
            {
                return false;
            }
        }
        return true;
    }
    public void checkGameState(GameContext context, Player currentPlayer)
    {
        for(int i=0;i<rows;i++)
        {
            if(board[i][0]!=Symbol.EMPTY && isWinningLine(board[i]))
            {
                context.next(currentPlayer,true);
                return;
            }
        }
        for(int i=0;i<cols;i++)
        {
            Symbol[] symbol=new Symbol[rows];
            for(int j=0;j<rows;j++)
            {
                symbol[j]=board[j][i];
            }
            if(symbol[0]!=Symbol.EMPTY && isWinningLine(symbol))
            {
                context.next(currentPlayer,true);
                return;
            }
        }
        Symbol[] diag1=new Symbol[Math.min(rows,cols)];
        Symbol[] diag2=new Symbol[Math.min(rows,cols)];
        for(int i=0;i<Math.min(rows,cols);i++)
        {
            diag1[i]=board[i][i];
            diag2[i]=board[i][cols-i-1];
        }
        if(diag1[0]!=Symbol.EMPTY && isWinningLine(diag1))
        {
            context.next(currentPlayer,true);
            return;
        }
        if(diag2[0]!=Symbol.EMPTY && isWinningLine(diag2))
        {
            context.next(currentPlayer,true);
            return;
        }
        context.next(currentPlayer,false);
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]==Symbol.EMPTY)
                {
                    return;
                }
            }
        }
        context.setState(new DrawState());
    }
    public void printBoard()
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                Symbol s=board[i][j];
                switch (s)
                {
                    case Symbol.X:
                        System.out.print(" X ");
                        break;
                    case Symbol.O:
                        System.out.print(" O ");
                        break;
                    case Symbol.EMPTY :
                    default:
                        System.out.print(" . ");
                }
                if(j<cols-1)System.out.print("|");
            }
            System.out.println();
            if(i<rows-1)
            {
                for(int k=0;k<cols;k++) {
                    System.out.print("---");
                    if (k < cols - 1) System.out.print("+");
                }
            }
            System.out.println();
        }
    }
    }

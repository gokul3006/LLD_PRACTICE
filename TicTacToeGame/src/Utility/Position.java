package Utility;

public class Position {
   private int row;
   private int col;
    public Position(int row,int col)
    {
        this.row=row;
        this.col=col;
    }

    @Override
    public String toString() {
        return "( "+row+" , "+col+" )";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof Position))return false;
        Position temp=(Position) obj;
        return temp.col==this.col && temp.row==this.row;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    @Override
    public int hashCode() {
        return 31*row+col;
    }
}

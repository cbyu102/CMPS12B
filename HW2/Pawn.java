//Pawn class

public class Pawn extends ChessPiece{
  //constructors
  public Pawn(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(ChessPiece piece){ 
    //Check on top
    if(!color && (row+1) == piece.getRow() && (col) == piece.getCol()) return true;

    //Check on bottom
    if(color && (row-1) == piece.getRow() && (col) == piece.getCol()) return true;

    return false;
  }

  public String toString(){
    if(color) return "P";
    return "p";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
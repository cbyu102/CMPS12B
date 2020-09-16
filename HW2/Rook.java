//Rook class

public class Rook extends ChessPiece{
  //constructors
  public Rook(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(ChessPiece piece){
  
    //Checks if it gets attacked by row or col
    if(piece.getRow() == row) return true;
    if(piece.getCol() == col) return true;
    return false;
  }

  public String toString(){
    if(color) return "R";
    return "r";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
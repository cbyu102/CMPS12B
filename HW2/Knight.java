//Knight class

public class Knight extends ChessPiece{
  //constructors
  public Knight(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(ChessPiece piece){
    if((row-2) == piece.getRow() && (col-1) == piece.getCol()) return true;
    if((row-2) == piece.getRow() && (col+1) == piece.getCol()) return true;
    if((row-1) == piece.getRow() && (col-2) == piece.getRow()) return true;
    if((row-1) == piece.getRow() && (col+2) == piece.getCol()) return true;
    if((row+2) == piece.getRow() && (col-1) == piece.getCol()) return true;
    if((row+2) == piece.getRow() && (col+1) == piece.getCol()) return true;
    if((row+1) == piece.getRow() && (col-2) == piece.getCol()) return true;
    if((row+1) == piece.getRow() && (col+2) == piece.getCol()) return true;
    return false;
  }

  public String toString(){
    if(color) return "N";
    return "n";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
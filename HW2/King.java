//King class

public class King extends ChessPiece{
  //constructors
  public King(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(ChessPiece piece){ 
    //Check to the right
    if((row) == piece.getRow() && (col-1) == piece.getCol()) return true;
    //Check to the left
    if((row) == piece.getRow() && (col+1) == piece.getCol()) return true;
    //Check on top
    if((row+1) == piece.getRow() && (col) == piece.getCol()) return true;
    //Check on bottom
    if((row-1) == piece.getRow() && (col) == piece.getCol()) return true;
    //Check bottom and to the left
    if((row-1) == piece.getRow() && (col-1) == piece.getRow()) return true;
    //Check bottom and to the right
    if((row-1) == piece.getRow() && (col+1) == piece.getCol()) return true;
    //Check top and to the left
    if((row+1) == piece.getRow() && (col-1) == piece.getCol()) return true;
    //Check top and to the right
    if((row+1) == piece.getRow() && (col+1) == piece.getCol()) return true;
    return false;
  }

  public String toString(){
    if(color) return "K";
    return "k";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
//Queen class

public class Queen extends ChessPiece{
  //constructors
  public Queen(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(ChessPiece piece){

    //Checks if it gets attacked by row or col
    if(piece.getRow() == row) return true;
    if(piece.getCol() == col) return true;
    
    //Checks if it gets attacked by diagonals
    double rowDistance = row - piece.getRow();
    double colDistance = col - piece.getCol();
    if(rowDistance == 0 || colDistance == 0) return false;
    double att = colDistance / rowDistance;   
    if(att == 1 || att == -1) return true;
    return false;

  }

  public String toString(){
    if(color) return "Q";
    return "q";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
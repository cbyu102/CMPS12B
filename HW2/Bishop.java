//Bishop class

public class Bishop extends ChessPiece{
  //constructors
  public Bishop(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(ChessPiece piece){
  
    //Checks if it gets attacked by diagonals
    double rowDistance = row - piece.getRow();
    double colDistance = col - piece.getCol();
    if(rowDistance == 0 || colDistance == 0) return false;
    double att = colDistance / rowDistance;   
    if(att == 1 || att == -1) return true;
    return false;

  }

  public String toString(){
    if(color) return "B";
    return "b";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
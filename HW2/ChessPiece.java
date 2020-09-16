//ChessPiece class

public class ChessPiece{
  
  public int row = 0;
  public int col = 0;
  public boolean color = true;

  //Constructors
  public ChessPiece(){}
  public ChessPiece(int x, int y, boolean color){
    row = x;
    col = y;  
    color = this.color;
  }

  //Methods
  public int getRow(){
    return row;
  }
  public int getCol(){
    return col;
  }
  public void move(int x, int y){
    row = x;
    col = y;
  }
  public boolean attack(ChessPiece piece){
    return false;
  }
  public String printInfo(){
    return "";
  }

}
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
  public boolean getColor(){
    return color;
  }
  public void move(int x, int y){
    row = x;
    col = y;
  }
  public boolean attack(ChessPiece piece){
    return false;
  }
  public boolean getAtt(Node head, ChessPiece[][] board){
    return false;
  }
  public boolean canMove(ChessPiece[][] board, int row, int col){
    return false;
  }
  public int inCheck(Node head, ChessPiece[][] board){
    return 0;
  }
  public String printInfo(){
    return "";
  }

}
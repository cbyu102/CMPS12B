//Rook class

public class Rook extends ChessPiece{
  //constructors
  public Rook(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(int r, int c){

    //Checks if it gets attacked by row or col
    if(r == row && c == col) return false;
    if(r == row) return true;
    if(c == col) return true;
    return false;

  }

  public boolean canMove(ChessPiece[][] board, int r, int c){
    if(!this.attack(r, c)) return false;
    if(board[r][c] != null && board[r][c].getColor() == color) return false;

    //Checking Cols
    if(row == r){
      //left
      if(col > c){
        for(int i = c+1; i < col; i++){
          if(board[r][i] != null) return false;
        }
      }
      //right
      if(col < c){
        for(int i = col+1; i < c; i++){
          if(board[r][i] != null) return false;
        }
      }
    }
    //Checking Rows
    if(col == c){
      //up
      if(row > r){
        for(int i = r+1; i < row; i++){
          if(board[i][c] != null) return false;
        }
      }
      //down
      if(row < r){
        for(int i = row+1; i < r; i++){
          if(board[i][c] != null) return false;
        }
      }
    }
    return true;
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
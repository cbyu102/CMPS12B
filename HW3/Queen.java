//Queen class

public class Queen extends ChessPiece{
  //constructors
  public Queen(int x, int y, boolean color){
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
    
    //Checks if it gets attacked by diagonals
    double rowDistance = row - r;
    double colDistance = col - c;
    if(rowDistance == 0 || colDistance == 0) return false;
    double att = colDistance / rowDistance;   
    if(att == 1 || att == -1) return true;
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
    //Checking the top left
    if(row < r && col < c){
      int j = col + 1;
      for(int i = row + 1; i < r; i++){
        if(board[i][j] != null){
          return false;
        }
        j++;
      }
    }
    //Checking the top right
    if(row < r && col > c){
      int j = col - 1;
      for(int i = row + 1; i < r; i++){
        if(board[i][j] != null){
          return false;
        }
        j--;
      }
    }
    //Checking bottom left
    if(row > r && col < c){
      int j = col + 1;
      for(int i = row - 1; i > r; i--){
        if(board[i][j] != null){
          return false;
        }
        j++;
      }
    }
    //Checking bottom right
    if(row > r && col > c){
      int j = col - 1;
      for(int i = row - 1; i > r; i--){
        if(board[i][j] != null){
          return false;
        }
        j--;
      }
    }
    return true;
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
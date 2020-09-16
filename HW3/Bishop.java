//Bishop class

public class Bishop extends ChessPiece{
  //constructors
  public Bishop(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(int r, int c){
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
    if(color) return "B";
    return "b";
  }

  public String printInfo(){
    String str = this.toString();
    str += " " + row + " " + col;
    return str;
  }
}
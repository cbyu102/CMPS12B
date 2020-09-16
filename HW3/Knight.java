//Knight class

public class Knight extends ChessPiece{
  //constructors
  public Knight(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(int r, int c){
    if((row-2) == r && (col-1) == c) return true;
    if((row-2) == r && (col+1) == c) return true;
    if((row-1) == r && (col-2) == c) return true;
    if((row-1) == r && (col+2) == c) return true;
    if((row+2) == r && (col-1) == c) return true;
    if((row+2) == r && (col+1) == c) return true;
    if((row+1) == r && (col-2) == c) return true;
    if((row+1) == r && (col+2) == c) return true;
    return false;
  }

  public boolean canMove(ChessPiece[][] board, int r, int c){
    if(!this.attack(r, c)) return false;
    if(board[r][c] != null && board[r][c].getColor() == color) return false;
    return true;
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
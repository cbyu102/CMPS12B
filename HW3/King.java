//King class

public class King extends ChessPiece{
  //constructors
  public King(int x, int y, boolean color){
    row = x;
    col = y;
    this.color = color;
  }

  //Methods
  public boolean attack(int r, int c){ 
    //Check to the right
    if((row) == r && (col-1) == c) return true;
    //Check to the left
    if((row) == r && (col+1) == c) return true;
    //Check on top
    if((row+1) == r && (col) == c) return true;
    //Check on bottom
    if((row-1) == r && (col) == c) return true;
    //Check bottom and to the left
    if((row-1) == r && (col-1) == c) return true;
    //Check bottom and to the right
    if((row-1) == r && (col+1) == c) return true;
    //Check top and to the left
    if((row+1) == r && (col-1) == c) return true;
    //Check top and to the right
    if((row+1) == r && (col+1) == c) return true;
    return false;
  }

  public boolean canMove(ChessPiece[][] board, int r, int c){
    if(!this.attack(r, c)) return false;
    if(board[r][c] != null && board[r][c].getColor() == color) return false;
    return true;
  }

  public boolean getAtt(Node head, ChessPiece[][] board){
    Node n = head;
    while(n != null){
      //System.out.println(n.get());
      //System.out.println(n.get().canMove(board, row, col));
      if(n.get().canMove(board, row, col)){
        return true;
      }
      n = n.next;
    }
    return false;
  }

  public int inCheck(Node head, ChessPiece[][] board){
    ChessPiece tempK = new King(row, col, color);
    ChessPiece[][] tempboard = board;
    if(!tempK.getAtt(head, tempboard)){
      return 0;
    }
    tempboard[row][col] = null;
    if(col+1 < tempboard.length && canMove(board, row, col+1)){
      tempK.move(row, col+1);
      tempboard[row][col+1] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the right
        return 1;
      }
      tempboard[row][col+1] = null;
    }
    if(row+1 < tempboard.length && col+1 < tempboard.length && canMove(board, row+1, col+1)){
      tempK.move(row+1, col+1);
      tempboard[row+1][col+1] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the bottom right
        return 1;
      }
      tempboard[row+1][col+1] = null;
    }
    if(row-1 > 0 && col+1 < tempboard.length && canMove(board, row-1, col+1)){
      tempK.move(row-1, col+1);
      tempboard[row-1][col+1] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the top right
        return 1;
      }
      tempboard[row-1][col+1] = null;
    }
    if(col-1 > 0 && canMove(board, row, col-1)){
      tempK.move(row, col-1);
      tempboard[row][col-1] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the left
        return 1;
      }
      tempboard[row][col-1] = null;
    }
    if(row+1 < tempboard.length && col-1 > 0 && canMove(board, row+1, col-1)){
      tempK.move(row+1, col-1);
      tempboard[row+1][col-1] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the bottom left
        return 1;
      }
      tempboard[row+1][col-1] = null;
    }
    if(row-1 > 0 && col-1 > 0 && canMove(board, row-1, col-1)){
      tempK.move(row-1, col-1);
      tempboard[row-1][col-1] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the top left
        return 1;
      }
      tempboard[row-1][col-1] = null;
    }
    if(row+1 < tempboard.length && canMove(board, row+1, col)){
      tempK.move(row+1, col);
      tempboard[row+1][col] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the bottom
        return 1;
      }
      tempboard[row+1][col] = null;
    }
    if(row-1 > 0 && canMove(board, row-1, col)){
      tempK.move(row-1, col);
      tempboard[row-1][col] = tempK;
      if(!tempK.getAtt(head, tempboard)){ //Checking to the top
        return 1;
      }
      tempboard[row-1][col] = null;
    }
    return 2;
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
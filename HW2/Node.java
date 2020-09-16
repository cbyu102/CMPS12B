//Node.java

public class Node{
  ChessPiece piece;
  Node next;

  //Constructors
  public Node(){}
  public Node(ChessPiece piece){
    this.piece = piece;
    next = null;
  }

  //Methods
  public ChessPiece get(){
    return piece;
  }
}
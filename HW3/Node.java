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

  public Node previous(Node head){
    Node prev = null;
    Node n = head;
    while(n != null){
      if(n.get().equals(piece)){
        return prev;
      }
      prev = n;
      n = n.next;
    }
    return prev;
  }
}
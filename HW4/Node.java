//Node.java

public class Node{
  Item item;
  Node next;

  //Constructors
  public Node(){}
  public Node(Item item){
    this.item = item;
    next = null;
  }

  //Methods
  public Item get(){
    return item;
  }

  public Node previous(Node head){
    Node prev = null;
    Node n = head;
    while(n != null){
      if(n.get().equals(item)){
        return prev;
      }
      prev = n;
      n = n.next;
    }
    return prev;
  }

  public void delete(Node head){
    this.previous(head).next = this.next;
    this.next = null;
  }

  public Node findMax(){
    Node head = this;
    if(head == null) return null;
    if(head.next == null) return head;
    Node max = head;
    Node current = head.next;
    while(current != null){
      if(max.get().getPri() <= current.get().getPri()) max = current;
      current = current.next;
    }
    return max;
  }
}
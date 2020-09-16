//Node.java

public class Node{
  String word;
  int freq;
  Node parent;
  Node right;
  Node left;

  //Constructors
  public Node(){}
  public Node(String word){
    this.word = word;
    freq = 1;
    parent = null;
    right = null;
    left = null;
  }

  //Methods
  public String get(){
    return word;
  }
  public int getFreq(){
    return freq;
  }
  public void plus(){
    freq+=1;
  }
}
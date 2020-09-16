//Item class

public class Item{
  
  public int id = 0;
  public int priority = 0;

  //Constructors
  public Item(){}
  public Item(int e, int p){
    id = e;
    priority = p;
  }

  //Methods
  public int getID(){
    return id;
  }
  public int getPri(){
    return priority;
  }

}
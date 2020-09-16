import java.io.*;
import java.util.*;

class Priority{
  public static void main(String[] args) throws FileNotFoundException {
    // open files
    Scanner in = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter("analysis.txt");
    while(in.hasNextLine()){
      String line = in.nextLine().trim() + " ";
      String[] token = line.split("\\s+");
      int size = token.length;
      for(int i = 0; i < size; i++){
        String str = token[i];
        if(str.substring(0,1).equals("(")){
          int len = str.length();
          token[i] = str.substring(1, len-1);
        }else if(!str.substring(0,1).equals("d")){
          int len = str.length();
          token[i] = str.substring(0, len-1);
        }
      }

      int i = 0;
      Node head = null;
      Node current;
      while(i < size){
        if(token[i].equals("d")){
          i++;
          Node max = head.findMax();
          if(max != null){
            if(max != head){
              //System.out.println(max.get().getID() + " ");
              out.print(max.get().getID() + " ");
              max.delete(head);
            }else{
              //System.out.println(max.get().getID());
              out.print(max.get().getID() + " ");
              head = head.next;
            }
            continue;
          }
        }
        i+=2; System.out.println(i +", "+size);
        //System.out.println(token[i-2]+ ", " + token[i-1]);
        int id = Integer.parseInt(token[i-2]);
        int pr = Integer.parseInt(token[i-1]);
        current = new Node(new Item(id, pr));
        current.next = head;
        head = current;
      }
      out.println("");
    }
    in.close();
    out.close();
  }
}
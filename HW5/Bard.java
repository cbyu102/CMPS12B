import java.io.*;
import java.util.*;

class Bard{
  public static void main(String[] args) throws FileNotFoundException {
    // open files
    Scanner file = new Scanner(new File("shakespeare.txt"));
    Scanner file2 = new Scanner(new File("shakespeare.txt"));
    Scanner in = new Scanner(new File("input.txt"));
    PrintWriter analysis = new PrintWriter("analysis.txt");

    Node head = null;
    int total = 0;

    while(file.hasNextLine()){
      String line = file.nextLine().trim() + " ";
      String[] token = line.split("\\s+");

      for(int i = 0; i < token.length; i++){
        if(isUpperCase(token[i])){
          continue;
        }

        token[i] = token[i].replaceAll("[^\\w'-]", "");
        token[i] = token[i].toLowerCase();

        if(head == null){
          head = new Node(token[i]);
          continue;
        }

        insert(token[i], head);
      }
    }

    Node[] arr = new Node[1000000];

    while(in.hasNextLine()){
      String line = in.nextLine().trim() + " ";
      String[] token = line.split("\\s+");
      if(token.length == 1){
        Node a = find(token[0], head);
        if(a == null){
          analysis.println("0");
        }else{
          analysis.println(a.getFreq());
        }
      }else{
        total = traverse(head, arr, 0);
        Node arr2[] = new Node[total];
        for(int i = 0; i < total; i++){
          arr2[i] = arr[i];
        }
        int len = Integer.parseInt(token[0]);
        int num = Integer.parseInt(token[1]);
        sort(arr2);
        for(int i = arr2.length-1; i >= 0; i--){
          if(arr2[i].get().length() == len){
            analysis.print(arr2[i].get() + " ");
            num--;
          }
          if(num == 0) break;
        }
        analysis.println("");
      }
    }
    analysis.close();
    in.close();
    file.close();
  }

  public static void sort(Node[] arr){
    for(int i = 0; i < arr.length; i++){
      int index = i;
      for(int j = i+1; j < arr.length; j++){
        if(arr[j].getFreq() <= arr[index].getFreq()) index = j;
        Node small = arr[index];
        arr[index] = arr[i];
        arr[i] = small;
      }
    }
  }

  public static int traverse(Node start, Node[] aaa, int pos){
    if(start.left != null){
      pos = traverse(start.left, aaa, pos);
    }
    aaa[pos++] = start;
    if(start.right != null){
      pos = traverse(start.right, aaa, pos);
    }
    return pos;
  }

  public static boolean isUpperCase(String str) {
    return str.equals(str.toUpperCase());
  }

  public static Node find(String word, Node current){

    if(current == null) return null;

    if(current.get().compareTo(word) == 0){
      return current;
    }else if(current.get().compareTo(word) > 0){
      return find(word, current.right);
    }else{
      return find(word, current.left);
    }
  }

  public static void insert(String word, Node current){
    if(current.get().compareTo(word) == 0){
      current.plus();
      return;
    }
    if(current.get().compareTo(word) > 0){
      if(current.right == null){
        Node a = new Node(word);
        a.parent = current;
        current.right = a;
      }else{
        insert(word, current.right);
      }
    }
    if(current.get().compareTo(word) < 0){
      if(current.left == null){
        Node a = new Node(word);
        a.parent = current;
        current.left = a;
      }else{
        insert(word, current.left);
      }
    }
  }
}
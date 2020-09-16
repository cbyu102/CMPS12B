//Chessboard.java

import java.io.*;
import java.util.*;

class Chessboard{
  public static void main(String[] args) throws FileNotFoundException {
    // open files
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter analysis = new PrintWriter("analysis.txt");

    while(in.hasNextLine()){

      String line = in.nextLine().trim() + " ";
      String[] token = line.split("\\s+");

      int size = Integer.parseInt(token[0]);
      int len = 0;

      Node head = null;
      Node current = null;

      int row = in.nextInt();
      int col = in.nextInt();
      if(in.hasNextLine()){
        in.nextLine();
      }

      int numK = 0;
      int numk = 0;

      //checking if the cooridinates selected is in the board
      if(row > size || col > size){
        analysis.println("Invalid");
        continue;
      }
      int k = 0;

      //Setting an array of all the pieces
      for(int i = 1; i < token.length-1; i+=3){
        len++;
        if(token[i].equals("q")){ 
          head = new Node(new Queen(Integer.parseInt(token[i+1]),
                                    Integer.parseInt(token[i+2]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("k")){ 
          head = new Node(new King(Integer.parseInt(token[i+1]),
                                   Integer.parseInt(token[i+2]), false));
          head.next = current;
          current = head;
          numk++;
        }
        if(token[i].equals("n")){ 
          head = new Node(new Knight(Integer.parseInt(token[i+1]),
                                     Integer.parseInt(token[i+2]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("b")){ 
          head = new Node(new Bishop(Integer.parseInt(token[i+1]),
                                     Integer.parseInt(token[i+2]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("r")){ 
          head = new Node(new Rook(Integer.parseInt(token[i+1]),
                                   Integer.parseInt(token[i+2]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("p")){ 
          head = new Node(new Pawn(Integer.parseInt(token[i+1]),
                                   Integer.parseInt(token[i+2]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("Q")){ 
          head = new Node(new Queen(Integer.parseInt(token[i+1]),
                                    Integer.parseInt(token[i+2]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("K")){ 
          head = new Node(new King(Integer.parseInt(token[i+1]),
                                   Integer.parseInt(token[i+2]), true));
          head.next = current;
          current = head;
          numK++;
        }
        if(token[i].equals("N")){ 
          head = new Node(new Knight(Integer.parseInt(token[i+1]),
                                     Integer.parseInt(token[i+2]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("B")){ 
          head = new Node(new Bishop(Integer.parseInt(token[i+1]),
                                     Integer.parseInt(token[i+2]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("R")){ 
          head = new Node(new Rook(Integer.parseInt(token[i+1]),
                                   Integer.parseInt(token[i+2]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("P")){ 
          head = new Node(new Pawn(Integer.parseInt(token[i+1]),
                                   Integer.parseInt(token[i+2]), true));
          head.next = current;
          current = head;
        }
      }

      //Checking that there is only one of each king
      if(numk != 1 || numK != 1){
        analysis.println("Invalid");
        continue;
      }

      boolean cont = false;
      Node n = head;

      //Checking that no 2 pieces overlap
      for(int i = 0; i < len; i++){
        current = n.next;
        for(int j = i+1; j < len; j++){
          if(n.get().getRow() == current.get().getRow()){
            if(n.get().getCol() == current.get().getCol()){
              analysis.println("Invalid");
              cont = true;
              i = len;
              j = len;
            }
          }
          current = current.next;
        }
        n = n.next;
      }
      if(cont) continue;

      boolean attack = false;
      boolean attack2 = false;
      boolean set = false;
      ChessPiece orig = null;

      //Checking if selected point has a piece on it
      n = head;
      for(int i = 0; i < len; i++){
        int x = n.get().getRow();
        int y = n.get().getCol();
        if(row == x && col == y){
          orig = n.get();
          set = true;
        }
        n = n.next;
      }

      //If there is no piece, put "-"
      if(!set){
        analysis.print("- ");
      }else{
        //If there is a piece, print the piece
        analysis.print(orig.toString() + " ");
      }

      //Find two pieces that attack each other
      n = head;
      current = head;
      for(int i = 0; i < len; i++){
        current = n.next;
        for(int j = i+1; j < len; j++){
          attack = n.get().attack(current.get());
          attack2 = current.get().attack(n.get());
          if(attack){
            analysis.println(n.get().printInfo() + " " + current.get().printInfo());
            i = len;
            j = len;
          }else if(attack2){
            analysis.println(current.get().printInfo() + " " + n.get().printInfo());
            i = len;
            j = len;
          }
          current = current.next;
        }
        n = n.next;
      }
      if(!attack && !attack2) analysis.println("-");

    }
    // close files
    in.close();
    analysis.close();
  }
}
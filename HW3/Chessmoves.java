//Chessmoves.java

import java.io.*;
import java.util.*;

class Chessmoves{
  public static void main(String[] args) throws FileNotFoundException {
    // open files
    Scanner in = new Scanner(new File("input.txt"));
    PrintWriter analysis = new PrintWriter("analysis.txt");
    while(in.hasNextLine()){
      String line = in.nextLine().trim() + " ";
      String[] token = line.split("\\s+");
      line = in.nextLine().trim() + " ";
      String[] moves = line.split("\\s+");

      int size = Integer.parseInt(token[0]);
      int len = 0;

      Node head = null;
      Node current = null;

      int numK = 0;
      int numk = 0;
      Node k = null;
      Node K = null;

      //Setting an array of all the pieces
      for(int i = 1; i < token.length-1; i+=3){
        len++;
        if(token[i].equals("q")){ 
          head = new Node(new Queen(Integer.parseInt(token[i+2]),
                                    Integer.parseInt(token[i+1]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("k")){ 
          head = new Node(new King(Integer.parseInt(token[i+2]),
                                   Integer.parseInt(token[i+1]), false));
          head.next = current;
          current = head;
          k = head;
          numk++;
        }
        if(token[i].equals("n")){ 
          head = new Node(new Knight(Integer.parseInt(token[i+2]),
                                     Integer.parseInt(token[i+1]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("b")){ 
          head = new Node(new Bishop(Integer.parseInt(token[i+2]),
                                     Integer.parseInt(token[i+1]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("r")){ 
          head = new Node(new Rook(Integer.parseInt(token[i+2]),
                                   Integer.parseInt(token[i+1]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("p")){ 
          head = new Node(new Pawn(Integer.parseInt(token[i+2]),
                                   Integer.parseInt(token[i+1]), false));
          head.next = current;
          current = head;
        }
        if(token[i].equals("Q")){ 
          head = new Node(new Queen(Integer.parseInt(token[i+2]),
                                    Integer.parseInt(token[i+1]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("K")){ 
          head = new Node(new King(Integer.parseInt(token[i+2]),
                                   Integer.parseInt(token[i+1]), true));
          head.next = current;
          current = head;
          K = head;
          numK++;
        }
        if(token[i].equals("N")){ 
          head = new Node(new Knight(Integer.parseInt(token[i+2]),
                                     Integer.parseInt(token[i+1]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("B")){ 
          head = new Node(new Bishop(Integer.parseInt(token[i+2]),
                                     Integer.parseInt(token[i+1]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("R")){ 
          head = new Node(new Rook(Integer.parseInt(token[i+2]),
                                   Integer.parseInt(token[i+1]), true));
          head.next = current;
          current = head;
        }
        if(token[i].equals("P")){ 
          head = new Node(new Pawn(Integer.parseInt(token[i+2]),
                                   Integer.parseInt(token[i+1]), true));
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

      int att = 0;

      //Making an actual board
      Node a = head;
      ChessPiece board[][] = new ChessPiece[size+1][size+1];
      ChessPiece an1[][] = new ChessPiece[size+1][size+1];
      ChessPiece an2[][] = new ChessPiece[size+1][size+1];
      for(int i = 0; i < len; i++){
        board[a.get().getRow()][a.get().getCol()] = a.get();
        an1[a.get().getRow()][a.get().getCol()] = a.get();
        an2[a.get().getRow()][a.get().getCol()] = a.get();
        a = a.next;
      }

      String check = checked(head, k, K, an1, an2);

      while(att < moves.length){
        Node f = null;
        Node t = null;

        int fromC = Integer.parseInt(moves[att]); att++;
        int fromR = Integer.parseInt(moves[att]); att++;
        int toC = Integer.parseInt(moves[att]); att++;
        int toR = Integer.parseInt(moves[att]); att++;

        //Checking if selected points have a piece on it
        n = head;
        while(n != null){
          int x = n.get().getRow();
          int y = n.get().getCol();
          if(fromR == x && fromC == y){
            f = n;
          }
          if(toR == x && toC == y){
            t = n;
          }
          n = n.next;
        }

        //moving the pieces
        boolean canMove = false;
        canMove = board[fromR][fromC].canMove(board, toR, toC);
        if(canMove){ 
          analysis.print("Valid ");
          if(t != null){
            Node prev = t.previous(head);
            if(prev == null){
              head = t.next;
              t.next = null;
            }else if(t.next == null){
              prev.next = null;
            }else{
              prev.next = t.next;
              t.next = null;
            }
          }
          f.get().move(toR, toC);
          board[fromR][fromC] = null;
          board[toR][toC] = f.get();
        }else{
          analysis.print("Invalid");
          att = moves.length;
        }
      }
      analysis.println("");
      analysis.println(check);
    }
    // close files
    analysis.close();
  }
      
//Check if Kings are in check or checkmate
public static String checked(Node head, Node k, Node K, ChessPiece[][] an1, ChessPiece[][] an2){
  String aaa = "";
  int checkk = k.get().inCheck(head, an1);
  int checkK = K.get().inCheck(head, an2);
  if(checkk == 1){
    aaa+= "White in check";
  }else if(checkk == 2){
    return "White checkmated";
  }
  if(checkK == 1){
    if(checkk != 0) aaa+=" ";
    aaa+="Black in check";
  }else if(checkK == 2){
    if(checkk != 0) aaa+=" ";
    return "Black checkmated";
  }
  if(checkk == 0 && checkK == 0){
    aaa+="All kings safe";
  }
  return aaa;
}
}
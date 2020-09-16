/**
 * NQueens.java
 * This program solves the n Queens problem and allows the user to put the first queen down.
 *
 * Author: Crystal Yu (cbyu@ucsc.edu)
 */

import java.io.*;
import java.util.*;

class NQueens {

  public static boolean boolBoard[][];

  public static void main(String[] args) throws FileNotFoundException {
    int size = Integer.parseInt(args[0]);
    int col = Integer.parseInt(args[1])-1;
    int row = size - Integer.parseInt(args[2]);
    boolBoard = new boolean[size][size];

    int board[][] = new int[size][size];
    placeQueen(board, row, col, size);
    boolBoard[row][col] = true;
    boolean solved = solvePuzzle(board, size, col);

    PrintWriter out = new PrintWriter("solution.txt");

    if(solved){
      for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
          if(boolBoard[j][i]){
            out.println((i+1) + " " + (size-j));
          }
        }
      }
    }else{
      out.println("No Solution");
    }
    out.close();
  }
  
  public static boolean solvePuzzle(int[][] board, int n, int ncol){
    if(n == 0) return true;

    int size = board.length;
    int col = size - n;
    boolean solved = false;

//    System.out.println("n = " + n);
//    System.out.println("col = " + col);

    if(col == ncol){
      solved = solvePuzzle(board, n-1, ncol);
    }else{
      for(int i = size-1; i >= 0; i--){
        if(board[i][col] == 0){
          placeQueen(board, i, col, size);
          boolBoard[i][col] = true;
          solved = solvePuzzle(board, n-1, ncol);
        }
        if(solved) return solved;
        boolBoard[i][col] = false;
        resetBoard(board);
      }
    }
    return solved;
  }

  //Places the queen onto the board and fills the board
  public static void placeQueen(int[][]board, int row, int col, int size){
    fillRow(board, row);
    fillCol(board, col);
    fillDiag(board, row, col, size);
  }
  //Fills the selected row of the board
  public static void fillRow(int[][] board, int row) {
    for(int i = 0; i < board[0].length; i++){
      board[row][i] = 1;
    }  
  }
  //Fills the selected column of the board
  public static void fillCol(int[][] board, int col) {
    for(int i = 0; i < board[0].length; i++){
      board[i][col] = 1;
    }
  }
  //Fills all the diagonals of the imputed point of (row, col)
  public static void fillDiag(int[][] board, int row, int col, int size){
    size--;
    int tempRow = row; int tempCol = col;
    while(tempRow != 0 && tempCol != 0){
      tempRow--;
      tempCol--;
      board[tempRow][tempCol] = 1;
    }
    tempRow = row; tempCol = col;
    while(tempRow != 0 && tempCol != size){
      tempRow--;
      tempCol++;
      board[tempRow][tempCol] = 1;
    }
    tempRow = row; tempCol = col;
    while(tempRow != size && tempCol != 0){
      tempRow++;
      tempCol--;
      board[tempRow][tempCol] = 1;
    }
    tempRow = row; tempCol = col;
    while(tempRow != size && tempCol != size){
      tempRow++;
      tempCol++;
      board[tempRow][tempCol] = 1;
    }
  }

  //Resets the board to have queens placed where they are placed on the boolean board.
  public static void resetBoard(int[][] board){
    for(int i = 0; i < board.length; i++){
      Arrays.fill(board[i], 0);
    }
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(boolBoard[i][j]){
          placeQueen(board, i, j, board.length);
        }
      }
    }
  }
}
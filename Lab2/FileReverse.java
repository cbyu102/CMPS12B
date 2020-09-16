import java.io.*;
import java.util.*;

class FileReverse{
   public static void main(String[] args) throws IOException{
      Scanner in = new Scanner(new File(args[0]));
      PrintWriter out = new PrintWriter(new FileWriter(args[1]));

      while(in.hasNextLine()){
         String line = in.nextLine().trim() + " "; 

         String[] token = line.split("\\s+");  
     
         int n = token.length;
         for(int i=0; i<n; i++){
            out.println(stringReverse(token[i]));
         }
      }

      in.close();
      out.close();
   }
   
  public static String stringReverse(String s){
    String nStr = "";
    for(int i = s.length() - 1; i >= 0; i--){
      nStr += s.substring(i, i+1);
    }
    return nStr;
  }
}

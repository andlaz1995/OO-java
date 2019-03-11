//Andreas Lazarou
//c1544657
import java.io.*;
import java.util.*;
public class Factory {
   public static void main(String[] args) throws Exception {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//bufferreader needed to read input of user
      System.out.print("Card (c) or Die (d) game? ");//asks user to enter c or d
      String ans=br.readLine();//waits for user answer and puts it in string ans

      if (ans.equalsIgnoreCase("c")) {//checks if ans contains c, ignoring the case
         Game x=new Cards();//assigns game as implemented in Cards
         x.play();//calls the play function from Cards
      }
      else if (ans.equalsIgnoreCase("d")) {//checks if ans contains c, ignoring the case
         Game x=new Dice();//assigns Game as implemented in Dice
         x.play();//calls the play function from Dice
      }
      else System.out.println("Input not understood");//if user input is not c or d then prints input not understood
   }
}
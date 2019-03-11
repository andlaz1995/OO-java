//Andreas Lazarou
//c1544657
import java.io.*;
import java.util.*;
public class Dice implements Game {//implementing the interface
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//bufferreader needed to read input
  RandomInterface r=new LinearCongruentialGenerator();//using the same random number generator
  HashSet<Integer> numbersRolled=new HashSet<Integer>();//assigns numbersRolled as a Hashset
  @Override
  public void play() throws Exception{//the dice game method, putting the other methods together to create the game 
    Roll();//calling the Rolling method
    WinCon();//calling the method that gives the result

  }
  public HashSet<Integer> Roll() throws Exception{//rolling method
   	  

      for (int i=0; i<2; i++) {//rolls twice
        System.out.println("Hit <RETURN> to roll the die");
        br.readLine();//waits for user to hit enter
        int dieRoll=(int)(r.next() * 6) + 1;//generates random number 1-6 and puts it in dieRoll

        System.out.println("You rolled " + dieRoll);//prints what the user rolled
        numbersRolled.add(new Integer(dieRoll));//add the number rolled to numbersRolled
      }
      System.out.println(numbersRolled);//prints the numbers rolled
      return numbersRolled;//returns numbersRolled to be use by another method

  }
  public void WinCon(){
      // Now see if (s)he has won!
      if (numbersRolled.contains(new Integer(1))) {
        System.out.println("You won!");//if numbersRolled contain the integer 1 then prints you won
      }
      else System.out.println("You lost!");//if numbersRolled do not contain the integer 1 then prints you lost
    }

}
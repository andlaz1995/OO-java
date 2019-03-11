//Andreas Lazarou
//c1544657
import java.io.*;
import java.util.*;
public class Cards implements Game{//implementing the interface
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    // The random number generator used throughout
    RandomInterface r=new LinearCongruentialGenerator();
    HashSet<String> cardsChosen=new HashSet<String>();//assigns cardsChosen as a Hashset
    String cards[]={"AHrts", "2Hrts", "3Hrts", "4Hrts", "5Hrts", "6Hrts",
                      "7Hrts", "8Hrts", "9Hrts", "10Hrts", "JHrts",
                      "QHrts", "KHrts",
                      "ADmnds", "2Dmnds", "3Dmnds", "4Dmnds", "5Dmnds",
                      "6Dmnds", "7Dmnds", "8Dmnds", "9Dmnds", "10Dmnds",
                      "JDmnds", "QDmnds", "KDmnds",
                      "ASpds", "2Spds", "3Spds", "4Spds", "5Spds", "6Spds",
                      "7Spds", "8Spds", "9Spds", "10Spds", "JSpds",
                      "QSpds", "KSpds",
                      "AClbs", "2Clbs", "3Clbs", "4Clbs", "5Clbs", "6Clbs",
                      "7Clbs", "8Clbs", "9Clbs", "10Clbs", "JClbs",
                      "QClbs", "KClbs"};//creating the deck as a String Array
    ArrayList<String> cardList=new ArrayList<String> (Arrays.asList(cards));//converting String Array to ArrayList

   @Override
   public void play() throws Exception{//the card game method, putting the other methods together to create the game 
   	shuffle();//calling the shuffling method
   	choose();//calling the choosing method
   	result();//calling the result method
   }
   	
    public ArrayList<String> shuffle(){//shuffle method(used to shuffle the deck)
    	
        for (int i=0; i<100; i++) {
          // choose two random cards at random and swap them, 100 times
          int firstIndex=((int) (r.next() * 52));
          int secondIndex=((int) (r.next() * 52));

          String temp=(String) cardList.get(firstIndex);
          cardList.set(firstIndex, cardList.get(secondIndex));
          cardList.set(secondIndex, temp);


        }
        System.out.println(cardList);//printing the shuffled cardList
        return cardList;//returning the cardList to be used by other methods
    }
    public HashSet<String> choose() throws Exception{//exception needed as readline is in the code
        for (int i=0; i<2; i++) {
        System.out.println("Hit <RETURN> to choose a card");
        br.readLine();//asks user to hit return to draw a card

        int cardChoice=(int) (r.next() * cardList.size());//adds a random card to cardChoice
        System.out.println("You chose " + cardList.get(cardChoice));//Prints the card chosen
        cardsChosen.add(cardList.remove(cardChoice));//adds the card to cardsChosen
      }

      // Display the cards chosen and remaining cards
      System.out.println("Cards chosen: " + cardsChosen);//prints the cards chosen
      System.out.println("Remaining cards: " + cardList);//prints the remaining cards
      return cardsChosen;//returns cardsChosen to be used by the next method
      }
       public void result(){
        if (cardsChosen.contains("AHrts") || cardsChosen.contains("ADmnds") ||
          cardsChosen.contains("ASpds") || cardsChosen.contains("AClbs")) {
        System.out.println("You won!");//checks if cardsChosen contains an Ace. Prints You won if it does
      }
      else System.out.println("You lost!");//prints You lost if your cardsChosen do not contain an Ace
      }

} 
import java.util.Arrays;

public class Loops {


  public static void nHellos(int n) {
    for ( int i = 1; n >= i; i++){
      int tensRemainder = i % 10;
      int hunsRemainder = i % 100;
      if(i > 10 && i < 20){
        System.out.println(i + "th hello");
      }else if (tensRemainder == 1 || hunsRemainder == 1){
        System.out.println(i + "st hello");
      }else if(tensRemainder == 2 || hunsRemainder == 2){
        System.out.println(i + "nd hello");
      } else if(tensRemainder == 3 || hunsRemainder == 3){
        System.out.println(i + "rd hello");
      } else {
        System.out.println(i + "th hello");
      }
    }
  }


  public static double nRandoms(int n) {
    double sum = 0;
    for (int i = 0; i <= n; i++){
      sum += Math.random();
    }
    return sum / n;
  }


  public static boolean isPrime(int n) {
    boolean result = false;
    if(n < 3){
      return true;
    }
    
    for(int i = 2; i < n; i++){
      if (n % i == 0){
        return false;
      }else{
        result = true;
      }


    }


    return result;
  }


  public static int[] getFactors(int n) {
    int sumOfFactors = 0;
    for (int i = 1; i <= n; i++){
      if (n % i == 0){
        sumOfFactors++;
      }
    }
    int index = 0;
    int[] result = new int[sumOfFactors];
    for (int i = 1; i <= n; i++){
      if (n % i == 0){
        result[index] = i;
        index++;
      }
    }
    return result;
  }

  private static int rollDie(){
    return (int) (Math.random() * 6) + 1;
  }


  public static void pepysSimulation() {
    final int TRIALN = 1000000;
    int numOf1At6 = 0;
    int numOf1At12 = 0;
    for (int i = 0; i < TRIALN; i++){
      int amountOfOnesInTurn = 0;

      for (int j = 1; j <= 12; j++){
        int diceRoll = rollDie();
        if (diceRoll == 1 && j < 7 && amountOfOnesInTurn == 0){
          numOf1At6++;
          amountOfOnesInTurn++;
        }else if(diceRoll == 1 && amountOfOnesInTurn == 1){
          numOf1At12++;
          amountOfOnesInTurn++;
        }

      }
    }
    System.out.println(numOf1At6);
    System.out.println(numOf1At12);
    System.out.println("The probability of getting 1 at least once when rolling a fair (six-sided) die six times is: " + ((double) numOf1At6 / TRIALN));
    System.out.println("The probability of getting 1 at least twice when rolling it 12 times: " + ((double) numOf1At12 / TRIALN));

  }

  private static int randIntTo3() {
    return (int) (Math.random() * 3) + 1;
  }


  public static void montyHallSimulation(int n) {
    int dontSwitchCount = 0;
    int switchCount = 0;
    for (int i = 0; i < n; i++){  
      
      int doorOne = 1;
      int doorTwo = 2;
      int doorThree = 3;
      int doorOpen;
      int doorSwitch;
      int solution = randIntTo3();
      int userGuess = randIntTo3();
      if (solution != doorOne && userGuess != doorOne){
        doorOpen = doorOne;
      }else if (solution != doorTwo && userGuess != doorTwo){
        doorOpen = doorTwo;
      } else {
        doorOpen = doorThree;
      }

      if(doorOpen != doorOne && userGuess != doorOne){
        doorSwitch = doorOne;
      } else if(doorOpen != doorTwo && userGuess != doorTwo){
        doorSwitch = doorTwo;
      } else {
        doorSwitch = doorThree;
      }

      if (solution == doorSwitch){
        switchCount++;
      } else if(solution == userGuess){
        dontSwitchCount++;
      }
    }
    System.out.println("The probability of getting the solution correct when not switching is: " + ((double) dontSwitchCount / n));
    System.out.println("The probability of getting the solution correct when switching is: " + ((double) switchCount / n));
  }


  public static void main(String[] args) {

    //nHellos(10000);
    //System.out.println(nRandoms(9));
    //for (int i = 0; i <= 100; i++){
    //  System.out.println(i + " is prime " + isPrime(i));
    //}
    //System.out.println(Arrays.toString(getFactors(6)));
    //pepysSimulation();
    //montyHallSimulation(10000000);
  }
}
import java.lang.Integer;
import java.util.*;

/*
 * Wrtten by Jordane Thomas for Advance Computer Science Class 
 * 
 * Should get a number from the command line and 
 * then return the prime factorization of that number
 * 
 * #bug: if you enter a prime number it returns the number and 1
 * 
 */

class PrmFactor{
  
  /*
   * This method checks if a number is a Prime number.
   * If it is a prime number the method returns True else
   * false.
   */
  public static boolean isPrime(int num){
    for (int i = 2; i < num; i++){
      if (num%i == 0) return false;
    }
    return true;
  }
  
  /* 
   * Takes a number and returnes an arraylist of the prime
   * factorizations.
   */
  public static ArrayList<Integer> getPrimeFactorization(int num){
    ArrayList answers = new ArrayList ();
    int divBy = 2;
    while(num != 0){
      if (num%divBy == 0){//if divisable by divBy
        if (isPrime(divBy))
          answers.add(divBy);
        if (isPrime(num/divBy)){
          answers.add(num/divBy);
          break;
        }
        num /= divBy;
        divBy++;
      } else {
      divBy++;
      }
    }
    return answers;
  }
  
  /*
   * Code assumes that the args will always be a int
   */ 
  public static void main(String [] args){
    System.out.print(Arrays.toString(getPrimeFactorization(Integer.parseInt(args[0])).toArray()));
  }
}
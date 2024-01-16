// import arraylist and scanner packages

import java.util.ArrayList;
import java.util.Scanner;

class PrimeVariation {
// create a method to check if a number is prime.

  public static boolean isPrime(int number){
  if (number <= 1){
    return false;
  }
  if (number == 2){
    return true;
  }
  for (int i = 2; i < number; i++){
    if (number % i == 0){
      return false;
    }
  }
return true;
 }
  public static boolean isOdd (int number) {
    return number % 2 !=0;
  }
  
  public static void main(String[] args) {

    PrimeVariation pv = new PrimeVariation();
    int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};

    for ( int num : numbers) {
      if (isOdd(num)) {
        System.out.println(num + " is odd.");
      }else{
        System.out.println(num + " is even.");
      }
    }

    /*
    Uncomment this line to check if any of the numbers on the list above are prime.
    System.out.println(pv.isPrime(6));
    */

    Scanner userNumber = new Scanner(System.in);

    // check if user's favourite number is a prime number

  System.out.println("Hello. Let\'s check if your favourite number is prime."); 

  System.out.println("Please enter your number here: ");

  int favouriteNumber = userNumber.nextInt();

  System.out.println("Is " + favouriteNumber + " a prime number?");

  if (isPrime(favouriteNumber) == true) {
    System.out.println("Today is your lucky day! "+ favouriteNumber + " is definitely a prime number!");
  }else{
    System.out.println("Aw, I am sorry " + favouriteNumber + " is sadly not that special and thus, not a prime number." );
  }

System.out.println("Let\'s continue our fun!");

Scanner newNumber = new Scanner(System.in);


System.out.println("How about we check if your number is odd or even now?");
System.out.println("Please enter another number of your choice here: ");

int oddEven = newNumber.nextInt();

System.out.println("Is " + oddEven + " odd? " + isOdd(oddEven));



  }  

}
    


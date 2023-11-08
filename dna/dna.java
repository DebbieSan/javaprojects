// This program determines whether there is a protein in a strand of DNA.
public class dna {
  public static void main (String [] args) {
 //   -. .-.   .-. .-.   .-. .-.   .
 // \   \ /   \   \ /   \   \ /
// / \   \   / \   \   / \   \
// ~   `-~ `-`   `-~ `-`   `-~ `-


String dna1 = "ATGCGATACGCTTGA";
String dna2 = "ATGCGATACGTGA";
String dna3 = "ATTAATATGTACTGA";


/* Use the string below to check if a strand of DNA is a protein*/
/* For example, if you want to check the dna2 is protein, change dna3 below to dna2*/

String dna = dna3;

System.out.println(dna.length());

int start = dna.indexOf("ATG");
System.out.println("Starts: " + start);

int stop = dna.indexOf("TGA");
System.out.println("Stops: " + stop);

if ( start != -1 && stop != -1 && (stop - start) % 3 == 0) {
  System.out.println("Condition 1 and 2 are satisfied.");
  String protein = dna.substring(start, stop + 3);
  System.out.println("Protein: " + protein);
  }else{
    System.out.println("no protein");
  }


  }
}
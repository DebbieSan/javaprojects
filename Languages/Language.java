import java.util.ArrayList;

/* A small program to showcase the relationship between language families. It displays information from specific language families.
* this program can grow to include more language families and improve the display settings.
*/

public class Language {

  protected String name;
  protected int numSpeakers;
  protected String regionsSpoken;
  protected String wordOrder;

public Language (String langName, int speakers, String regions, String order){
  this.name = langName;
  this.numSpeakers = speakers;
  this.regionsSpoken = regions;
  this.wordOrder = order;
}

public void getInfo(){
  System.out.println(name + " is spoken by "+ numSpeakers+ " people mainly in " + regionsSpoken + ".");
  System.out.println("The language follows the word order: "+ wordOrder + ".");
}

  public static void main(String[] args){

 // uncomment to test any language.   

 /* Language spanish = new Language("spanish", 3000, " europe, north america", "subject,verb,object");
  spanish.getInfo();*/

  Language ixil = new Mayan("Ixil", 83600);
  
  Language yueChinese = new SinoTibetan("Yue-Chinese", 85576570);
 

  Language burmese = new SinoTibetan("Burmese", 38300000);


  ArrayList<Language> languages = new ArrayList<>();
 
  languages.add(ixil);
  languages.add(yueChinese);
  languages.add(burmese);
  
  for ( Language lang : languages){
    lang.getInfo();
  }

  }
}

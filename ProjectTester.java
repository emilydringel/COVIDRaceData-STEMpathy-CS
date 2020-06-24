import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ProjectTester{

  /*
  * Note: for a more advanced class,
  * data structures like a HashMap could help query faster
  */
  public static ArrayList<DataEntry> covidData = new ArrayList<DataEntry>();
  public static TotalCounter cntr = new TotalCounter();

  static int usPopulation = 330000000;
  static double whitePcnt = 60;
  static double blackPcnt = 13.5;

  /*
  * I chose Washington, DC as my example for a "state",
  * but these numbers can be swapped out easily
  */
  static int dcPopulation = 700000;
  static double whitePcntDC = 37;
  static double blackPcntDC = 47;

  public static void fillArrayList(CsvReader data) throws IOException{
    String[] theLine;
    while((theLine = data.nextLine())!=null){
      DataEntry next = new DataEntry(theLine);
      covidData.add(next);
    }
  }

  public static CsvReader setUpReader() throws FileNotFoundException{
    BufferedReader in = new BufferedReader(new FileReader("Data.csv"));
    CsvReader data = new CsvReader(in);
    return data;
  }

  public static void questionOne(){
    //% with covid by race
    double[] posPcnts = cntr.findTotals(covidData, null, null,0);
    posPcnts[1]=posPcnts[1]/(usPopulation*blackPcnt);
    posPcnts[0]=posPcnts[0]/(usPopulation*whitePcnt);
    System.out.println(posPcnts[1]+"% of Black Americans have tested positive for COVID-19.");
    System.out.println(posPcnts[0]+"% of White Americans have tested positive for COVID-19.");
    System.out.println("That's "+ posPcnts[1]/posPcnts[0] + "x as many Black Americans as White Americans.");
  }

  public static void questionTwo(){
    //% with covid by race, in DC
    double[] posPcnts = cntr.findTotals(covidData, "DC", null,0);
    posPcnts[1]=posPcnts[1]/(dcPopulation*blackPcntDC);
    posPcnts[0]=posPcnts[0]/(dcPopulation*whitePcntDC);
    System.out.println(posPcnts[1]+"% of Black DC residents have tested positive for COVID-19.");
    System.out.println(posPcnts[0]+"% of White DC residents have tested positive for COVID-19.");
    System.out.println("That's "+ posPcnts[1]/posPcnts[0] + "x as many Black DC residents as White DC residents.");
  }

  public static void questionThree(String date){
    //% with covid by race and date
    double[] posPcnts = cntr.findTotals(covidData, null, date,0);
    posPcnts[1]=posPcnts[1]/(usPopulation*blackPcnt);
    posPcnts[0]=posPcnts[0]/(usPopulation*whitePcnt);
    System.out.println(posPcnts[1]+"% of Black Americans tested positive for COVID-19 on " + date + ".");
    System.out.println(posPcnts[0]+"% of White Americans tested positive for COVID-19 on " + date + ".");
    System.out.println("That's "+ posPcnts[1]/posPcnts[0] + "x as many Black Americans as White Americans.");
  }

  public static void questionFour(){
    double[] ksTotal = cntr.findTotals(covidData, "KS", null, 1);
    double[] ksPos = cntr.findTotals(covidData, "KS", null, 0);
    double[] ilTotal = cntr.findTotals(covidData, "IL", null, 1);
    double[] ilPos = cntr.findTotals(covidData, "IL", null, 0);
    double[] soln = new double[2];
    for(int i=0; i<2; i++){
      soln[i]=(ksPos[i]+ilPos[i])/(ksTotal[i]+ilTotal[i]);
    }
    System.out.println(soln[1]+"% of Black Americans in KS & IL who were tested for COVID-19 tested positive.");
    System.out.println(soln[0]+"% of White Americans in KS & IL who were tested for COVID-19 tested positive.");
    System.out.println("That's "+ soln[1]/soln[0] + "x as many Black Americans as White Americans in KS & IL.");
  }

  public static final void main(String[] args){
    //tester
    try {
      fillArrayList(setUpReader());
      questionOne();
      questionTwo();
      questionThree("20200503");
      questionFour();
    } catch (FileNotFoundException e) {
            System.out.println(".csv File not found.");
    } catch (IOException e) {
            System.out.println("Error reading from .csv file.");
    }
  }
}

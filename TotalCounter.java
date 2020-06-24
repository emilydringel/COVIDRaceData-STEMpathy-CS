import java.util.ArrayList;

public class TotalCounter{

  /*Note:
  * The date portion of this can be done faster,
  * considering all the data from the same date
  * are next to each other in the data set.
  * I implemented a slower version to keep the solution
  * as neat as possible
  */

  //if includeNegatives is 0, don't include, if it's 1, include
  public double[] findTotals(ArrayList<DataEntry> data, String state, String date, int includeNegatives){
    double knownWhiteTotals=0;
    double knownBlackTotals=0;
    for(DataEntry entry:data){
      if(state==null && date==null){
        knownWhiteTotals+=entry.positives.knownWhite;
        knownBlackTotals+=entry.positives.knownBlack;
        if(includeNegatives==1){
          knownWhiteTotals+=entry.totalTests.knownWhite;
          knownBlackTotals+=entry.totalTests.knownBlack;
        }
      }else if (state!=null){
        if(date==null){
          if(entry.state.equals(state)){
            knownWhiteTotals+=entry.positives.knownWhite;
            knownBlackTotals+=entry.positives.knownBlack;
            if(includeNegatives==1){
              knownWhiteTotals+=entry.totalTests.knownWhite;
              knownBlackTotals+=entry.totalTests.knownBlack;
            }
          }
        }else{
          if(entry.state.equals(state)&&entry.date.equals(date)){
            knownWhiteTotals+=entry.positives.knownWhite;
            knownBlackTotals+=entry.positives.knownBlack;
            if(includeNegatives==1){
              knownWhiteTotals+=entry.totalTests.knownWhite;
              knownBlackTotals+=entry.totalTests.knownBlack;
            }
          }
        }
      }else{
        if(entry.date.equals(date)){
          knownWhiteTotals+=entry.positives.knownWhite;
          knownBlackTotals+=entry.positives.knownBlack;
          if(includeNegatives==1){
            knownWhiteTotals+=entry.totalTests.knownWhite;
            knownBlackTotals+=entry.totalTests.knownBlack;
          }
        }
      }
    }
    double[] soln = {knownWhiteTotals, knownBlackTotals};
    return soln;
  }

}

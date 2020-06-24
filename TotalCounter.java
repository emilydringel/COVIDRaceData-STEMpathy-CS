import java.util.ArrayList;

public class TotalCounter{


  //if includeNegatives is 0, don't include, if it's 1, include
  public double[] findTotals(ArrayList<DataEntry> data, String state, String date, int includeNegatives){
    double knownWhiteTotals=0;
    double knownBlackTotals=0;
    if(state==null && date==null){
      for(DataEntry entry:data){
        knownWhiteTotals+=entry.positives.knownWhite;
        knownBlackTotals+=entry.positives.knownBlack;
        if(includeNegatives==1){
          knownWhiteTotals+=entry.totalTests.knownWhite;
          knownBlackTotals+=entry.totalTests.knownBlack;
        }
      }
    }else if(date!=null){
      return findDateTotal(data, state, date, includeNegatives);
    }else{
      for(DataEntry entry: data){
        if(entry.state.equals(state)){
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

  public double[] findDateTotal(ArrayList<DataEntry> data, String state, String date, int includeNegatives){
    boolean startedDate = false;
    double knownWhiteTotals = 0;
    double knownBlackTotals = 0;
    for(DataEntry entry:data){
      if(state == null){
        if(entry.date.equals(date)){
          startedDate=true;
          knownWhiteTotals+=entry.positives.knownWhite;
          knownBlackTotals+=entry.positives.knownBlack;
          if(includeNegatives==1){
            knownWhiteTotals+=entry.totalTests.knownWhite;
            knownBlackTotals+=entry.totalTests.knownBlack;
          }
        }else if(!entry.date.equals(date)&&startedDate){
          double[] soln = {knownWhiteTotals, knownBlackTotals};
          return soln;
        }
      }else{
        if(entry.date.equals(date)&&entry.date.equals(state)){
          startedDate=true;
          knownWhiteTotals+=entry.positives.knownWhite;
          knownBlackTotals+=entry.positives.knownBlack;
          if(includeNegatives==1){
            knownWhiteTotals+=entry.totalTests.knownWhite;
            knownBlackTotals+=entry.totalTests.knownBlack;
          }
        }else if(!entry.date.equals(date)&&startedDate){
          double[] soln = {knownWhiteTotals, knownBlackTotals};
          return soln;
        }
      }

    }
    double[] soln = {0, 0};
    return soln;
  }

}

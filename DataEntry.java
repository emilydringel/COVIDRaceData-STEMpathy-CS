public class DataEntry{
  public String state;
  //in two letter abbreviation format
  public String date;
  //in yyyymmdd format
  public RaceBreakdownObject positives;
  public RaceBreakdownObject totalTests;

  public DataEntry(String[] csvLine){
    date = csvLine[0];
    state = csvLine[1];
    positives = new RaceBreakdownObject(csvLine[9], csvLine[10]);
    totalTests = new RaceBreakdownObject(csvLine[38], csvLine[39]);
  }

  public String toString(){
    return "State: " + state +
      "; Date: " + date + "; Positives: "
      + positives.toString() + "; Total Tests (if available): " + totalTests.toString();
  }
}

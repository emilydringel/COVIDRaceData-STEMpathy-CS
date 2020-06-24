public class RaceBreakdownObject{
  public int knownWhite;
  public int knownBlack;

  public RaceBreakdownObject(String white, String black){
    knownWhite = Integer.parseInt(white.replaceAll(",", ""));
    knownBlack = Integer.parseInt(black.replaceAll(",", ""));
  }

  public String toString(){
    return "Known White: " + knownWhite
      + "; Known Black: " + knownBlack;
  }
}

package Domain.IO;

// import
import java.util.Scanner;
import Domain.Interfaces.IGameDirectorInput;

public class ConsoleInput implements IGameDirectorInput {

  // asks the user for an input
  public void request() {
    String text = "";
    Scanner s = new Scanner(System.in);
    text = s.nextLine();
    text = format(text);

  }

  // make input into the type of input we want
  private String format(String s) {
    return s.toLowerCase();
  }

  // testing
  public static void main(String[] args) {
    ConsoleInput c = new ConsoleInput();

  }




}

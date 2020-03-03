package Domain.IO;

// import
import java.util.Scanner;
import Domain.Interfaces.IGameDirectorInput;

public class ConsoleUserInput implements IGameDirectorInput {

  String text;
  // asks the user for an input
  public void request() {
    String text = "";
    Scanner s = new Scanner(System.in);
    text = s.nextLine();
    text = format(text);
    this.text = text;
  }

  // make input into the type of input we want
  public String format(String s) {
    return s.toLowerCase();
  }

  // testing
  public static void main(String[] args) {
    ConsoleUserInput cui = new ConsoleUserInput();
    cui.request();
    System.out.println(cui.text);
  }




}

package Domain.IO;

// import
import java.util.Scanner;
import Domain.Interfaces.IGameDirectorInput;

public class ConsoleInput implements IGameDirectorInput {

  public String text;

  // asks the user for an input
  public void fetch() {
    String t = "";
    Scanner s = new Scanner(System.in);
    t = s.nextLine().toLowerCase(); // get and format
    this.text = t;
  }

  // testing
  public static void main(String[] args) {
    ConsoleInput c = new ConsoleInput();
    c.fetch();
    System.out.println(c.text);

  }




}

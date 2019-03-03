//Testing for read file
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

//ncurses (in c/c++) - API for text-user interfaces

public class SampleFileReader {


  public static void main(String args[]) throws IOException {
    // this code can be replaced with the game folder's directory.
    // works great because it will take us straight to the working directory.
    System.out.println(System.getProperty("user.dir"));

    // the path is the working directory + the folder + the item.
    String p = Paths.get(System.getProperty("user.dir") + "/TextFiles/sampleText.txt").toString();


    Files.lines(Paths.get(p)).forEach(System.out::println);


  }

}

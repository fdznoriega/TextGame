//Testing for read file
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

//ncurses (in c/c++) - API for text-user interfaces

public class SampleFileReader {


  public static void main(String args[]) {
    // implementing cleaner error handling.
    String userDirectory = System.getProperty("user.dir");
    String p = Paths.get(userDirectory + "/TextFiles/sampleText.txt").toString();

		try {
			Files.lines(Paths.get(p)).forEach(System.out::println);
		}
    catch (IOException e) {
			System.out.println("Could not retrieve file.");
		}

  }

}

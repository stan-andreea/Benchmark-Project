import java.text.DecimalFormat;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class MAlloc {

    long startTime = System.nanoTime();
    int[] intArray = new int[1000];
    long endTime = System.nanoTime();
    double diff = endTime - startTime;
    public double executionTime =diff/100000;

    DecimalFormat df = new DecimalFormat("#.#####");



    public void print(){
        try {
            FileWriter myWriter = new FileWriter("JVMemAllocSt.txt");
            myWriter.write(String.valueOf(executionTime));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

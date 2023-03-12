import java.text.DecimalFormat;

public class MemAcc {

        int[] intArray = new int[1000];


        DecimalFormat df = new DecimalFormat("#.#####");

        public void acc(){
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = i;
            }

        }




}

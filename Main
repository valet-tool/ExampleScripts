import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Main {

    private double U; //Utility
    private double L; //Latency
    private double C; //Cost
    final private int R  = 5; //Reward (Arbitrarily Defined)
    final private String csvFile = "/Users/dxkvse/Desktop/exampleOutput.csv"; // Location of csv output file being read in


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        // Define values that cannot be changed

        // Use hardcoded Latency and cost values
        L = 2;
        C = 5;
        System.out.println("The expected Utility:" + UtilityEquation(L, C));


        // Next use some values from our dataset. This will show how the expected utility wil change with anticpated tactic volatility

// ***********************


        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] tacticValues = line.split(cvsSplitBy);

               // System.out.println("Country [code= " + country[0] + " , name=" + country[1] + "]");

                System.out.println("The expected Utility:" + UtilityEquation(Double.parseDoubletacticValues[1]), tacticValues[2]));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

// The average expected utility:

// ***********************
      //  System.out.println("The expected Utility:" + UtilityEquation(L, C));

    }

    // Utility equation created for demonstration purposes
    private double UtilityEquation(double Latency, double Cost){
        // Very simple Utilty equation

        U = (R/C+L);


/*
        if(T<=L){
            U = (Ro+Rm)/C;
        }else{
            U = (Rm)/C;
        }
  */
        return U;
    }




}

/* Todo
- Make convert to Double, values should be double


 */

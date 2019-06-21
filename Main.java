/*

Description: This script is used to demonstrate a very basic example of the implications of accounting for tactic volatility in a generic utility equation.
The added tactic values are derived from a small result-set from the VALET tactic volatility data creation tool.


 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class Main {

    private double U; //Utility
    final private int R  = 50; //Reward (Arbitrarily Defined)
    final private int T = 5; //Arbitrarily defined latency threshold
    final private int P = 2; //Arbitrarily defined penalty
    private double TotalCalUtil; // Used to store the calcuated utility value for all iterations
//    final private String csvFile = "/Users/dxkvse/Desktop/exampleOutput_simple.csv"; // Location of csv output file being read in
    final private String csvFile = "/Users/dxkvse/Desktop/GH/ExampleScripts/exampleOutput_simple.csv"; // Location of csv output file being read in


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        // Define values that cannot be changed

        // Use hardcoded latency and cost values, emulating the use of static tactic values
        double L = 2; //Latency
        double C = 5; //Cost
        System.out.println("The expected Utility (static values):" + UtilityEquation(L, C));

// ***********************


        System.out.println(" **** Start Using Dynamic Tactic Values ***** ");

        // Next use some values from our dataset. This will show how the expected utility wil change with anticpated tactic volatility
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int counter = 0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] tacticValues = line.split(cvsSplitBy);
                double Util = UtilityEquation(Double.parseDouble(tacticValues[3]), Double.parseDouble(tacticValues[1]));

                TotalCalUtil += Util; // Determine the total calculated utilty. Used for displaying average utility

                System.out.println(counter + ") The expected Utility: " + Util);
                //System.out.println(Util);
                counter=counter+1;  // Helps determine the average utilty from the evaluation

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

        System.out.println("Average Util: " + TotalCalUtil/counter);

    }

    // Utility equation created for demonstration purposes
    private double UtilityEquation(double Latency, double Cost){
       // System.out.println("Input Values:" + Latency + " " + Cost);
        // Very simple utilty equation


        if(Latency>T){
            U = (R/Cost)-P;
        }else{
            U = (R/Cost);
        }


        return U;
    }


    // Response must be made in X amount of time, other wise a pentalty is incurred.


}

/* Todo
- Make convert to Double, values should be double


 */
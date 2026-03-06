import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini‑Project.
 *
 * TODO:
 *  - Update the path to your dataset file
 *  - Read the CSV file using Scanner
 *  - Parse each row and extract the correct columns
 *  - Construct Data objects from each row
 *  - Store them in an array
 *  - Write methods to analyze the dataset (min, max, average, filters, etc.)
 *  - Print insights and answer your guiding question
 *  - Add Javadoc comments for any methods you create
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {

        // TODO: Update this with your CSV file path
        File file = new File("WorldIndicators2000 (2).csv");

        // TODO: Create an array of Data objects to store data
        CountryStat[] countryStats = new CountryStat[500]; // Assuming max 1000 rows
        int count = 0;

        // TODO: Read file using Scanner
        // - Skip header if needed
        // - Loop through rows
        // - Split each line by commas
        // - Convert text to numbers when needed
        // - Create new Data objects
        // - Add to your array
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            scanner.nextLine(); 
        }
        while (scanner.hasNextLine() && count < countryStats.length) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            
            String country = parts[0].trim();
            double birthRate = Double.parseDouble(parts[2].trim());
            int lifeExpectancy = (int) Double.parseDouble(parts[11].trim());

            countryStats[count] = new CountryStat(country, birthRate, lifeExpectancy);
            count++;
        }
        scanner.close();
    
            // TODO: Call your analysis methods
            // Example:
            // double maxValue = findMaxValue(dataList);
            // double average = computeAverageValue(dataList);
            CountryStat highestBirthRateCountry = CountryStat.findMaxBirthRateCountry(countryStats, count);
            double averageBirthRate = CountryStat.computeAverageBirthRate(countryStats, count);

    
            // TODO: Print insights
            // - Number of rows loaded
            // - Min, max, average, or any other findings
            // - Final answer to your guiding question
            if (highestBirthRateCountry != null) {
                System.out.println("The country with the highest birth rate is " + highestBirthRateCountry.getCountryName() + 
                                   " with a rate of " + highestBirthRateCountry.getBirthRate());
            }
            
            System.out.println("The data shows that " + highestBirthRateCountry.getCountryName() + 
            " has the highest birth rate compared to the global average of " + averageBirthRate);

        
        }



}
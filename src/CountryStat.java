/**
 * Represents a single country's statistics from the World Indicators 2000 dataset.
 */
public class CountryStat {

    private String countryName;
    private double birthRate;
    private int lifeExpectancy;

    /**
     * Constructor for CountryStat.
     * @param countryName Name of the country
     * @param birthRate The birth rate per 1,000 people
     * @param lifeExpectancy The average life expectancy in years
     */
    public CountryStat(String countryName, double birthRate, int lifeExpectancy) {
        this.countryName = countryName;
        this.birthRate = birthRate;
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getCountryName() { 
        return countryName; 
    }
    public double getBirthRate() { 
        return birthRate; 
    }
    public int getLifeExpectancy() { 
        return lifeExpectancy; 
    }

    /**
     * Calculates the average birth rate for the loaded data.
     * @param stats The array of country objects
     * @param count The number of actual objects stored in the array
     * @return The mean birth rate
     */
    public static double computeAverageBirthRate(CountryStat[] stats, int count) {
        if (count == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += stats[i].getBirthRate();
        }
        return sum / count;
    }

    /**
     * Finds the country object with the highest birth rate.
     * @param stats The array of country objects
     * @param count The number of actual objects stored in the array
     * @return The CountryStat object with the maximum birth rate
     */
    public static CountryStat findMaxBirthRateCountry(CountryStat[] stats, int count) {
        if (count == 0) {
            return null;
        }
        CountryStat maxCountry = stats[0];
        for (int i = 1; i < count; i++) {
            if (stats[i].getBirthRate() > maxCountry.getBirthRate()) {
                maxCountry = stats[i];
            }
        }
        return maxCountry;
    }

    @Override
    public String toString() {
        return countryName + " (Birth Rate: " + birthRate + ", Life Expectancy: " + lifeExpectancy + ")";
    }
}
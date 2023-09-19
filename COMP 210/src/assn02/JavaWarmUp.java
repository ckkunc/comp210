package assn02;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

// Here is a starter code that you may optionally use for this assignment.
// TODO: You need to complete these sections

public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt();
        // MM/DD/YY, HH:MM, Name, Price, Quantity, Rating, Duration

        // create corresponding size arrays
        String[] dateT = new String[n];
        String[] timeT = new String[n];
        String[] categoryT = new String[n];
        double[] Assembling_fee = new double[n];
        int[] quantityT = new int[n];
        double[] Assembling_Time = new double[n];
        double[] Energy_and_Device_Cost = new double[n];

		// TODO: Fill in the above arrays with data entered from the console.
		// Your code starts here:
        for (int i=0; i < n; i++) {
            dateT[i] = s.next();
            timeT[i] = s.next();
            categoryT[i] = s.next();
            Assembling_fee[i] = s.nextDouble();
            quantityT[i] = s.nextInt();
            Assembling_Time[i] = s.nextDouble();
            Energy_and_Device_Cost[i] = s.nextDouble();
        }
		// Your code ends here.

        // Find items with highest and lowest price per unit
        int highestItemIndex = getMaxPriceIndex(Assembling_fee);
        int lowestItemIndex = getMinPriceIndex(Assembling_fee);

		// TODO: Print items with highest and lowest price per unit.
		// Your code starts here:
        System.out.println(dateT[highestItemIndex]);
        System.out.println(timeT[highestItemIndex]);
        System.out.println(categoryT[highestItemIndex]);
        System.out.println(Assembling_fee[highestItemIndex]);
        System.out.println(dateT[lowestItemIndex]);
        System.out.println(timeT[lowestItemIndex]);
        System.out.println(categoryT[lowestItemIndex]);
        System.out.println(Assembling_fee[lowestItemIndex]);
		// Your code ends here.

        // Calculate the average price, rating and duration of sales by category.
        // Maintain following category-wise stats in Arrays
        int[] numOfCategoriesC = new int[categoriesList.length];// so numOfCategoriesC[0] = # of categories of type categoriesList[0]
        double[] totPriceC = new double[categoriesList.length]; // total price of each category = sum(price x qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totAssembling_TimeC = new double[categoriesList.length]; // total Rating of each category = sum(price x qty)
        double[] totEnergy_and_Device_CostC = new double[categoriesList.length]; // total Duration of each category = sum(price x qty)


		// TODO: set the value of catIndex for each i to be such that categoryT[i] == categoriesList[i].
		// Your code starts here:
        ArrayList<Integer> laptopIndices = new ArrayList<>();
        ArrayList<Integer> phoneIndices = new ArrayList<>();
        ArrayList<Integer> smartWatchIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (categoryT[i].equals("laptop")) {
                laptopIndices.add(i);
            } else if (categoryT[i].equals("phone")) {
                phoneIndices.add(i);
            } else {
                smartWatchIndices.add(i);
            }
        }
		// Your code ends here.

		// TODO: Calculate & Print Category-wise Statistics
		// Your code starts here:
        DecimalFormat df = new DecimalFormat("#.##");

        int totalPhones = 0;
        double averagePhoneFee = 0;
        double phoneProfit = 0;
        ArrayList<Double> phoneProfits = new ArrayList<>();
        for (int index : phoneIndices) {
            totalPhones += quantityT[index];
            averagePhoneFee +=  Assembling_fee[index] * quantityT[index];
            phoneProfit = (Assembling_fee[index] * quantityT[index] - Assembling_Time[index] * 16) / quantityT[index];
            phoneProfits.add(phoneProfit);
        }
        averagePhoneFee /= totalPhones;
        double totalPhoneProfit = 0;

        totalPhoneProfit /= phoneIndices.size();
        System.out.println(categoriesList[0]);
        System.out.println(totalPhones);
        System.out.println(df.format(averagePhoneFee));
        System.out.println(totalPhoneProfit);


        int totalLaptops = 0;
        double averageLaptopFee = 0;
        for (int index : laptopIndices) {
            totalLaptops += quantityT[index];
            averageLaptopFee +=  Assembling_fee[index] * quantityT[index];

        }
        averageLaptopFee /= totalLaptops;

        System.out.println(categoriesList[1]);
        System.out.println(totalLaptops);
        System.out.println(df.format(averageLaptopFee));

        int totalSmartWatches = 0;
        double averageSmartWatchFee = 0;
        for (int index : smartWatchIndices) {
            totalSmartWatches += quantityT[index];
            averageSmartWatchFee+=  Assembling_fee[index] * quantityT[index];
        }
        averageSmartWatchFee /= totalSmartWatches;

        System.out.println(categoriesList[2]);
        System.out.println(totalSmartWatches);
        System.out.println(df.format(averageSmartWatchFee));
        // Your code ends here.
    }

    // TODO: Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
		// Your code starts here:
        int maxIndex = 0;
        for (int i = 0; i < priceT.length; i++) {
            if (priceT[i] >= priceT[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex; // modify this as well
		// Your code ends here.
    }

    // TODO: Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
		// Your code starts here:
        int minIndex = 0;
        for (int i = 0; i < priceT.length; i++) {
            if (priceT[i] <= priceT[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex; // modify this as well
		// Your code ends here.
    }
}

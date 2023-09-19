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
            phoneProfit = (Assembling_fee[index] * quantityT[index] - Assembling_Time[index] * 16 - Energy_and_Device_Cost[index]);
            phoneProfits.add(phoneProfit);
        }
        averagePhoneFee /= totalPhones;
        double totalPhoneProfit = 0;
        for (double profit : phoneProfits) {
            totalPhoneProfit += profit;
        }
        totalPhoneProfit /= totalPhones;
        System.out.println(categoriesList[0]);
        System.out.println(totalPhones);
        System.out.println(df.format(averagePhoneFee));
        System.out.println(df.format(totalPhoneProfit));

        int totalLaptops = 0;
        double averageLaptopFee = 0;
        double laptopProfit = 0;
        ArrayList<Double> laptopProfits = new ArrayList<>();
        for (int index : laptopIndices) {
            totalLaptops += quantityT[index];
            averageLaptopFee +=  Assembling_fee[index] * quantityT[index];
            laptopProfit = (Assembling_fee[index] * quantityT[index] - Assembling_Time[index] * 16 - Energy_and_Device_Cost[index]);
            laptopProfits.add(laptopProfit);
        }
        averageLaptopFee /= totalLaptops;
        double totalLaptopProfit = 0;
        for (double profit : laptopProfits) {
            totalLaptopProfit += profit;
        }
        totalLaptopProfit /= totalLaptops;
        System.out.println(categoriesList[1]);
        System.out.println(totalLaptops);
        System.out.println(df.format(averageLaptopFee));
        System.out.println(df.format(totalLaptopProfit));
        ArrayList<Double> smartWatchProfits = new ArrayList<>();
        int totalSmartWatches = 0;
        double averageSmartWatchFee = 0;
        double smartWatchProfit = 0;

        for (int index : smartWatchIndices) {
            totalSmartWatches += quantityT[index];
            averageSmartWatchFee+=  Assembling_fee[index] * quantityT[index];
            smartWatchProfit = (Assembling_fee[index] * quantityT[index] - Assembling_Time[index] * 16 - Energy_and_Device_Cost[index]);
            smartWatchProfits.add(smartWatchProfit);
        }
        averageSmartWatchFee /= totalSmartWatches;
        double totalSmartWatchProfit = 0;
        for (double profit : smartWatchProfits) {
            totalSmartWatchProfit += profit;
        }
        totalSmartWatchProfit /= totalSmartWatches;
        System.out.println(categoriesList[2]);
        System.out.println(totalSmartWatches);
        System.out.println(df.format(averageSmartWatchFee));
        System.out.println(df.format(totalSmartWatchProfit));
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

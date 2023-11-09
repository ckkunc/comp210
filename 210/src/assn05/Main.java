package assn05;

public class Main {

    public static void main(String[] args) {
        testP1();
        testP2();
//        testP3();
        testP4();
    }

    // test Part 1
    public static void testP1(){
        SimpleEmergencyRoom simpleER = new SimpleEmergencyRoom();
        simpleER.addPatient("John Doe", 5);
        assert simpleER.dequeue().getValue().equals("John Doe");
    }

    // test Part 2
    public static void testP2(){
        MaxBinHeapER complexER = new MaxBinHeapER();
        complexER.enqueue("John Doe", 5);
        assert complexER.dequeue().equals("John Doe");
    }

    /*
    Part 3
     */
    public static void testP3(){
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }
    }

    /*
    Part 4
     */
    public static void testP4() {
        double[] runtimes = compareRuntimes();
        System.out.println("SimpleEmergencyRoom dequeue time: " + runtimes[0] + " ms");
        System.out.println("MaxBinHeapER dequeue time: " + runtimes[1] + " ms");
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }

    public static double[] compareRuntimes() {
        double[] results = new double[4];
        long startTime, endTime;

        // Task 4.1
        SimpleEmergencyRoom simpleER = new SimpleEmergencyRoom();
        fillER(simpleER);
        startTime = System.nanoTime();
        while (!simpleER.getPatients().isEmpty()) {
            simpleER.dequeue();
        }
        endTime = System.nanoTime();
        results[0] = (endTime - startTime);
        results[1] = results[0] / 100000; // Average time per patient

        // Task 4.2
        MaxBinHeapER complexER = new MaxBinHeapER();
        fillER(complexER);
        startTime = System.nanoTime();
        while (complexER.size() > 0) {
            complexER.dequeue();
        }
        endTime = System.nanoTime();
        results[2] = (endTime - startTime);
        results[3] = results[2] / 100000; // Average time per patient

        return results;
    }
}




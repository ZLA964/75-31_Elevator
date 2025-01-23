package telran.elevator;

import telran.elevator.model.Elevator;
import telran.elevator.task.Truck;
import telran.elevator.task.TruckFor2;

public class Elevator2Appl {
    private static final int N_TRUCK =10_000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20 ;

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator("V.I.Lenin");
        Elevator elevator1 = new Elevator("Marks");

        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[N_TRUCK];
        for (int i =0; i<threads.length; i++) {

            threads[i] = new Thread(new TruckFor2(N_RACES, CAPACITY, elevator, elevator1));
            threads[i].start();
        }

        for(int i=0; i < threads.length; i++) {
            threads[i].join();
        }
        long stop = System.currentTimeMillis();
        long timeWork = stop - start;
        System.out.println("Elevator " +elevator.getName() + " has " + elevator.getCurrentVolume());
        System.out.println("Elevator " +elevator1.getName() + " has " + elevator1.getCurrentVolume());
        System.out.println("timeWork -> " + timeWork);

    }
}

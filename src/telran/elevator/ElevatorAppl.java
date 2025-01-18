package telran.elevator;

import telran.elevator.model.Elevator;
import telran.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCK =50_000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20 ;

    public static void main(String[] args) throws InterruptedException {
        Elevator elevator = new Elevator("V.I.Lenin");

        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[N_TRUCK];
        for (int i =0; i<threads.length; i++) {
            threads[i] = new Thread(new Truck(N_RACES, CAPACITY, elevator));
            threads[i].start();
        }

        for(int i=0; i < threads.length; i++) {
            threads[i].join();
        }
        long stop = System.currentTimeMillis();
        long timeWork = stop - start;
        System.out.println("Elevator " +elevator.getName() + " has " + elevator.getCurrentVolume());
        System.out.println("timeWork -> " + timeWork);

    }
}

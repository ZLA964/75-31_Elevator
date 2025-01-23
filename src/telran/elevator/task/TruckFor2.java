package telran.elevator.task;

import telran.elevator.model.Elevator;

import java.util.Random;

public class TruckFor2 implements Runnable{
    public static Random random = new Random();
    private final int nRaces;
    private final int capacity;
    private final Elevator elevator;
    private final Elevator elevator1;

    public TruckFor2(int nRaces, int capacity, Elevator elevator, Elevator elevator1) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
        this.elevator1 = elevator1;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            int distance = 13;
            if (random.nextBoolean()) {
                elevator.add(capacity / 2);
                try {
                    Thread.sleep(distance);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                elevator1.add(capacity / 2);
            } else {
                elevator1.add(capacity / 2);
                try {
                    Thread.sleep(distance);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                elevator.add(capacity / 2);
            }
        }
    }

}

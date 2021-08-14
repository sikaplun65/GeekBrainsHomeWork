package Lesson13;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int carsCount;

    static {
        carsCount = 0;
    }

    private Race race;
    private int speed;
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;
    private static AtomicInteger raceResult = new AtomicInteger(0);
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    protected Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        carsCount++;
        this.name = "Участник #" + carsCount;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        countDownLatch.countDown();
        int finalResult = raceResult.incrementAndGet();
        if (finalResult == 1) {
            System.out.println(this.name + " ПОБЕДИЛ В ГОНКЕ!!!");
        } else {
            System.out.printf("%s занял %d место%n", this.name, finalResult);
        }
    }
}

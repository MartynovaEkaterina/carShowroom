import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {

    private CarShow carShow;
    final int TIME_SHOP = 3000;
    final int TIME_BUILD = 5000;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public Seller(CarShow carShow) {
        this.carShow = carShow;
    }

    public void initBuild() {
        lock.lock();
        try {
            Thread.sleep(TIME_BUILD);
            carShow.getCars().add(new Car());
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Car sellCar() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (carShow.getCars().size() == 0) {
                System.out.println("Машин нет!");
                condition.await();
            }
            Thread.sleep(TIME_SHOP);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return carShow.getCars().remove(0);
    }
}

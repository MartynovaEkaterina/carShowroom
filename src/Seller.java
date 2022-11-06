public class Seller {

    private CarShow carShow;
    final int TIME_SHOP = 3000;
    final int TIME_BUILD = 5000;


    public Seller(CarShow carShow) {
        this.carShow = carShow;
    }

    public synchronized void initBuild() {
        try {
            Thread.sleep(TIME_BUILD);
            carShow.getCars().add(new Car());
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (carShow.getCars().size() == 0) {
                System.out.println("Машин нет!");
                wait();
            }
            Thread.sleep(TIME_SHOP);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carShow.getCars().remove(0);
    }
}

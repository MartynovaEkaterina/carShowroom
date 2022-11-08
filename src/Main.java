public class Main {
    public static void main(String[] args){
        final CarShow carShow = new CarShow();
        for (int i = 1; i <= 10; i++) {
            new Thread(null, carShow::sellCar, "Покупатель 1").start();
            new Thread(null, carShow::sellCar, "Покупатель 2").start();
            new Thread(null, carShow::sellCar, "Покупатель 3").start();
            new Thread(null, carShow::acceptCar, "Производитель Mazda").start();
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class CarShow {

    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();

    public Car sellCar() {
        return seller.sellCar();
    }

    public void acceptCar() {
        seller.initBuild();
    }

    public List<Car> getCars() {
        return cars;
    }
}

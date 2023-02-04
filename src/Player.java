import java.util.ArrayList;

public class Player extends ClientsBase{
    int clientsSoldCar = 0;

    public int Cash = 500000;
    int wash = 10;


    public void buyCar(Car car){
    car.value += (car.value* 0.02) - wash;  // zakup z 2% podatkiem i myjką
    System.out.println("Zakupiono auto " + car.brand + " za " + car.value);
    ownedCars.add(car);
    Cash -= car.value;
    }
    public void sellCar(Car car){
        car.value -= (car.value* 0.02) - wash;  // sprzedaz z 2% podatkiem i myjką
        System.out.println("Sprzedano auto " + car.brand + " za " + car.value);
        Cash += car.value;
        clientsSoldCar++;
    }
    ArrayList<Car> ownedCars = new ArrayList<>();
}

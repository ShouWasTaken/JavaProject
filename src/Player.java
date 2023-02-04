import java.util.ArrayList;

public class Player extends ClientsBase{


    public int StartingCash = 500000;
    public int Cash = 0;
    int wash = 10;


    public void buyCar(Car car){
    car.value += (car.value* 0.02) - wash;  // zakup z 2% podatkiem i myjką
    System.out.println("Zakupiono auto " + car.brand + " za " + car.value);
    sumWash.add(wash);
    ownedCars.add(car);
    Cash = StartingCash - car.value;
    }
    public void sellCar(Car car){
        car.value -= (car.value* 0.02) - wash;  // sprzedaz z 2% podatkiem i myjką
        System.out.println("Sprzedano auto " + car.brand + " za " + car.value);
        Cash = StartingCash + car.value;
        ownedCars.remove(car);
    }


    ArrayList<Car> ownedCars = new ArrayList<>();
    ArrayList<String> transactions = new ArrayList<>();
    ArrayList<Integer> sumWash = new ArrayList<>();
    ArrayList<Integer> sumRepair = new ArrayList<>();
}

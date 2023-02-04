import java.util.ArrayList;
import java.util.Random;

public class CarBase {

    Random rng = new Random();
    ArrayList<Car> carsBase = new ArrayList<>();


    public void renewCarBase(){
        this.carsBase.clear();
        int amountOfCars = rng.nextInt(6)+4;
        for (int i = 0; i < amountOfCars; i++) {
            Car tmpCar = new Car();
            this.carsBase.add(tmpCar.GenerateCar());
        }
    }

    public void CarBaseToString(){
        for (int i = 0; i < carsBase.size(); i++) {
            System.out.println();
            System.out.println("Pojazd nr " + (i + 1));
            carsBase.get(i).carToString(carsBase.get(i));
        }
    }
    public void CarBaseToString(ArrayList<Car> AL){
        for (int i = 0; i < AL.size(); i++) {
            System.out.println();
            System.out.println("Pojazd nr " + (i + 1));
            AL.get(i).carToString(AL.get(i));
        }
    }
}

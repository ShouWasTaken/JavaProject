import java.util.ArrayList;
import java.util.Random;

public class Car extends Part {


    public ArrayList<Part> getPartsSet() {
        return partsSet;
    }



    int value;
    String[] brandsList = {"Audi", "Volkswagen", "Fiat", "Polonez"};
    String brand;
    int mileage;
    String[] colorList = {"Czerwony", "Niebieski", "Biały", "Zielony", "Czarny"};
    String color;
    String[] typeList = {"Premium", "Standard", "Budget"};
    String type;
    boolean isCargo;
    ArrayList<Part> partsSet = new ArrayList<>();
    ArrayList<String> repairs = new ArrayList<>();



    public Car(int value, String brand, int mileage, String color, String type, boolean isCargo, ArrayList<Part> partsSet){
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.type = type;
        this.isCargo = isCargo;
        this.partsSet = partsSet;
    }

    public Car() {

    }

    public Car GenerateCar(){
        Random rng = new Random();
        int tmpValue = rng.nextInt(50000)+2000;
        int tmpMileage = rng.nextInt(650000);
        String tmpBrand = brandsList[rng.nextInt(brandsList.length)];
        String tmpColor = colorList[rng.nextInt(colorList.length)];

        String tmpType = typeList[rng.nextInt(typeList.length)];
        boolean tmpIsCargo = rng.nextBoolean();
        Part p1 = new Part();
        ArrayList<Part> tmpPartsSet = p1.generateParts();

        return new Car(tmpValue, tmpBrand, tmpMileage, tmpColor, tmpType, tmpIsCargo, tmpPartsSet);
    }


    public void carToString(Car car){
        System.out.println("Wartość pojazdu: " + car.value);
        System.out.println("Przebieg pojazdu: " + car.mileage);
        System.out.println("Marka pojazdu: " + car.brand);
        System.out.println("Kolor pojazdu: " + car.color);
        System.out.println("Typ pojazdu: " + car.type);
        if(car.isCargo)
            System.out.println("Czy pojazd jest dostawczy: Tak");
        else
            System.out.println("Czy pojazd jest dostawczy: Nie");
        System.out.println("Stan części pojazdu:");
        PartsSetToString(car.partsSet);

    }



}
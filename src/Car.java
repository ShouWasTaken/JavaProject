import java.util.ArrayList;
import java.util.Random;

public class Car extends Part {
    Random rng = new Random();
    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCargo() {
        return isCargo;
    }

    public void setCargo(boolean cargo) {
        isCargo = cargo;
    }

    public ArrayList<Part> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(ArrayList<Part> partsSet) {
        this.partsSet = partsSet;
    }


    int value;
    String[] brandsList = {"Audi", "Volkswagen", "Fiat", "Polonez"};
    String brand;
    int mileage;
    String[] colorList = {"Czerwony", "Niebieski", "Biały", "Zielony", "Policyjny"};
    String color;
    String[] typeList = {"Premium", "Standard", "Budget"};
    String type;
    boolean isCargo;
    ArrayList<Part> partsSet = new ArrayList<>();


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
        int tmpValue = rng.nextInt(98000)+2000;
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
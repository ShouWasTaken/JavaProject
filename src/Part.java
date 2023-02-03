import java.util.ArrayList;
import java.util.Random;

public class Part extends Player {
    Random rng = new Random();
    String[] partNameList = {"Hamulec", "Zawieszenie", "Silnik","Karoseria","Skrzynia biegów"};
    String partName;
    ArrayList<Part> partsSet = new ArrayList<>();
    int durability;
     boolean working;

    public Part(String partName, boolean working) {
        this.partName = partName;
       this.working = working;
    }

    public Part(){

    }
    public  ArrayList<Part> generateParts(){

        for(int i = 0; i<partNameList.length; i++){

            durability = rng.nextInt(100);

            if(durability<50)
                working = false;
            else
                working = true;

            Part tmpPart = new Part(partNameList[i],working);
            partsSet.add(tmpPart);

        }
        return partsSet;
    }

    public void PartsSetToString(ArrayList<Part> partsSet){
        for (Part part : partsSet) {
            if(part.working)
                System.out.println("  Część " + part.partName + " jest sprawna");
            else
                System.out.println("  Część " + part.partName + " NIE jest sprawna");
        }
    }
    public void RepairSpecificPart(Part part) {
        part.working = true;
    }
    public void RepairPart(Player player, Car car, String partName){
        switch(partName){
            case "Hamulec" :
               RepairSpecificPart(car.getPartsSet().get(0));
               player.Cash = player.Cash-2500;
               car.value += car.value*0.1;
                break;
            case "Zawieszenie" :
                RepairSpecificPart(car.getPartsSet().get(1));
                player.Cash = player.Cash-6000;
                car.value += car.value*0.2;
                break;
            case "Silnik" :
                RepairSpecificPart(car.getPartsSet().get(2));
                player.Cash = player.Cash-10000;
                car.value += car.value;
                break;
            case "Karoseria" :
                RepairSpecificPart(car.getPartsSet().get(3));
                player.Cash = player.Cash-7500;
                car.value += car.value*0.5;
                break;
            case "Skrzynia biegów" :
                RepairSpecificPart(car.getPartsSet().get(4));
                player.Cash = player.Cash-4500;
                car.value += car.value*0.5;
                break;
            default:
                System.out.println("Naprawa nieudana - nie ma takiej części");
        }

    }
}

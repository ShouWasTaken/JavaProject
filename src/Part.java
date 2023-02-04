import java.util.ArrayList;
import java.util.Random;

public class Part extends Mechanic {
    Random rng = new Random();
    String[] partNameList = {"Hamulec", "Zawieszenie", "Silnik","Karoseria","Skrzynia biegów"};
    String partName;
    public ArrayList<Part> partsSet = new ArrayList<>();
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

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Clients extends Car{

    int Cash;
    String[] preferredBrands;
    boolean buysBroken;
    boolean cargo;

    public Clients(int Cash, String[] preferredBrands, boolean buysBroken, boolean cargo){
    this.Cash = Cash;
    this.preferredBrands = preferredBrands;
    this.buysBroken = buysBroken;
    this.cargo = cargo;
    }


    public Clients(){

    }

    public Clients GenerateClient(){
        ArrayList<String> brand = new ArrayList<>(Arrays.asList(brandsList));
        Random rng = new Random();
        int tmpCash = rng.nextInt(650000)+200000;
        String[] tmpPreferredBrands = new String[2];
        for(int i = 0; i< 2; i++){
           int brandIndex = rng.nextInt(brand.size());
          tmpPreferredBrands[i] = brand.get(brandIndex);
           brand.remove(brandIndex);
        }
        boolean tmpBuysBroken = rng.nextBoolean();
        boolean tmpCargo = rng.nextBoolean();
        return new Clients(tmpCash, tmpPreferredBrands, tmpBuysBroken, tmpCargo);
    }
    public void clientToString(Clients clients){
       System.out.println("Budzet klienta: " + clients.Cash);
        System.out.println("Preferowane marki klienta: " + Arrays.toString(clients.preferredBrands));
        if(clients.buysBroken)
            System.out.println("Klient kupuje uszkodzone auta");
        else
            System.out.println("Klient kupuje jedynie sprawne auta");
        if(clients.cargo)
            System.out.println("Klient jest zaintersowany autami typu Cargo");
        else
            System.out.println("Klient jest zaintersowany autami osobowymi");
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Clients extends Car{
    int Cash;
    String[] preferredBrands;
    boolean buysBroken;


    public Clients(int Cash, String[] preferredBrands, boolean buysBroken){
    this.Cash = Cash;
    this.preferredBrands = preferredBrands;
    this.buysBroken = buysBroken;
    }


    public Clients(){

    }

    public Clients GenerateClient(){
        ArrayList<String> brand = new ArrayList<>(Arrays.asList(brandsList));
        Random rng = new Random();
        int tmpCash = rng.nextInt(650000);
        String[] tmpPreferredBrands = new String[2];
        for(int i = 0; i< 2; i++){
           int brandIndex = rng.nextInt(brand.size());
          tmpPreferredBrands[i] = brand.get(brandIndex);
           brand.remove(brandIndex);
        }
        boolean tmpBuysBroken = rng.nextBoolean();
        return new Clients(tmpCash, tmpPreferredBrands, tmpBuysBroken);
    }
    public void clientToString(Clients clients){
       System.out.println("Budzet klienta: " + clients.Cash);
        System.out.println("Preferowane marki klienta: " + Arrays.toString(clients.preferredBrands));
        if(clients.buysBroken)
            System.out.println("Klient kupuje uszkodzone auta");
        else
            System.out.println("Klient kupuje jedynie sprawne auta");

    }

}

import java.util.ArrayList;
import java.util.Random;

public class ClientsBase{
    Random rng = new Random();
    public  ArrayList<Clients> clientsBase = new ArrayList<>();



    public void renewClientsBase(){
        this.clientsBase.clear();
        int amountOfClients = rng.nextInt(6)+4;
        for (int i = 0; i < amountOfClients; i++) {
            Clients tmpClient = new Clients();
            this.clientsBase.add(tmpClient.GenerateClient());
        }
    }
    public void ClientBaseToString(){
        for (int i = 0; i < clientsBase.size(); i++) {
            System.out.println();
            System.out.println("Klient nr " + (i + 1));
            clientsBase.get(i).carToString(clientsBase.get(i));
        }
    }

}

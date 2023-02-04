import java.util.ArrayList;
import java.util.Random;

public class ClientsBase extends Clients {
    Random rng = new Random();

    public ArrayList<Clients> clientsBase = new ArrayList<>();




        public void CreateClientsBase () {
            int amountOfClients = rng.nextInt(6) + 4;
            for (int i = 0; i < amountOfClients; i++) {
                Clients tmpClient = new Clients();
                this.clientsBase.add(tmpClient.GenerateClient());
            }
        }
            public void AddClientsToBase (int amountOfNewClients){
                for (int i = 0; i < amountOfNewClients; i++) {
                    Clients tmpClient = new Clients();
                    this.clientsBase.add(tmpClient.GenerateClient());
                }
        }
        public void ClientBaseToString () {
            for (int i = 0; i < clientsBase.size(); i++) {
                System.out.println();
                System.out.println("Klient nr " + (i + 1));
                clientsBase.get(i).clientToString(clientsBase.get(i));
            }
        }

    }

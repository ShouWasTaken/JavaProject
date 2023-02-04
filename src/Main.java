public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        Part tmpPart = new Part();
        Clients tmpClient = new Clients();
        tmpClient = tmpClient.GenerateClient();
        tmpClient.clientToString(tmpClient);

    }
}
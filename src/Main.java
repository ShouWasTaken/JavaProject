import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        CarBase carBase = new CarBase();
        ClientsBase clientsBase = new ClientsBase();
        carBase.renewCarBase();
        clientsBase.renewClientsBase();
        Part part = new Part();
        do {
            System.out.println("----------------------------------------------");
            System.out.println("1.Przegladaj liste aut do kupienia");
            System.out.println("2.Kup auto");
            System.out.println("3.Przegladaj posiadane auta");
            System.out.println("4.Napraw auto");
            System.out.println("5.Przejrzyj liste klientow");
            System.out.println("6.Sprzedaj auto");
            System.out.println("7.Kup reklame");
            System.out.println("8.Sprawdz stan konta");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            try{
                switch (userInput) {
                    case 1:
                        carBase.CarBaseToString();
                        break;

                    case 2:
                        System.out.println("Ktory pojazd chcesz kupic");
                        try{
                            int carToBuy = scanner.nextInt() - 1;
                            player.buyCar(carBase.carsBase.get(carToBuy));

                        }catch (Exception e){
                            System.out.println("Taki pojazd nie jest dostepny");
                        }
                        break;
                    case 3 :
                        if(!player.ownedCars.isEmpty())
                        carBase.CarBaseToString(player.ownedCars);
                        else
                            System.out.println("Nie posiadasz zadnych aut");
                        break;
                    case 4 :
                        System.out.println("Ktory pojazd chcesz naprawic");
                        try{



                        }catch (Exception e){
                            System.out.println("Nie posiadasz takiego pojazdu");
                        }

                }



            }
            catch(Exception e){
                System.out.println("Nie ma takiej opcji");
            }
        }while(true);

    }
}
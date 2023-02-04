import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        CarBase carBase = new CarBase();
        ClientsBase clientsBase = new ClientsBase();
        carBase.renewCarBase();
        clientsBase.CreateClientsBase();
        Random rng = new Random();
        int moves = 0;

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
            System.out.println("9.Wyświetl historię tansakcji");
            System.out.println("10.Wyświetl historię napraw pojazdu");
            System.out.println("11.Podsumuj wydatki");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            try {
                switch (userInput) {
                    case 1:
                        carBase.CarBaseToString();
                        break;

                    case 2:
                        System.out.println("Ktory pojazd chcesz kupic");
                        try {
                            int carToBuy = scanner.nextInt() - 1;
                            player.buyCar(carBase.carsBase.get(carToBuy));
                            player.transactions.add("Zakupiono auto " + carBase.carsBase.get(carToBuy).brand + " o wartosci " + carBase.carsBase.get(carToBuy).value);
                            moves++;
                            carBase.renewCarBase();

                        } catch (Exception e) {
                            System.out.println("Taki pojazd nie jest dostepny");
                        }
                        break;
                    case 3:
                        if (!player.ownedCars.isEmpty())
                            carBase.CarBaseToString(player.ownedCars);
                        else
                            System.out.println("Nie posiadasz zadnych aut");
                        break;
                    case 4:
                        System.out.println("Ktory pojazd chcesz naprawic");
                        try {
                            int carToRepair = scanner.nextInt() - 1;
                            player.ownedCars.get(carToRepair);
                            System.out.println("Jaką część chcesz naprawić");
                            String partToRepair = scanner.next();
                            Part part = new Part();
                            if (part.working == false) {
                                System.out.println("Wybierz mechanika do naprawy:");
                                System.out.println("1.Janusz");
                                System.out.println("2.Marian");
                                System.out.println("3.Adrian");

                                try {
                                    int choosingMechanic = scanner.nextInt();
                                    if (choosingMechanic == 1) {
                                        part.RepairPartJanusz(player, player.ownedCars.get(carToRepair), partToRepair);
                                        player.ownedCars.get(carToRepair).repairs.add(partToRepair);
                                        player.transactions.add("Naprawiono " + partToRepair + " w aucie " + player.ownedCars.get(carToRepair).brand + " za " + player.Cash);
                                        player.sumRepair.add(player.Cash);
                                        moves++;
                                    } else if (choosingMechanic == 2) {
                                        part.RepairPartMarian(player, player.ownedCars.get(carToRepair), partToRepair);
                                        player.ownedCars.get(carToRepair).repairs.add(partToRepair);
                                        player.transactions.add("Naprawiono " + partToRepair + " w aucie " + player.ownedCars.get(carToRepair).brand + " za " + player.Cash);
                                        player.sumRepair.add(player.Cash);
                                        moves++;
                                    } else {
                                        part.RepairPartAdrian(player, player.ownedCars.get(carToRepair), partToRepair);
                                        player.ownedCars.get(carToRepair).repairs.add(partToRepair);
                                        player.transactions.add("Naprawiono " + partToRepair + " w aucie " + player.ownedCars.get(carToRepair).brand + " za " + player.Cash);
                                        player.sumRepair.add(player.Cash);
                                        moves++;
                                    }

                                } catch (Exception e) {
                                    System.out.println("Nie ma takiego mechanika");
                                }
                            } else {
                                System.out.println("Ta część nie jest uszkodzona");
                            }


                        } catch (Exception e) {
                            System.out.println("Nie posiadasz takiego pojazdu");
                        }
                        break;
                    case 5:
                        clientsBase.ClientBaseToString();
                        break;
                    case 6:
                        System.out.println("Ktory pojazd chcesz sprzedac");
                        try {
                            int carToSell = scanner.nextInt() - 1;
                            ArrayList<Clients> potentialClients = new ArrayList<>();
                            for (Clients client :
                                    clientsBase.clientsBase) {
                                if (player.ownedCars.get(carToSell).brand == client.preferredBrands[0] || player.ownedCars.get(carToSell).brand == client.preferredBrands[1]) {
                                    if (player.ownedCars.get(carToSell).isCargo == client.cargo)
                                        if (player.ownedCars.get(carToSell).value <= client.Cash)
                                            if (client.buysBroken) {
                                                potentialClients.add(client);
                                            } else {
                                                int workingParts = 0;
                                                for (Part part :
                                                        player.ownedCars.get(carToSell).getPartsSet()) {
                                                    if (part.working)
                                                        workingParts++;
                                                }
                                                if (workingParts == 5)
                                                    potentialClients.add(client);
                                            }
                                }
                            }
                            if (potentialClients.isEmpty()) {
                                System.out.println("Nie ma klientow na to auto");
                                break;
                            } else {
                                System.out.println("Lista potencjalnych klientow");
                                for (Clients client :
                                        potentialClients) {
                                    System.out.println("Nr klienta " + potentialClients.indexOf(client));
                                    client.clientToString(client);
                                }
                                System.out.println("Wybierz klienta ktoremu chcesz sprzedać auto");
                                try {
                                    int buyer = scanner.nextInt();
                                    if (buyer <= potentialClients.size()) {
                                        player.sellCar(player.ownedCars.get(carToSell));
                                        player.transactions.add("Sprzedano auto " + carBase.carsBase.get(carToSell).brand + " o wartosci " + carBase.carsBase.get(carToSell).value);
                                        clientsBase.clientsBase.remove(potentialClients.get(buyer));
                                        moves++;
                                        clientsBase.AddClientsToBase(2);
                                    }
                                } catch (Exception e) {
                                    System.out.println("Nie ma takiego klienta");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Taki pojazd nie jest dostepny");
                        }
                        break;
                    case 7:
                        System.out.println("Jaki typ reklamy chcesz wykupić");
                        System.out.println("1.W lokalnej gazecie");
                        System.out.println("2.W internecie");
                        try {
                            int advertismentType = scanner.nextInt();
                            if (advertismentType == 1) {
                                int numberOfClients = rng.nextInt(4) + 1;
                                clientsBase.AddClientsToBase(numberOfClients);
                                System.out.println("Po zakupie reklamy w gaziecie doszło " + numberOfClients + " klientów");
                                player.Cash = player.StartingCash - 7500;
                                moves++;
                                player.transactions.add("Zakupiono reklamę za kwotę 7500");
                            } else {
                                clientsBase.AddClientsToBase(1);
                                System.out.println("Po zakupieniu reklamy internetowej doszedł jeden dodatkowy klient");
                                player.Cash = player.StartingCash - 2000;
                                moves++;
                                player.transactions.add("Zakupiono reklamę za kwotę 2000");
                            }
                        } catch (Exception e) {
                            System.out.println("Nie ma takiej reklamy");
                        }
                        break;
                    case 8:
                        System.out.println("Stan konta wynosi " + player.Cash);
                        break;
                    case 9:
                        if (!player.transactions.isEmpty())
                            for (String transaction :
                                    player.transactions) {
                                System.out.println(transaction);
                            }
                        else
                            System.out.println("Nie dokonałeś jeszcze żadnej transakcji");
                        break;
                    case 10:
                        if (!player.ownedCars.isEmpty()) {
                            System.out.println("Naprawy którego auta chcesz sprawdzić: ");
                            try {
                                int carToCheck = scanner.nextInt() - 1;
                                for (String repair :
                                        player.ownedCars.get(carToCheck).repairs) {
                                    if (!player.ownedCars.get(carToCheck).repairs.isEmpty()) {
                                        System.out.println("W aucie " + player.ownedCars.get(carToCheck).brand + " dokonano napraw:");
                                        System.out.println(repair);
                                    } else
                                        System.out.println("W tym aucie nie wykonano napraw");
                                }


                            } catch (Exception e) {
                                System.out.println("Nie ma takiego auta");
                            }
                        } else {
                            System.out.println("Nie posiadasz zadnych aut");
                        }
                        break;
                    case 11:
                        if (!player.transactions.isEmpty()) {
                            int sum = 0;
                            for (Integer i :
                                    player.sumRepair) {
                                sum += i;
                            }
                            for (Integer i :
                                    player.sumWash) {
                                sum += i;
                            }
                            System.out.println(sum);
                        } else {
                            System.out.println("Nie wykonałeś zadnych transakcji aut");
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nie ma takiej opcji");
            }


        } while (player.Cash < player.StartingCash * 2);{
            if (player.Cash >= 2 * player.StartingCash) {
                System.out.println("Gratulacje, wygrales grę");
            }

        }
    }

}





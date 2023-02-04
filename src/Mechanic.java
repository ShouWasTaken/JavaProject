import java.util.Random;

public class Mechanic {
    Random rng = new Random();

    public void RepairSpecificPart(Part part) {
        if(part.working == false)
        part.working = true;
    }

    public void BreakSpecificPart(Part part) {
        part.working = false;
    }

    public void RepairPart(Player player, Car car, String partName) {
        switch (partName) {
            case "Hamulec":
                RepairSpecificPart(car.getPartsSet().get(0));
                player.Cash = player.StartingCash - 2500;
                car.value += car.value * 0.1;
                break;
            case "Zawieszenie":
                RepairSpecificPart(car.getPartsSet().get(1));
                player.Cash -= 6000;
                car.value += car.value * 0.2;
                break;
            case "Silnik":
                RepairSpecificPart(car.getPartsSet().get(2));
                player.Cash = player.StartingCash - 10000;
                car.value += car.value;
                break;
            case "Karoseria":
                RepairSpecificPart(car.getPartsSet().get(3));
                player.Cash = player.StartingCash -  7500;
                car.value += car.value * 0.5;
                break;
            case "Skrzynia biegów":
                RepairSpecificPart(car.getPartsSet().get(4));
                player.Cash = player.StartingCash -  4500;
                car.value += car.value * 0.5;
                break;
            default:
                System.out.println("Naprawa nieudana - nie ma takiej części");
        }

    }

    public void RepairPartJanusz(Player player, Car car, String partName) {
        RepairPart(player, car, partName);
        player.Cash = (int) (player.StartingCash - (player.StartingCash * 0.5));
    }

    public void RepairPartMarian(Player player, Car car, String partName) {
        int random = rng.nextInt(10) + 1;
        if (random == 10) {
            System.out.println("Nie udało się naprawić samochodu, wzywam Janusza");
            RepairPartJanusz(player, car, partName);
        } else {
            RepairPart(player, car, partName);
            player.Cash = (int) (player.StartingCash - (player.StartingCash * 0.3));
        }
    }

    public void RepairPartAdrian(Player player, Car car, String partName) {
        int random = rng.nextInt(100);
        if (random <= 20) {
            System.out.println("Nie udało się naprawić samochodu");
        } else if (random <= 22) {
           random = rng.nextInt(5);
           if (car.getPartsSet().get(random).working == true){
           BreakSpecificPart(car.getPartsSet().get(random));
           System.out.println("Adrian zepsul " + car.getPartsSet().get(random).partName);}
        }
             else {
                RepairPart(player, car, partName);
                player.Cash = (int) (player.StartingCash - (player.StartingCash * 0.1));
            }
            }
        }



import java.util.Random;

public class Mechanic {
    Random rng = new Random();
    public int repairCost = 0;

    public void RepairSpecificPart(Part part) {
        if(part.working == false)
        part.working = true;
    }

    public void BreakSpecificPart(Part part) {
        part.working = false;
    }

    public void RepairPart(Player player, Car car, String partName, int multiplier) {
        switch (partName) {
            case "Hamulec":
                RepairSpecificPart(car.getPartsSet().get(0));
                repairCost = 2500 * multiplier;
                player.Cash = player.Cash - repairCost;
                car.value += car.value * 0.1;
                break;
            case "Zawieszenie":
                RepairSpecificPart(car.getPartsSet().get(1));
                repairCost = 6000 * multiplier;
                player.Cash = player.Cash - repairCost;
                car.value += car.value * 0.2;
                break;
            case "Silnik":
                RepairSpecificPart(car.getPartsSet().get(2));
                repairCost = 10000 * multiplier;
                player.Cash = player.Cash - repairCost;
                car.value += car.value;
                break;
            case "Karoseria":
                RepairSpecificPart(car.getPartsSet().get(3));
                repairCost = 7500 * multiplier;
                player.Cash = player.Cash - repairCost;
                car.value += car.value * 0.5;
                break;
            case "Skrzynia biegów":
                RepairSpecificPart(car.getPartsSet().get(4));
                repairCost = 4500 * multiplier;
                player.Cash = player.Cash - repairCost;
                car.value += car.value * 0.5;
                break;
            default:
                System.out.println("Naprawa nieudana - nie ma takiej części");
        }

    }

    public void RepairPartJanusz(Player player, Car car, String partName) {
        int multiplier = 3;
        RepairPart(player, car, partName, multiplier);
    }

    public void RepairPartMarian(Player player, Car car, String partName) {
        int multiplier = 2;
        int random = rng.nextInt(10) + 1;
        if (random == 10) {
            System.out.println("Nie udało się naprawić samochodu, wzywam Janusza");
            RepairPartJanusz(player, car, partName);
        } else {
            RepairPart(player, car, partName, multiplier);
        }
    }

    public void RepairPartAdrian(Player player, Car car, String partName) {
        int multiplier = 1;
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
                RepairPart(player, car, partName, multiplier);
            }
            }
        }



public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        Part tmpPart = new Part();

        Car testCar = new Car();
        testCar = testCar.GenerateCar();
        testCar.carToString(testCar);

        tmpPart.RepairPart(player, testCar,"Hamulec");
        tmpPart.RepairPart(player, testCar,"Zawieszenie");
        tmpPart.RepairPart(player, testCar,"Silnik");
        tmpPart.RepairPart(player, testCar,"Karoseria");
        tmpPart.RepairPart(player, testCar,"Skrzynia biegów");
        testCar.carToString(testCar);
    }
}
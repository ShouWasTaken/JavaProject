public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        Part tmpPart = new Part();

        Car testCar = new Car();
        testCar = testCar.GenerateCar();
        testCar.carToString(testCar);

        tmpPart.RepairPartAdrian(player, testCar,"Hamulec");
        testCar.carToString(testCar);
        System.out.println(player.Cash);
    }
}
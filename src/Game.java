import cars.Car;
import cars.PlayerCar;

public class Game {
    private Car cars;
    private int manufactoredCars = 1;
    private PlayerCar playerCar;

    public Game(PlayerCar playerCar){
        this.playerCar = playerCar;
    }

    public void init() {

        cars = new Car(220);

            if (cars.getCounter()>= 62 && cars.getCol() == playerCar.getCol()) {
                cars.crash();
                System.out.println("Crashou");
            }

        }
    }


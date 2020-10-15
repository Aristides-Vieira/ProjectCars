import cars.Car;
import cars.PlayerCar;

import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;


public class Game {


    private int totalCars = 50;
    private PlayerCar playerCar;
    private int timer = 0;


    public Game(PlayerCar playerCar) {
        this.playerCar = playerCar;
    }

    public void init() {

       LinkedList<Car> carLinkedList = new LinkedList<>();


        for (int i = 0; i < totalCars; i++) {
            if (timer % 99 == 0) {
                carLinkedList.add(new Car());
            }
        }
        ListIterator<Car> carIterator = carLinkedList.listIterator();
        System.out.println(carLinkedList.size());

        /*Car firstCar = new Car();
        firstCar.fillCar();
        firstCar.setColor();
        firstCar.move();
        */
        //System.out.println("enemy car init col: " + playerCar.getCol());

        while (!playerCar.isCrashed()) {

            try {
                for (Car car : carLinkedList) {

                    car.move();
                    car.delete();
                    car.fillCar();


                   if (car.getCounter() >= 62 && car.getCol() == playerCar.getCol()) {

                       playerCar.crash();
                        System.out.println("Game Over");
                    }
                }
                Thread.sleep(200);
                timer++;



            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }
}


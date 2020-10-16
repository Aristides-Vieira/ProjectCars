import cars.Car;
import cars.PlayerCar;
import java.util.LinkedList;
import java.util.ListIterator;


public class Game {


    private int totalCars = 2;
    private PlayerCar playerCar;
    private int timer = 0;


    public Game(PlayerCar playerCar) {
        this.playerCar = playerCar;
    }

    public void init() {

        LinkedList<Car> carLinkedList = new LinkedList<>();



        carLinkedList.add(new Car());

        ListIterator<Car> carIterator = carLinkedList.listIterator();
        System.out.println(carLinkedList.size());


        while (!playerCar.isCrashed()) {

            try {

                    if (timer % 11 == 0) {
                        carLinkedList.add(new Car());
                    }



                for (int i = 0; i < carLinkedList.size(); i++) {

                    carLinkedList.get(i).fillCar();
                    carLinkedList.get(i).move();
                    carLinkedList.get(i).delete();
                    if (carLinkedList.get(i).getCounter() >70) {
                        carLinkedList.remove(i);
                        System.out.println(carLinkedList.size());
                    }
                }


                for (int i = 0; i < carLinkedList.size(); i++) {


                    if (carLinkedList.get(i).getCounter() >= 62 && carLinkedList.get(i).getCol() == playerCar.getCol()){
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


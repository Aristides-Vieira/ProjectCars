import cars.Car;
import cars.PlayerCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.plaf.TableHeaderUI;


public class Game {

    private PlayerCar playerCar;
    private int timer;
    private int score;
    private int level;
    private Rectangle gameOverScreen;


    public Game(PlayerCar playerCar) {
        this.playerCar = playerCar;
        score = 0;
        timer = 0;
        level = 0;
    }

    public void playGame() {


        List<Car> parkedCars = new ArrayList<Car>();
        List<Car> runningCars = new ArrayList<Car>();


        while (!playerCar.isCrashed()) {
            try {

                if (timer % 11 == 0) {
                    if (parkedCars.size() > 2) {
                        runningCars.add(parkedCars.remove(0));
                    } else {
                        parkedCars.add(new Car());
                        runningCars.add(parkedCars.remove(0));
                    }

                }
                int carToPark = -1;

                for (int i = 0; i < runningCars.size(); i++) {

                    runningCars.get(i).fillCar();
                    runningCars.get(i).move();
                    runningCars.get(i).delete();


                    if (runningCars.get(i).getCounter() == 71) {
                        score += 10;
                        level++;
                        runningCars.get(i).setCounter(0);
                        System.out.println(i);

                        carToPark = i;
                    }
                }

                if (carToPark > -1) {
                    parkedCars.add(runningCars.remove(carToPark));
                }


                for (int i = 0; i < runningCars.size(); i++) {
                    if (runningCars.get(i).getCounter() > 62 && runningCars.get(i).getCounter() <= 71 && runningCars.get(i).getCol() == playerCar.getCol()) {
                        playerCar.crash();
                        System.out.println("Game Over");
                    }
                }


                if (score < 250) {
                    Thread.sleep(200 - (level * 2));
                    level = 0;
                    timer++;
                } else if (score >= 250 && score < 500) {
                    Thread.sleep(150 - (level * 2));
                    level = 0;
                    timer++;
                } else if (score >= 500 && score < 1000) {
                    Thread.sleep(100 - level);
                    level = 0;
                    timer++;
                } else if (score >= 1000 && score < 1500) {
                    Thread.sleep(50 - (level / 2));
                    level = 0;
                    timer++;
                } else if (score >= 1500 && score < 3000) {
                    Thread.sleep(25 - (level / 10));
                    level = 0;
                    timer++;
                } else {
                    Thread.sleep(10);
                    timer++;
                }


            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        gameOver();
    }


    public void gameOver() {

        gameOverScreen = new Rectangle(10, 10, 400, 400);
        gameOverScreen.fill();
        gameOverScreen.setColor(Color.BLACK);

    }

    public void deleteGameOverScreen() {
        gameOverScreen.delete();
    }


}




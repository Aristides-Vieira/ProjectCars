import cars.Car;
import cars.PlayerCar;
import cars.RandomGenerator;
import org.academiadecodigo.simplegraphics.graphics.Text;
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
    private Text scoreDisplay;


    public Game(PlayerCar playerCar) {
        this.playerCar = playerCar;
        score = 0;
        timer = 0;
        level = 0;

        scoreDisplay = new Text(740,50, Integer.toString(score));
        scoreDisplay.grow(15,15);
        scoreDisplay.draw();
        scoreDisplay.setColor(Color.BLACK);

    }

    public void playGame() {

        List<Car> parkedCars = new ArrayList<Car>();
        List<Car> runningCars = new ArrayList<Car>();


        for (int i = 0; i < 25 ; i++) {
            parkedCars.add(new Car(RandomGenerator.pickCol()));
            System.out.println("created new car");

        }



        while (!playerCar.isCrashed()) {
            try {

                 if (timer % 11 == 0) {

                    if (parkedCars.size() > 2) {
                        runningCars.add(parkedCars.remove(0));
                    } else {
                        parkedCars.add(new Car(RandomGenerator.pickCol()));
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
                        scoreDisplay.setText(Integer.toString(score));
                        level++;
                        runningCars.get(i).setCounter(0);
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


                if (score < 100) {
                    Thread.sleep(100 - (level));
                    level = 0;
                    timer++;
                } else if (score >= 100 && score < 300) {
                    Thread.sleep( 75 - (level));
                    level = 0;
                    timer++;
                } else if (score >= 300 && score < 500) {
                    Thread.sleep(50 - level);
                    level = 0;
                    timer++;
                } else if (score >= 500 && score < 750) {
                    Thread.sleep(35 - (level / 2));
                    level = 0;
                    timer++;
                } else if (score >= 750 && score < 1250) {
                    Thread.sleep(20 - (level / 10));
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




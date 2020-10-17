import cars.Car;
import cars.PlayerCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.util.LinkedList;
import java.util.ListIterator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.plaf.TableHeaderUI;


public class Game {

    private int totalCars = 2;
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

        public void playGame () {


            LinkedList<Car> carLinkedList = new LinkedList<>();

            ListIterator<Car> carIterator = carLinkedList.listIterator();


            while (!playerCar.isCrashed()) {
                try {

                    if (timer % 11 == 0) {
                        carLinkedList.add(new Car());
                    }

                    for (int i = 0; i < carLinkedList.size(); i++) {

                        carLinkedList.get(i).fillCar();
                        carLinkedList.get(i).move();
                        carLinkedList.get(i).delete();


                        if (carLinkedList.get(i).getCounter() == 70) {
                            score += 10;
                            level++;
                            System.out.println(score);
                            carLinkedList.remove(i);
                        }
                    }

                    for (int i = 0; i < carLinkedList.size(); i++) {
                        if (carLinkedList.get(i).getCounter() > 62 && carLinkedList.get(i).getCounter() < 71 && carLinkedList.get(i).getCol() == playerCar.getCol()) {

                            playerCar.crash();
                            System.out.println("Game Over");
                        }
                    }


                    if (score < 250) {
                        Thread.sleep(200 - (level*2));
                        level = 0;
                        timer++;
                    } else if (score >= 250 && score < 500) {
                        Thread.sleep(150- (level*2));
                        level=0;
                        timer++;
                    } else if (score >= 500 && score < 1000) {
                        Thread.sleep(100 -level);
                        level=0;
                        timer++;
                    } else if (score >= 1000 && score < 1500) {
                        Thread.sleep(50 - (level / 2));
                        level = 0;
                        timer++;
                    }else if(score >= 1500 && score < 3000) {
                        Thread.sleep(25 - (level/10));
                        level=0;
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



import cars.Car;
import cars.PlayerCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import simpleGfx.SimpleGfxGrid;

import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Game {


    private int totalCars = 2;
    private PlayerCar playerCar;
    private int timer;
    private int score;
    private Rectangle gameOverScreen;
    private Keyboard keyboard;


    public Game(PlayerCar playerCar) {
        this.playerCar = playerCar;
        score = 0;
        timer = 0;
    }

    public void playGame() {

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

                    if (carLinkedList.get(i).getCounter() > 70) {

                        carLinkedList.remove(i);
                        score += 10;
                        System.out.println(score);
                    }
                }

                for (int i = 0; i < carLinkedList.size(); i++) {
                    if (carLinkedList.get(i).getCounter() >= 62 && carLinkedList.get(i).getCol() == playerCar.getCol()) {

                        playerCar.crash();
                        System.out.println("Game Over");
                    }
                }

                Thread.sleep(100);
                timer++;

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



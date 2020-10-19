package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {

    private Picture vehicle;


    private int counter = 0;
    private int col;
    private boolean isDrawn;


    public Car() {
        this.col = pickCol();
        isDrawn = false;


    }

    public void fillCar() {

        if (!isDrawn) {
            vehicle = new Picture(col, 10, "Resources/enemyship.png");
            vehicle.draw();
            isDrawn = true;
        }
    }


    public int pickCol() {

        int random = (int) Math.round(Math.random() * 3);

        switch (random) {

            case 1:
                return 220;
            case 2:
                return 320;
            case 3:
                return 420;
            default:
                return 520;
        }
    }

    public void move() {
        vehicle.translate(0, 10);
        counter++;
    }

    public void delete() {
        if (counter >= 71) {
            vehicle.delete();
            isDrawn = false;
        }
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public int getCol() {
        return col;
    }
}
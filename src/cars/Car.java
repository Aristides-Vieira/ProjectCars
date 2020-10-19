package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {

    private Picture vehicle;
    private int counter = 0;
    private int col;
    private boolean isDrawn;


    public Car(int col) {
        this.col = col;
        isDrawn = false;


    }

    public void setVehicle(Picture vehicle) {
        this.vehicle = vehicle;
    }

    public void fillCar() {

        if (!isDrawn) {
            vehicle = new Picture(col, 10, "Resources/redcar.png");
            vehicle.draw();
            isDrawn = true;
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
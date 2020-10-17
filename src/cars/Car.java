package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Car {

    private Picture vehicle;
    private int counter = 0;
    private int col;



    public Car() {
        this.col = pickCol();
        vehicle = new Picture(col, 10, "/home/aristides/Documents/Academia-de-codigo/Projectos de grupo/ProjectCars/Resources/car4.png");
        vehicle.draw();



    }

    public void fillCar() {
        vehicle.draw();
    }


    public int pickCol() {

        int random = (int) Math.round(Math.random() * 3);

        switch (random) {

            default:
                return 220;
            case 1:
                return 320;
            case 2:
                return 420;
            case 3:
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
        }
    }

    public int getCounter() {
        return counter;
    }

    public int getCol() {
        return col;
    }
}
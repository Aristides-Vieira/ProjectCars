package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import simpleGfx.SimpleGfxGridPosition;

public class Car {

    private Rectangle vehicle;
    private int counter = 0;
    private int col;


    public Car(){
        this.col = pickCol();
        vehicle = new Rectangle(col, 10, 80, 90);
        vehicle.setColor(Color.RED);

    }
    public void fillCar() {
        vehicle.fill();
    }

    public void setColor(){
        vehicle.setColor(Color.GREEN);
    }

    public int pickCol(){

        int random = (int) Math.round(Math.random() * 3);

        switch(random){

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

    public void move(){
        vehicle.translate(0,10);
        counter++;
    }

    public void delete(){
        if(counter > 70 ){
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

package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import simpleGfx.SimpleGfxGridPosition;

public class Car {

    private Rectangle vehicle;
    private int counter = 0;


    private int col;


    private boolean crashed = false;

    public Car(int col){
        this.col = 220;
        vehicle = new Rectangle(col, 10, 80, 90);
        vehicle.fill();
        vehicle.setColor(Color.RED);

    }


    public void move(){
        vehicle.translate(0,10);
        counter++;
    }

    public void crash(){
        this.crashed = true;
    }

    public void delete(){
        if(counter > 70 ){
            vehicle.delete();
        }
    }

    public boolean isCrashed() {
        return crashed;
    }
    public int getCounter() {
        return counter;
    }

    public int getCol() {
        return col;
    }
}

import cars.Car;
import cars.PlayerCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import simpleGfx.SimpleGfxGrid;

public class Main {

    public static void main(String[] args) {

        SimpleGfxGrid grid = new SimpleGfxGrid(8);
        PlayerCar player = new PlayerCar();
        Game game = new Game(player);

        grid.init();

        player.init();

        game.init();

        Car vehicle = new Car(220);

        while (true) {
            try {
                Thread.sleep(200);
                vehicle.move();
                vehicle.delete();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
}

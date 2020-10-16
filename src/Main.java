import cars.Car;
import cars.PlayerCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import simpleGfx.SimpleGfxGrid;

public class Main {

    public static void main(String[] args) {

        SimpleGfxGrid grid = new SimpleGfxGrid(8);
        grid.init();

        PlayerCar player = new PlayerCar();
        Game game = new Game(player);

        player.init();
        System.out.println("player car col : " + player.getCol());

        game.playGame();

        if(player.getMartelo()) {
                System.out.println("space funciona");
                game.deleteGameOverScreen();
                game.playGame();
        }

    }
}

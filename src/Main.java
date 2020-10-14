import cars.PlayerCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import simpleGfx.SimpleGfxGrid;

public class Main {

    public static void main(String[] args) {

        SimpleGfxGrid grid = new SimpleGfxGrid(8);
        PlayerCar player = new PlayerCar();
 /*       Keyboard kb = new Keyboard(player);


        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(left);


        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(right);

*/
        grid.init();

        player.init();

    }

}

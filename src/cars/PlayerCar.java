package cars;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerCar extends Car implements KeyboardHandler {

    private Keyboard keyboard;
    private Rectangle player;

    public void init() {

        player = new Rectangle(220, 710, 80, 90);
        player.fill();
        keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (KeyboardEvent.KEY_LEFT == keyboardEvent.getKey()) {
            player.translate(-100, 0);
        } if (KeyboardEvent.KEY_RIGHT == keyboardEvent.getKey()) {
            player.translate(100, 0);
        }

       /* switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                player.translate(-100, 0);
            case KeyboardEvent.KEY_RIGHT:
                player.translate(100, 0);
        }*/
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

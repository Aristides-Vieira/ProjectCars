package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class PlayerCar implements KeyboardHandler {

    private Keyboard keyboard;
    private Rectangle player;


    private int col;

    public void init() {

        player = new Rectangle(220, 710, 80, 90);
        player.fill();
        player.setColor(Color.BLUE);
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
            if(player.getX() > 220){

            player.translate(-100, 0);
            col = col - 100;
            }
        } if (KeyboardEvent.KEY_RIGHT == keyboardEvent.getKey()) {
            if(player.getX() < 500){

            player.translate(100, 0);
            col = col + 100;
            }
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
    public int getCol() {
        return col;
    }
}

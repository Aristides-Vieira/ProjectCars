package cars;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerCar implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture player;
    private boolean crashed;
    private int col;
    private boolean martelo;

    public PlayerCar() {
        martelo = false;
        col = 220;
        crashed = false;
        player = new Picture (220, 710,"Resources/batman.png" );
        player.draw();
    }


    public void init() {

        keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(space);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (!isCrashed()) {

            if (KeyboardEvent.KEY_LEFT == keyboardEvent.getKey()) {
                if (player.getX() > 220) {

                    player.translate(-100, 0);
                    col = col - 100;
                }
            }
            if (KeyboardEvent.KEY_RIGHT == keyboardEvent.getKey()) {
                if (player.getX() < 500) {

                    player.translate(100, 0);
                    col = col + 100;
                }
            }

        }
        if (KeyboardEvent.KEY_SPACE == keyboardEvent.getKey()) {
            martelo = true;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public int getCol() {
        return col;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public void crash() {
        crashed = true;
    }

    public boolean getMartelo(){
        return martelo;
    }
}

package cars;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class PlayerCar {

    private boolean moveLeft;
    private boolean moveRight;
    private Picture player;
    private boolean crashed;
    private int col;


    public PlayerCar() {
        moveLeft = false;
        moveRight = false;
        col = 220;
        crashed = false;
        player = new Picture (220, 710,"Resources/batman.png" );
        player.draw();
    }



    public void playerInit() {

        if (!isCrashed()) {

            if (moveLeft) {
                if (player.getX() > 220) {

                    player.translate(-100, 0);
                    col = col - 100;
                    moveLeft = false;
                } else {
                    moveLeft = false;
                }
            }
            if (moveRight) {
                if (player.getX() < 500) {

                    player.translate(100, 0);
                    col = col + 100;
                    moveRight = false;
                } else {
                    moveRight = false;
                }
            }

        }
    }


    public void setMoveRight() {
       moveRight = true;
    }

    public void setMoveLeft() {
      moveLeft = true;
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

}

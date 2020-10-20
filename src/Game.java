import cars.Car;
import cars.PlayerCar;
import cars.RandomGenerator;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import java.util.ArrayList;
import java.util.List;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private boolean reset;
    private int timer;
    private Keyboard keyboard;
    private PlayerCar player;
    private int score;
    private int level;
    private Picture gameOverScreen;
    private Text scoreDisplay;
    private boolean x;
    private Sound crash;
    private Sound gameSound;


    public Game(boolean x) {
        this.x= x;
        score = 0;
        timer = 0;
        level = 0;
        reset =  false;


        gameSound = new Sound("/Resources/game.wav");
        crash = new Sound("/Resources/crash.wav");
        scoreDisplay = new Text(740, 50, Integer.toString(score));
        scoreDisplay.grow(15, 15);
        scoreDisplay.draw();
        scoreDisplay.setColor(Color.BLACK);


    }

    public void playGame() {
        /* --------------------------------------- KEYBOARD--------METHODS--------------------------------*/



        player = new PlayerCar();

        player.setCrashed(x);


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




    /*----------------------------------GAME METHODS-----------------------------------------*/
        gameSound.play(true);

    List<Car> parkedCars = new ArrayList<Car>();
    List<Car> runningCars = new ArrayList<Car>();


        for(int i = 0; i< 40; i++)  {

        parkedCars.add(new Car(RandomGenerator.pickCol()));

    }



        while(!player.isCrashed())

    {
        try {
            player.playerInit();
            if (timer % 11 == 0) {

                if (parkedCars.size() > 2) {
                    runningCars.add(parkedCars.remove(RandomGenerator.randomInt(0,33)));
                } else {
                    parkedCars.add(new Car(RandomGenerator.pickCol()));
                    runningCars.add(parkedCars.remove(0));
                }

            }
            int carToPark = -1;

            for (int i = 0; i < runningCars.size(); i++) {

                runningCars.get(i).fillCar();
                runningCars.get(i).move();
                runningCars.get(i).delete();


                if (runningCars.get(i).getCounter() == 71) {
                    score += 10;
                    scoreDisplay.setText(Integer.toString(score));
                    level++;
                    runningCars.get(i).setCounter(0);
                    carToPark = i;
                }
            }

            if (carToPark > -1) {
                parkedCars.add(runningCars.remove(carToPark));
            }


            for (int i = 0; i < runningCars.size(); i++) {
                if (runningCars.get(i).getCounter() > 62 && runningCars.get(i).getCounter() <= 71 && runningCars.get(i).getCol() == player.getCol()) {
                    player.crash();
                   crash.play(true);
                }
            }


            if (score < 100) {
                Thread.sleep(100 - (level));
                level = 0;
                timer++;
            } else if (score >= 100 && score < 300) {
                Thread.sleep(75 - (level));
                level = 0;
                timer++;
            } else if (score >= 300 && score < 500) {
                Thread.sleep(50 - level);
                level = 0;
                timer++;
            } else if (score >= 500 && score < 750) {
                Thread.sleep(35 - (level / 2));
                level = 0;
                timer++;
            } else if (score >= 750 && score < 1250) {
                Thread.sleep(20 - (level / 10));
                level = 0;
                timer++;
            } else {
                Thread.sleep(10);
                timer++;
            }


        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    gameOver();

}



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (KeyboardEvent.KEY_LEFT == keyboardEvent.getKey()) {
            player.setMoveLeft();
        }


        if (KeyboardEvent.KEY_RIGHT == keyboardEvent.getKey()) {
            player.setMoveRight();

        }


        if (KeyboardEvent.KEY_SPACE == keyboardEvent.getKey()) {
            reset = true;
            player.setCrashed(false);


        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isReset() {
        return reset;
    }

    public void gameOver() {

        if(player.isCrashed()) {
            gameSound.stop();
            gameOverScreen = new Picture(10, 10, "Resources/gameOver.jpg");
            gameOverScreen.draw();
            scoreDisplay = new Text(400, 250, Integer.toString(score));
            scoreDisplay.grow(100, 100);
            scoreDisplay.draw();
            scoreDisplay.setColor(Color.WHITE);

        }

    }

    public void deleteGameOverScreen() {
        gameOverScreen.delete();
    }

}




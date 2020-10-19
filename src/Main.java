import cars.PlayerCar;
import simpleGfx.SimpleGfxGrid;

public class Main {

    public static void main(String[] args) {

        SimpleGfxGrid grid = new SimpleGfxGrid(8);
        grid.init();


        Game game = new Game(true);
        game.playGame();

        while (true) {

            if (game.isReset()) {
                game.deleteGameOverScreen();
                grid= new SimpleGfxGrid(8);
                grid.init();
                game= new Game(false);
                game.playGame();

            }
        }
    }
}
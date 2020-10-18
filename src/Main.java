import cars.PlayerCar;
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
/*
        SimpleGfxGrid grid = new SimpleGfxGrid(8);
        grid.init();
        PlayerCar playerCar = new PlayerCar();
        playerCar.init();
        Game game = new Game(playerCar);
        while (true) {
            game.gameOver();
            if (playerCar.getMartelo()) {
                game.deleteGameOverScreen();
                game.playGame();
            }


      }
 */ }
}


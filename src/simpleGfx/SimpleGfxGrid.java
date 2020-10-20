package simpleGfx;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid {

    private final int PADDING = 10;
    private int cols;
    private int cellSize;

    private Picture backGroundImage;



    public SimpleGfxGrid (int cols) {
        this.cols = cols;
        this.cellSize = 100;

    }

    public void init () {

        backGroundImage = new Picture(PADDING,PADDING, "Resources/Untitled.jpeg");

        backGroundImage.draw();

    }

}



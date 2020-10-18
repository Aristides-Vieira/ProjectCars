package simpleGfx;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxGrid {

    private final int PADDING = 10;
    private int cols;
    private int cellSize;

    private Picture backGroundImage;

   // private Picture raceTrack;
   // private Line line;


    public SimpleGfxGrid (int cols) {
        this.cols = cols;
        this.cellSize = 100;

    }

    public void init () {

        backGroundImage = new Picture(PADDING,PADDING, "Resources/Untitled.jpeg");
      // raceTrack = new Picture(PADDING+200, PADDING, "/home/aristides/Documents/Academia-de-codigo/Projectos de grupo/ProjectCars/Resources/asphalt.png");

        //line = new Line(PADDING+700, PADDING, PADDING+700, 800);


        backGroundImage.draw();

       // raceTrack.draw();


       // line.setColor(Color.BLACK);
    }

}

package simpleGfx;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid {

    private final int PADDING = 10;
    private int cols;
    private int cellSize;
    private Rectangle raceTrack;
    private Line line;


    public SimpleGfxGrid (int cols) {
        this.cols = cols;
        this.cellSize = 100;

    }

    public void init () {

        raceTrack = new Rectangle(PADDING,PADDING,cols*cellSize,800);
        line = new Line(PADDING+700, PADDING, PADDING+700, 800);

        Line line1 = new Line(PADDING + 100, PADDING, PADDING+100, 800);
        Line line2 = new Line(PADDING+200, PADDING, PADDING+200, 800);
        Line line3 = new Line(PADDING+300, PADDING, PADDING+300, 800);
        Line line4 = new Line(PADDING+400, PADDING, PADDING+400, 800);
        Line line5 = new Line(PADDING+500, PADDING, PADDING+500, 800);
        Line line6 = new Line(PADDING+600, PADDING, PADDING+600, 800);
        raceTrack.setColor(Color.CYAN);
        raceTrack.draw();
        raceTrack.fill();


        line2.draw();
        line3.draw();
        line4.draw();
        line5.draw();
        line6.draw();
        line.setColor(Color.BLACK);
    }



}

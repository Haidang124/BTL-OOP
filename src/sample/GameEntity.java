package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameEntity extends Pane {
   protected image image = new image();
   protected double x;// vi tri in
   protected double y;
   protected static ArrayList<Tower> enemyArrayList = new ArrayList<>();
   // constructor
   public GameEntity(sample.image image, double x, double y) {

        this.image = image;
        this.x = x;
        this.y = y;
   }
    public GameEntity() {
        this.image = null;
        this.x = 0;
        this.y = 0;
    }
    public GameEntity(sample.image image) {
        this.image = image;
    }
    // getter && setter
    public sample.image getimage() {
        return image;
    }

    public void setImage(sample.image image) {
        this.image = image;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

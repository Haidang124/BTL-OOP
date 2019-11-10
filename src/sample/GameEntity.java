package sample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameEntity extends Pane {
   protected image image = new image();
   protected int x;// vi tri in
   protected int y;
   // constructor
   public GameEntity(sample.image image, int x, int y) {

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
    
    public int getx() {
        return x;
    }

    public void sety(int x) {
        this.x = x;
    }

    public int gety() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

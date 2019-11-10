package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Health {
    private int blood;
    private Rectangle Blood1;
    private Rectangle Bleed;
    public Health(int blood) {
       this.blood=blood;
        Bleed = new Rectangle(0,0,50,5);
        Blood1 = new Rectangle(0,0,50,5);
        Blood1.setFill(Color.GREEN);
        Bleed.setFill(Color.GRAY);
        Config.pane.getChildren().addAll(Bleed,Blood1);
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public Rectangle getBlood1() {
        return Blood1;
    }

    public void setBlood1(Rectangle blood1) {
        Blood1 = blood1;
    }

    public Rectangle getBleed() {
        return Bleed;
    }

    public void setBleed(Rectangle bleed) {
        Bleed = bleed;
    }


    public void  showHealth(Stage stage, double x, double y, int health)
    {
        Blood1.setWidth(health/2);
        Bleed.setWidth(50);
        Blood1.setTranslateX(x);
        Blood1.setTranslateY(y);
        Bleed.setTranslateX(x);
        Bleed.setTranslateY(y);
        stage.setScene(Config.scene);
    }

}

package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Health {
    private int blood;
    private Rectangle Blood;
    private Rectangle Bleed;
    public Health(int blood) {
        this.blood=blood;
        Bleed = new Rectangle(0,0,50,5);
        Blood = new Rectangle(0,0,50,5);
        Blood.setFill(Color.GREEN);
        Bleed.setFill(Color.GRAY);
        Config.pane.getChildren().addAll(Bleed,Blood);
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(Rectangle blood) {
        Blood = blood;
    }

    public Rectangle getBleed() {
        return Bleed;
    }

    public void setBleed(Rectangle bleed) {
        Bleed = bleed;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void  showHealth(Stage stage, double x, double y, int health)
    {
        Blood.setWidth(health/2);
        Bleed.setWidth(50);
        Blood.setTranslateX(x);
        Blood.setTranslateY(y);
        Bleed.setTranslateX(x);
        Bleed.setTranslateY(y);
        stage.setScene(Config.scene);
    }

}

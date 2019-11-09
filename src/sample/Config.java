package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class Config {
    public static final image imgbackground = new image("file:background.png");
    public static final image imgButtonExit = new image("file:images\\exitButton.png");
    public static final image imgButtonStart = new image("file:startButton.png");
    public static final int width_scene = 936;
    public static final int height_scene = 648;
    public static final int sizeimageMap = 72;
    public static final int sizeimageEnemy=50;
//    public static Canvas canvas = new Canvas(width_scene,height_scene);
//    public static GraphicsContext gc = canvas.getGraphicsContext2D();
    public static Pane pane = new Pane();
    public static Pane paneBG = new Pane();
    public static Group group = new Group();
    public static Scene scene = new Scene(pane,Config.width_scene,Config.height_scene);
    public static Scene background = new Scene(paneBG,800,472);
    public static final  int heigth_amountimage = height_scene/sizeimageMap;
    public static final  int width_amountimage = width_scene/sizeimageMap;

}

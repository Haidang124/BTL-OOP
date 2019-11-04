package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Config {
    public static final int width_scene = 936;
    public static final int height_scene = 648;
    public static final int sizeimageMap = 72;
    public static final int sizeimageEnemy=50;
    public static Pane pane = new Pane();
    public static Scene scene = new Scene(pane,Config.width_scene,Config.height_scene);
    public static final  int heigth_amountimage = height_scene/sizeimageMap;
    public static final  int width_amountimage = width_scene/sizeimageMap;

}

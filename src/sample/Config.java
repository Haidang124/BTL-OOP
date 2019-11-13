package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

public class Config {
    //image
    public static final image imgbackground = new image("file:images\\background1.png");
    public static final image imgButtonExit = new image("file:images\\exitButton.png");
    public static final image imgButtonStart = new image("file:images\\startButton.png");
    public static final image imgSound = new image("file:images\\sound.png");
    public static final image imgNoSound = new image("file:images\\nosound.png");
    public static final image imgPause = new image("file:images\\Pause.png");
    public static final image imgResume = new image("file:images\\Resume.png");
    public static final image imgMenu = new image("file:images\\menu.png");

    //media
    public static final Media soundBG = new Media(new File("sound\\background.mp3").toURI().toString());
    public static final Media soundSelect = new Media(new File("sound\\select.mp3").toURI().toString());
    public static final MediaPlayer mediaPlayerBG = new MediaPlayer(Config.soundBG);
    public static final MediaPlayer mediaPlayerSL = new MediaPlayer(Config.soundSelect);
    //boolean
    public static boolean blSound =true;
    public static boolean blPause =false;
    public static boolean blStart=false;
    //
    public static int Money=0;
    public static Stack<image> imageStack = new Stack<>();
    public static int x_pos;
    public static int y_pos;
    public static final int width_scene = 1176;
    public static final int width_menu = 240;
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
    public static final  int width_amountimage = (width_scene-width_menu)/sizeimageMap;
    public static void turnOnOff()
    {

    }
}

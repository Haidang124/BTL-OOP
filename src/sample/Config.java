package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

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
    public static final image imgMenu = new image("file:images\\menu1.png");
    public static final image imgBuy1 = new image("file:images\\buy1.png");
    public static final image imgBuy2 = new image("file:images\\buy2.png");
    public static final image imgBuy3 = new image("file:images\\buy3.png");
    public static final image imgHeart1 = new image("file:images\\heart.png");
    public static final image imgHeart2 = new image("file:images\\heart.png");
    public static final image imgHeart3 = new image("file:images\\heart.png");
    public static final image imgHeart4 = new image("file:images\\heart.png");
    public static final image imgHeart5 = new image("file:images\\heart.png");
    public static final image imgyoulose = new image("file:images\\youlose.png");
    public static final image imgyouwin = new image("file:images\\youwin.png");
    public static final image imgyouwin1 = new image("file:images\\youwin1.png");

    //media
    public static final Media soundBG = new Media(new File("sound\\background.mp3").toURI().toString());
    public static final Media soundMinion = new Media(new File("sound\\minion.mp3").toURI().toString());
    public static final Media soundSelect = new Media(new File("sound\\select.mp3").toURI().toString());
    public static final MediaPlayer mediaPlayerBG = new MediaPlayer(Config.soundBG);
    public static final MediaPlayer mediaPlayerMinion = new MediaPlayer(Config.soundMinion);
    public static final MediaPlayer mediaPlayerSL = new MediaPlayer(Config.soundSelect);
    //boolean
    public static boolean blSound =true;
    public static boolean blPause =false;
    public static boolean blStart=false;
    //Label
    public static Label label1 = new Label(Config.slTower1+"");
    public static Label label2 = new Label(Config.slTower2+"");
    public static Label label3 = new Label(Config.slTower3+"");
    public static Label labelMoney = new Label();

    //int
    public static int health=5;
    public static int slTower1 =0;
    public static int slTower2 =0;
    public static int slTower3 =0;
    public static int Money=100;
    public static Stack<image> imageStack = new Stack<>();
    public static int x_pos;
    public static int y_pos;
    public static final int width_scene = 1176;
    public static final int width_menu = 240;
    public static final int height_scene = 648;
    public static final int sizeimageMap = 72;
    public static final int sizeimageEnemy=50;
    public static final  int heigth_amountimage = height_scene/sizeimageMap;
    public static final  int width_amountimage = (width_scene-width_menu)/sizeimageMap;

    public static Pane pane = new Pane();
    public static Pane paneBG = new Pane();
    public static Group group = new Group();
    public static Scene scene = new Scene(pane,Config.width_scene,Config.height_scene);
    public static Scene background = new Scene(paneBG,800,472);
    public static void setting(Stage primaryStage)
    {
        Config.imgMenu.show(primaryStage,936,0);
        Config.imgSound.show(primaryStage,936,0);
        Config.imgPause.show(primaryStage,990,490);
        //heart
        Config.imgHeart1.show(primaryStage,944,370);
        Config.imgHeart2.show(primaryStage,944+44,370);
        Config.imgHeart3.show(primaryStage,944+44*2,370);
        Config.imgHeart4.show(primaryStage,944+44*3,370);
        Config.imgHeart5.show(primaryStage,944+44*4,370);
    }
}

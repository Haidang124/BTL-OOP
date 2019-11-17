package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class GameStage {
    public static final int x =0;
    public static final int y=startPosition();
    private static int countEnemy;
    public String[] arrEnemy = new String[countEnemy];
    public Stack<Enemy> stackEnemy = new Stack<>();
    public static ArrayList<Enemy> enemyArrayList = new ArrayList<>();

    public GameStage( int countEnemy) {
        this.countEnemy = countEnemy;
    }

    public static int getCountEnemy() {
        return countEnemy;
    }

    public static void setCountEnemy(int countEnemy) {
        GameStage.countEnemy = countEnemy;
    }

    public String[] getArrEnemy() {
        return arrEnemy;
    }

    public void setArrEnemy(String[] arrEnemy) {
        this.arrEnemy = arrEnemy;
    }

    public Stack<Enemy> getStackEnemy() {
        return stackEnemy;
    }

    public void setStackEnemy(Stack<Enemy> stackEnemy) {
        this.stackEnemy = stackEnemy;
    }

    public static int startPosition()
    {
        for(int i=0;i<Config.heigth_amountimage;i++)
        {
            String temp = GameField.arrmap[i][0];
            if(temp.equals("4") || temp.equals("5") || temp.equals("6")|| temp.equals("8"))  return  i*Config.sizeimageMap+(Config.sizeimageMap-Config.sizeimageEnemy)/2;
        }
        return 0;
    }
    public void loadArrayEnemy (String namefile)  throws IOException
    {
         BufferedReader buffered = new BufferedReader (new FileReader(namefile));
         arrEnemy = buffered.readLine().split(" ");
         for(int i=0;i<countEnemy;i++)
         {
             if(arrEnemy[i].equals("1"))
             {
                 SmallerEnemy smallerEnemy = new SmallerEnemy();
                 stackEnemy.push(smallerEnemy);
                 enemyArrayList.add(smallerEnemy);

             }
             else if(arrEnemy[i].equals("2"))
             {
                 NormalEnemy normalEnemy = new NormalEnemy();
                 stackEnemy.push(normalEnemy);
                 enemyArrayList.add(normalEnemy);
             }
             else
             {
                 TankerEnemy tankerEnemy = new TankerEnemy();
                 stackEnemy.push(tankerEnemy);
                 enemyArrayList.add(tankerEnemy);
             }
         }
    }
    public static void StartGame(Stage primaryStage)
    {

        Config.pane.setOnMouseClicked(mouseEvent1 ->
        {
            if(mouseEvent1.getSceneX() >=936 && mouseEvent1.getSceneX() <= 936+44 && mouseEvent1.getSceneY() >= 0 && mouseEvent1.getSceneY() <= 44)
            {
                if(Config.blSound==true)
                {
                    if(Config.pane.getChildren().contains(Config.imgNoSound.getImageView())) Config.pane.getChildren().remove(Config.imgNoSound.getImageView());
                    Config.imgNoSound.show(primaryStage,936,0);
                    Config.mediaPlayerSL.stop();
                    Config.mediaPlayerSL.play();
                    Config.blSound = false;
                    Config.mediaPlayerBG.stop();
                }
                else
                {
                    if(Config.pane.getChildren().contains(Config.imgSound.getImageView())) Config.pane.getChildren().remove(Config.imgSound.getImageView());
                    {
                        Config.imgSound.show(primaryStage,936,0);
                        Config.blSound = true;
                        Config.mediaPlayerBG.stop();
                        Config.mediaPlayerBG.play();
                    }
                }
            }
            else if(mouseEvent1.getSceneX() >=990 && mouseEvent1.getSceneX() <= 990+133 && mouseEvent1.getSceneY() >= 490 && mouseEvent1.getSceneY() <= 490+30)
            {
                if(Config.blPause==false)
                {
                    if(Config.blSound==true)
                    {
                        Config.mediaPlayerSL.stop();
                        Config.mediaPlayerSL.play();
                    }
                    if(Config.pane.getChildren().contains(Config.imgPause.getImageView())) Config.pane.getChildren().remove(Config.imgPause.getImageView());
                    Config.imgResume.show(primaryStage,990,490);
                    Config.blPause=true;
                }
                else
                {
                    if(Config.blSound==true)
                    {
                        Config.mediaPlayerSL.stop();
                        Config.mediaPlayerSL.play();
                    }
                    if(Config.pane.getChildren().contains(Config.imgResume.getImageView())) Config.pane.getChildren().remove(Config.imgResume.getImageView());
                    Config.imgPause.show(primaryStage,990,490);
                    Config.blPause=false;
                }
            }
        });
        Config.imgMenu.getImageView().setOnMouseClicked(mouseEvent1 -> {
            if(mouseEvent1.getSceneX() >=975 && mouseEvent1.getSceneX() <= 1135 && mouseEvent1.getSceneY() >= 535 && mouseEvent1.getSceneY() <= 570)
            {
                if(Config.blSound==true)
                {
                    Config.mediaPlayerSL.stop();
                    Config.mediaPlayerSL.play();
                }
                if(Config.blStart==false)
                {
                    GameStage gameStage = new GameStage(13);
                    try {
                        gameStage.loadArrayEnemy("arrEnemy.txt");
                    }
                    catch (Exception e) {}
                    Stack<Enemy> newStack =gameStage.getStackEnemy();
                    Config.mediaPlayerMinion.play();
                    Timeline timeline = new
                            Timeline(new KeyFrame(Duration.millis(2000),
                            (evt)->{
                                Stack<String> stringStack = new Stack<>();
                                System.out.println(newStack.size()+" " + gameStage.stackEnemy.size());
                                stringStack.push("right");
                                if(Config.blPause==false)
                                {
                                    if(newStack.isEmpty() == false) {
                                        newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                                    }
                                }
                            }
                    ));
                    Config.blStart=true;
                    timeline.setCycleCount(Animation.INDEFINITE);
                    timeline.play();
                }
            }
        });
        Timeline timeline2 = new
                Timeline(new KeyFrame(Duration.millis(500),
                (evt)->{
                    if(Config.blPause==false)
                    {
                        for(int i=0;i<GameEntity.towerArrayList.size();i++)
                        {
                            GameEntity.towerArrayList.get(i).findTarget(primaryStage);
                        }
                    }
                }
        ));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }
}

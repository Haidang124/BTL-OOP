package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.zip.CheckedOutputStream;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower Defense");
        // background
        Config.imgbackground.showBG(primaryStage,0,0);
        Config.imgButtonExit.showBG(primaryStage,540,379);
        Config.imgButtonStart.showBG(primaryStage,76,370);
        // Exit game
        Config.imgButtonExit.getImageView().setOnMouseClicked(mouseEvent -> {
            primaryStage.close();
        });
        // startGame
        Config.imgButtonStart.getImageView().setOnMouseClicked(mouseEvent -> {
            GameField gameField = new GameField();
            try
            {
                gameField.loadMapfromfile("input.txt");
            }
            catch (Exception e)
            {

            }
            gameField.loadImageMap();
            gameField.rendermap(primaryStage,0,0);
            GameStage gameStage = new GameStage(13);
            try {
                gameStage.loadArrayEnemy("arrEnemy.txt");
            }
            catch (Exception e) {}
            Stack<Enemy> newStack =gameStage.getStackEnemy();
//            Circle path = new Circle(72*4.5, 72*4.5, 72*6);
//            path.setFill(null);
//            path.setStroke(Color.RED);
//            Config.group.getChildren().add(path);
//            primaryStage.setScene(Config.scene);
//
//            Circle path1 = new Circle(72*4.5, 72*4.5, 72*4);
//            path1.setFill(null);
//            path1.setStroke(Color.BLUE);
//            Config.group.getChildren().add(path1);
//            Config.pane.getChildren().add(Config.group);
//            primaryStage.setScene(Config.scene);
//            primaryStage.show();

            //
            Bullet bullet2 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
            NormalTower tower = new NormalTower(72,72*2,bullet2);
            // show tower
            Config.pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                image towerMenu = new image("file:images\\NormalTower.png");
               //ImageView menuView = new ImageView(towerMenu);
                @Override
                public void handle(MouseEvent event) {
                    towerMenu.setImageView(new ImageView());
                    if (event.isPrimaryButtonDown()){
                        Config.x_pos = ((int)event.getX()/Config.sizeimageMap)*Config.sizeimageMap;
                        Config.y_pos = ((int)event.getY()/Config.sizeimageMap)*Config.sizeimageMap;
                        if (GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) {
                           // towerMenu.getImageView().setFitHeight(129);
                           // towerMenu.getImageView().setFitWidth(72);
                           // towerMenu.getImageView().setX(Config.x_pos - Config.sizeimageMap/2+30);
                            //towerMenu.getImageView().setY(Config.y_pos - (towerMenu.getImageView().getFitHeight()/2));
                            towerMenu.show(primaryStage,Config.x_pos - Config.sizeimageMap/2+30,Config.y_pos - (towerMenu.getImageView().getFitHeight()/2+60));
                            Timeline timeline1 = new
                                    Timeline(new KeyFrame(Duration.millis(1000),
                                    (evt)->{
                                        try {
                                            if (tower.canShoot(72 * 4.5, 72 * 4.5, 72 * 4, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX() + 12.5, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY() + 12.5)) {
                                                Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                                                bullet5.shoot(primaryStage,Config.x_pos - Config.sizeimageMap/2+30,Config.y_pos - (towerMenu.getImageView().getFitHeight()/2+60),Tower.arrayList.get(Tower.getTarget()));
                                            }
                                        }
                                        catch (NullPointerException e){};
                                    }
                            ));
                            timeline1.setCycleCount(Animation.INDEFINITE);
                            timeline1.play();
                            Config.imageArrayList.add(towerMenu);
                            if(Config.imageArrayList.isEmpty() == false) System.out.println(Config.imageArrayList.size()+" "+towerMenu.getImageView().getX());
                            try {
                                Config.pane.getChildren().add(towerMenu.getImageView());
                            } catch (IllegalArgumentException e){}
                        }
                    }
                }
            });



//            image image2 = new image("file:images\\SpinerTower.png");
//            image2.show(primaryStage,72-15,72+30);
//            image image = new image("file:images\\MGTower.png");
//            image.show(primaryStage,72*3-15,72*3);
//            image image1 = new image("file:images\\NormalTower.png");
//            image1.show(primaryStage,72*4,72*1);
            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(2000),
                    (evt)->{
                        Stack<String> stringStack = new Stack<>();
                        stringStack.push("right");
                        if(newStack.isEmpty() == false) {
                            newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                        if(Tower.getCount() >=1) tower.shoot(primaryStage,Tower.arrayList.get(Tower.getTarget()));

                    }
            ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });
    }
    public static void main(String[] args) {
        launch(args);

    }
}
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
import java.util.*;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower Defense");
        // background
        Config.imgbackground.showBG(primaryStage,0,0);
        Config.imgButtonExit.showBG(primaryStage,540,379);
        Config.imgButtonStart.showBG(primaryStage,76,370);

        Config.imgbackground.getImageView().setFocusTraversable(true);
        Config.imgButtonExit.getImageView().setFocusTraversable(true);
        Config.imgButtonStart.getImageView().setFocusTraversable(true);

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

            Timeline timeline = new
                    Timeline(new KeyFrame(Duration.millis(2000),
                    (evt)->{
                        Stack<String> stringStack = new Stack<>();
                        stringStack.push("right");
                        if(newStack.isEmpty() == false) {
                            newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                        }
                       // if(Tower.getCount() >=1) tower.shoot(primaryStage,Tower.arrayList.get(Tower.getTarget()));
                    }
            ));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

            Config.pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                Image towerMenu = new Image("file:images\\selTower.png");
                ImageView menuView = new ImageView(towerMenu);

                @Override
                public void handle(MouseEvent event) {
                    if (event.isPrimaryButtonDown()) {
                        System.out.println("mouse pressed");
                        Config.x_pos = ((int) event.getX() / Config.sizeimageMap) * Config.sizeimageMap;
                        Config.y_pos = ((int) event.getY() / Config.sizeimageMap) * Config.sizeimageMap;
                        System.out.println(Config.x_pos + " " + Config.y_pos + " " + GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)]);
                        if (GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) {
                            menuView.setFitHeight(70);
                            menuView.setFitWidth(120);
                            menuView.setX(Config.x_pos - Config.sizeimageMap / 2);
                            menuView.setY(Config.y_pos - (menuView.getFitHeight() / 2));
                            try {
                                Config.pane.getChildren().add(menuView);
                            } catch (IllegalArgumentException e) {
                            }

                            Config.pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                @Override
                                public void handle(KeyEvent event) {
                                    if (event.getCode() == KeyCode.DIGIT2) {
                                        Config.pane.getChildren().remove(menuView);
                                        NormalTower tower = new NormalTower(Config.x_pos, Config.y_pos, bullet2);
                                        tower.towerBuild(primaryStage);
                                        Timeline timeline1 = new
                                                Timeline(new KeyFrame(Duration.millis(1000),
                                                (evt)->{
                                                    try {
                                                        if(Tower.getCount() >=1)
                                                        {
                                                            if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX() , Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY())) {
                                                                Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                                                                bullet5.shoot(primaryStage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
                                                            }
                                                        }
                                                    }
                                                    catch (NullPointerException e){}
                                                }
                                        ));
                                        timeline1.setCycleCount(Animation.INDEFINITE);
                                        timeline1.play();
                                    }
                                    if (event.getCode() == KeyCode.DIGIT3) {
                                        Config.pane.getChildren().remove(menuView);
                                        SniperTower tower = new SniperTower(Config.x_pos, Config.y_pos, bullet2);
                                        tower.towerBuild(primaryStage);
                                        Timeline timeline1 = new
                                                Timeline(new KeyFrame(Duration.millis(1000),
                                                (evt)->{
                                                    try {
                                                        if(Tower.getCount() >=1)
                                                        {
                                                            if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX(), Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY() )) {
                                                                Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                                                                bullet5.shoot(primaryStage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
                                                            }
                                                        }
                                                    }
                                                    catch (NullPointerException e){}
                                                }
                                        ));
                                        timeline1.setCycleCount(Animation.INDEFINITE);
                                        timeline1.play();
                                    }
                                    if (event.getCode() == KeyCode.DIGIT1) {
                                        Config.pane.getChildren().remove(menuView);
                                        MachineGunTower tower = new MachineGunTower(Config.x_pos, Config.y_pos, bullet2);
                                        tower.towerBuild(primaryStage);
                                        Timeline timeline1 = new
                                                Timeline(new KeyFrame(Duration.millis(1000),
                                                (evt)->{
                                                    try {
                                                        if(Tower.getCount() >=1)
                                                        {
                                                            if (tower.canShoot(tower.getimage().getImageView().getX(), tower.getimage().getImageView().getY(),72 * 2, Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getX(), Tower.arrayList.get(Tower.getTarget()).getimage().getImageView().getY())) {
                                                                Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                                                                bullet5.shoot(primaryStage,tower.image.getImageView().getX(),tower.image.getImageView().getY() + (menuView.getFitHeight()/2-10),Tower.arrayList.get(Tower.getTarget()));
                                                            }
                                                        }
                                                    }
                                                    catch (NullPointerException e){}
                                                }
                                        ));
                                        timeline1.setCycleCount(Animation.INDEFINITE);
                                        timeline1.play();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        });
    }
    public static void main(String[] args) {
        launch(args);

    }
}
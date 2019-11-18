package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Stack;

public class Enemy extends GameEntity {
    protected int speed;
    protected Health health;
    protected int armor;
    protected int bonus;
    protected boolean survive = true;
    public Enemy(sample.image image, int speed, Health health, int armor, int bonus) {
        super(image);
        this.speed = speed;
        this.health = health;
        this.armor = armor;
        this.bonus = bonus;
    }
    public Enemy() {
        speed =0;
        health=null;
        armor =0;
        bonus=0;
    }

    // getter && setter
    public int getSpeed() {
        return speed;
    }

    public boolean isSurvive() {
        return survive;
    }

    public void setSurvive(boolean survive) {
        this.survive = survive;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    // method
    public void Run(Stage stage, final int x_now , final int y_now, Stack<String> direction)
    {
           image.show(stage,x_now,y_now);
           Timeline timeline = new
                   Timeline(new KeyFrame(Duration.millis(20),
                   (evt)->{
                       if(Config.blPause==false)
                       {
                           try{
                               health.showHealth(stage,image.getImageView().getX(),image.getImageView().getY(),health.getBlood());
                           }
                           catch (NullPointerException e) {}
                           try
                           {
                               String way = new String();
                               try {
                                   way = checkRoad((int)image.getImageView().getX(),(int)image.getImageView().getY(),direction);
                               }
                               catch (Exception e){}
                               if(way.equals("right"))
                               {
                                   image.getImageView().setX(image.getImageView().getX()+1);
                                   if(image.getImageView().getX() >= Config.width_scene-Config.width_menu || health.getBlood() == 0 ) die(stage);
                               }
                               if(way.equals("up"))
                               {
                                   image.getImageView().setY(image.getImageView().getY()-1);
                                   if(image.getImageView().getY()-11 < 0 || health.getBlood() == 0) die(stage);
                               }
                               if(way.equals("down"))
                               {
                                   image.getImageView().setY(image.getImageView().getY()+1);
                                   if(image.getImageView().getY() >= Config.height_scene || health.getBlood() == 0) die(stage);
                               }
                               if(way.equals("left"))
                               {
                                   image.getImageView().setX(image.getImageView().getX()-1);
                                   if(image.getImageView().getX() <0 || health.getBlood() == 0) die(stage);
                               }
                           }
                           catch (ArrayIndexOutOfBoundsException e)
                           {

                           }

                       }
                   }
           ));
           timeline.setCycleCount(Animation.INDEFINITE);
           timeline.play();
    }
    public String checkRoad(int x,int y ,Stack<String> direction)
    {
        if(direction.peek().equals("right") || direction.peek().equals("down"))
        {
            int arr_x = (x-11)/Config.sizeimageMap;
            int arr_y = (y-11)/Config.sizeimageMap;
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==6) {
                if(direction.peek()!="right") direction.push("right");
                return "right";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==8) {
                if(direction.peek()!="up") direction.push("up");
                return "up";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==5) {
                if(direction.peek()!="down") direction.push("down");
                return "down";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==4)
            {
                if(direction.peek()!="left") direction.push("left");
                return "left";
            }
            return "finish";
        }
        if(direction.peek().equals("left") || direction.peek().equals("up"))
        {
            int arr_x = (x+60)/Config.sizeimageMap;
            int arr_y = (y+60)/Config.sizeimageMap;
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==6) {
                if(direction.peek()!="right") direction.push("right");
                return "right";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==8) {
                if(direction.peek()!="up") direction.push("up");
                return "up";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==5) {
                if(direction.peek()!="down") direction.push("down");
                return "down";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==4)
            {
                if(direction.peek()!="left") direction.push("left");
                return "left";
            }
            return "finish";
        }
        return "finish";
    }
    public void die(Stage primaryStage) throws NullPointerException
    {
        if (this.getHealth().getBlood() > 0)
        {
           if(Config.health ==5)
           {
               Config.pane.getChildren().remove(Config.imgHeart5.getImageView());
               Config.health --;
           }
           else if(Config.health ==4)
           {
               Config.pane.getChildren().remove(Config.imgHeart4.getImageView());
               Config.health --;
           }
           else if(Config.health ==3)
           {
               Config.pane.getChildren().remove(Config.imgHeart3.getImageView());
               Config.health --;
           }
           else if(Config.health ==2)
           {
               Config.pane.getChildren().remove(Config.imgHeart2.getImageView());
               Config.health --;
           }
           else if(Config.health ==1)
           {
               Config.pane.getChildren().remove(Config.imgHeart1.getImageView());
               Config.health --;
                Config.imgyoulose.show(primaryStage,253,0);
                Config.blPause=true;
           }
        }

        if(this.isSurvive())
        {
            GameStage.enemyArrayList.remove(GameStage.enemyArrayList.size()-1);
            System.out.println(GameStage.enemyArrayList.size());
            this.getimage().remote();
            this.getimage().setImageView(null);
            this.setImage(null);
            health.getBlood1().setFill(Color.TRANSPARENT);
            health.getBleed().setFill(Color.TRANSPARENT);
            this.setSurvive(false);
            speed = 0;
            armor =0;
            bonus=0;
        }
        if(GameStage.enemyArrayList.size() == 0)
        {
            Config.imgyouwin.show(primaryStage,253,0);
        }
    }


}

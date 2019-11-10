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
    protected boolean danger;

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    public Enemy() {
        speed =0;
        health=null;
        armor =0;
        bonus=0;
        danger =false;
    }

    public Enemy(sample.image image, int speed, Health health, int armor, int bonus) {
        super(image);
        this.speed = speed;
        this.health = health;
        this.armor = armor;
        this.bonus = bonus;
        this.danger=false;
    }
 // getter && setter
    public int getSpeed() {
        return speed;
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
                    Tower.addTarget(this);
                    //System.out.println(Tower.getCount());
              try{
                  health.showHealth(stage,image.getImageView().getX(),image.getImageView().getY(),health.getBlood());
              }
              catch (NullPointerException e) {}
                   // if(Tower.canShoot1(72*4.5,72*4.5,72*4,image.getImageView().getX(),image.getImageView().getY())) health.setBlood(health.getBlood()-1);
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
                               if(Tower.canShoot2(72*4.5,72*4.5,72*4,this)==false) this.setDanger(false);
                               else {
                                   this.setDanger(true);
                               }
                               if(image.getImageView().getX() >= Config.width_scene || health.getBlood() == 0 ) die();
                           }
                           if(way.equals("up"))
                           {
                               image.getImageView().setY(image.getImageView().getY()-1);
                               if(Tower.canShoot2(72*4.5,72*4.5,72*4,this)==false) this.setDanger(false);
                               else {
                                   this.setDanger(true);
                               }
                               if(image.getImageView().getY()-11 < 0 || health.getBlood() == 0) die();
                           }
                           if(way.equals("down"))
                           {
                               image.getImageView().setY(image.getImageView().getY()+1);
                               if(Tower.canShoot2(72*4.5,72*4.5,72*4,this)==false) this.setDanger(false);
                               else {
                                   this.setDanger(true);
                               }
                               if(image.getImageView().getY() >= Config.height_scene || health.getBlood() == 0) die();
                           }
                           if(way.equals("left"))
                           {
                               image.getImageView().setX(image.getImageView().getX()-1);
                               if(Tower.canShoot2(72*4.5,72*4.5,72*4,this)==false) this.setDanger(false);
                               else {
                                   this.setDanger(true);
                               }
                               if(image.getImageView().getX() <0 || health.getBlood() == 0) die();
                           }
                       }
                       catch (ArrayIndexOutOfBoundsException e)
                       {

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
    public boolean checkNull()
    {
        try{
            this.getimage().getImageView();
            this.getimage();
            this.getimage().getImageView().getX();
        }
        catch (NullPointerException e){ return false; };
        return true;
    }
    public void die() throws NullPointerException
    {
        this.setDanger(false);
        try {
            this.getimage().remote();
            this.getimage().setImageView(null);
            this.setImage(null);
            health.getBleed().setFill(Color.TRANSPARENT);
        }
        catch (NullPointerException e) {}
        speed = 0;

        //this.getHealth().getImgBlood().remote();
        armor =0;
        bonus=0;
    }


}

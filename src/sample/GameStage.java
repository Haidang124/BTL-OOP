package sample;

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
    public static Stack<Enemy> stackEnemy = new Stack<>();
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
    public void StartGame()
    {

    }
}

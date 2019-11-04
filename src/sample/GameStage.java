package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GameStage {
    public static int x =0;
    public static int y=startPosition();
    public static int countEnemy;
    public String[] arrEnemy = new String[countEnemy];
    public Stack<String> stackEnemy = new Stack<>();
    public GameStage( int countEnemy) {
        this.countEnemy = countEnemy;

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
         BufferedReader buffread = new BufferedReader (new FileReader(namefile));
         arrEnemy = buffread.readLine().split(" ");
         for(int i=0;i<countEnemy;i++) stackEnemy.push(arrEnemy[i]);
    }
    public void StartGame()
    {

    }
}

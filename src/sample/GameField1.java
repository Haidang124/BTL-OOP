package sample;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Config;
import java.io.*;


public class GameField1 {
    protected GameEntity[][] gameEntities = new GameEntity[Config.heigth_amountimage][Config.width_amountimage];
    protected static String[][] arrmap = new String[Config.heigth_amountimage][Config.width_amountimage];
    //constuctor

    public GameField1(GameEntity[][] gameEntities) {
        this.gameEntities = gameEntities;
    }

    public GameField1() {
    }

    public GameField1(GameEntity[][] gameEntities, String[][] arrmap) {
        this.gameEntities = gameEntities;
        this.arrmap = arrmap;
    }

    //method
    public void loadMapfromfile (String namefile)  throws IOException
    {
        BufferedReader buffread = new BufferedReader (new FileReader(namefile));
        for(int i=0;i<Config.heigth_amountimage;i++)
        {
            arrmap[i] = buffread.readLine().split(" ");
        }
    }
    public void loadImageMap()
    {
        for(int i=0;i<Config.heigth_amountimage;i++)
        {
            for(int j=0;j<Config.width_amountimage;j++)
            {
                gameEntities[i][j] = new GameEntity(new image("file:"+arrmap[i][j]+".jpg"));
            }
        }
    }
    public void rendermap(Stage stage, int x,int y)
    {
        for(int i=0;i<Config.heigth_amountimage;i++)
        {
            for(int j=0;j<Config.width_amountimage;j++)
            {
                gameEntities[i][j].image.show(stage,x,y);
                x+=Config.sizeimageMap;
            }
            y+=Config.sizeimageMap;
            x=0;
        }
    }

}

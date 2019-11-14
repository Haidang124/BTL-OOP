package sample;
import java.io.InputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

 class image {
    private Image image;
    private ImageView imageView;
    // Constructor
    public image()
    {
    }
    public image(String url)
    {
        image = new Image(url);
    }
    public image(String url, boolean backgroundLoading)
    {
        image = new Image(url);
    }
    public image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth)
    {
        image = new Image(url,requestedWidth,requestedHeight,preserveRatio,smooth);
    }
    public image(String url, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth,boolean backgroundLoading)
    {
        image = new Image(url,requestedWidth,requestedHeight,preserveRatio,smooth,backgroundLoading);
    }
    //get && set


     public Image getImage() {
         return image;
     }

     public void setImage(Image image) {
         this.image = image;
     }

     public ImageView getImageView() {
         return imageView;
     }

     public void setImageView(ImageView imageView) {
         this.imageView = imageView;
     }

     // method
    public void show(Stage stage,double x,double y)
    {
        imageView = new ImageView(image);
        changePosition(x,y);
        Config.pane.getChildren().add(imageView);
        imageView.setFocusTraversable(true);
        stage.setScene(Config.scene);
        stage.show();
    }
     public void show(Stage stage,double x,double y,double width , double height)
     {
         imageView = new ImageView(image);
         imageView.setFitWidth(width);
         imageView.setFitHeight(height);
         changePosition(x,y);
         Config.pane.getChildren().add(imageView);
         stage.setScene(Config.scene);
         stage.show();
     }
     public void showBG(Stage stage,double x,double y)
     {
         imageView = new ImageView(image);
         changePosition(x,y);
         Config.paneBG.getChildren().add(imageView);
         stage.setScene(Config.background);
         stage.show();
     }
    public void changePosition(/* position  pos */double x,double y)
    {
            imageView.setX(x);
            imageView.setY(y);
    }
    public void remote()
    {
      try
      {
          imageView.imageProperty().set(null);
      }
      catch (NullPointerException e)
      {

      }

    }

}

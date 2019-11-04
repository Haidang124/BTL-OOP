package sample;

public class GameEntity {
   protected image image = new image();
   protected double width; // chiều rộng ảnh in
   protected double height;// chiều cao ảnh in
   protected int x;// vi tri in
   protected int y;
   // constructor
   public GameEntity(sample.image image, int width, int height, int x, int y) {

        this.image = image;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
   }
    public GameEntity() {
        this.image = null;
        this.width = 0;
        this.height = 0;
        this.x = 0;
        this.y = 0;
    }
    public GameEntity(sample.image image) {
        this.image = image;
    }
    // getter && setter
    public sample.image getImage() {
        return image;
    }

    public void setImage(sample.image image) {
        this.image = image;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

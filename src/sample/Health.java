package sample;

public class Health {
    private int blood ;
    private int bleed;
    private image imgBlood;
    private image imgBleed;

    public Health(int blood) {
        this.blood = blood;
        imgBlood = new image("file:blood.png");
        imgBleed = new image("file:bleed.png");
        bleed =0;
    }
    public void  enemyBleed(int bleed)
    {

    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getBleed() {
        return bleed;
    }

    public void setBleed(int bleed) {
        this.bleed = bleed;
    }

    public image getImgBlood() {
        return imgBlood;
    }

    public void setImgBlood(image imgBlood) {
        this.imgBlood = imgBlood;
    }

    public image getImgBleed() {
        return imgBleed;
    }

    public void setImgBleed(image imgBleed) {
        this.imgBleed = imgBleed;
    }
}

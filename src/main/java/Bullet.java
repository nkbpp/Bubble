import java.awt.*;

public class Bullet {
    //переменные
    private double x, y;
    private int r, speed;
    Color color;

    //конструкторы
    public Bullet() {
        x = GamePanel.player.getX();
        y = GamePanel.player.getY();

        r = 2;
        speed = 10;
        color = Color.WHITE;
    }

    //функции
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public void update() {
        y -= speed;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, r, 2 * r);
    }

    public boolean remove(){
        if(y<0){
            return true;
        }
        return false;
    }
}

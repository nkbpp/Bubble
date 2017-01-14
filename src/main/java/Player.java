import java.awt.*;

public class Player {
    //переменные
    private double x, y;
    private int r;

    private Color color1, color2;

    //конструкторы


    public Player() {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        r = 5;
        color1 = Color.WHITE;

    }

    //функции
    public void update() {

    }

    public void drow(Graphics2D g) {
        g.setColor(color1);
        g.fillOval((int)(x-r),(int)(y-r),2*r,2*r);
    }


    //переменные

    //конструкторы

    //функции
}

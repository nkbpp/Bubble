import java.awt.*;

public class Player {
    //переменные
    private double x, y, dx, dy;
    private int r;

    private int speed;

    private Color color1, color2;

    public static boolean up, down, left, right, isFiring;

    //конструкторы


    public Player() {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        dx = dy = 0;

        r = 5;
        color1 = Color.WHITE;

        up = left = down = right = isFiring = false;
        speed = 5;
    }

    //функции
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }



    public void update() {
        if (up && y > r) {
            dy = -speed;
        }

        if (down && y < GamePanel.HEIGHT - r) {
            dy = speed;
        }

        if (left && x > r) {
            dx = -speed;

        }
        if (right && (x < (GamePanel.WIDTH - r))) {
            dx = speed;

        }

        if (up && left || up && right || down && left || down && right) {
            double rad = Math.toRadians(45);
            dy = dy*Math.sin(rad);
            dx = dx*Math.cos(rad);
        }
        y+=dy;
        x+=dx;

        dy=dx=0;

        if(isFiring){
            GamePanel.bullets.add(new Bullet());
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(color1);
        g.fillOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color1.darker());
        g.drawOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        //g.setStroke(new BasicStroke(2));
    }


    //переменные

    //конструкторы

    //функции
}

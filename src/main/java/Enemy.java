import java.awt.*;

public class Enemy {

    //переменные
    private double x, y, speed, dx, dy;
    private int r;

    private double hells;

    private int type;
    private int rank;


    private Color color;
    //конструкторы


    public Enemy(int type, int rank) {
        this.type = type;
        this.rank = rank;

        switch (type) {
            case 1:
                color = Color.GREEN;
                switch (rank) {
                    case 1:
                        x = Math.random() * GamePanel.WIDTH;
                        y = 0;
                        speed = 2;
                        r=7;
                        hells = 2;
                        double rad = Math.toRadians(Math.random() * 360);
                        dx = Math.sin(rad) * speed;
                        dy = Math.cos(rad) * speed;

                }
                break;

        }
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

    public boolean remove(){
        if(hells<=0){
            return true;
        }
        return false;
    }

    public void hit(){
        hells--;
    }

    public void update() {
        x += dx;
        y += dy;

        if(x<0 && dx<0) dx=-dx;//стенки
        if(x>GamePanel.WIDTH && dx>0) dx=-dx;
        if(y<0 && dy<0) dy=-dy;
        if(y>GamePanel.HEIGHT && dy>0) dy=-dy;

    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)(x-r), (int)(y-r),2*r,2*r);
        g.setStroke(new BasicStroke(3));//обводка
        g.setColor(color.darker());
        g.drawOval((int)(x-r), (int)(y-r),2*r,2*r);//нарисовать но не заполнять
        g.setStroke(new BasicStroke(1));
    }
}

import java.awt.*;

public class GameBack {

    //переменные
    private Color color;

    //конструкторы


    public GameBack() {
        color = Color.BLUE;
    }

    //методы
    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }

}

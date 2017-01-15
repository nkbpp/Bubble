import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

class GamePanel extends JPanel implements Runnable {

    //Переменные Field
    public static int WIDTH = 400;//размеры панели
    public static int HEIGHT = 400;

    private Thread thread;

    private BufferedImage image;//холст где будем рисовать
    private Graphics2D g;//кисть

    public static GameBack background;//задний фон
    public static Player player;//игрок
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;

    //Конструктор
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));//установка размеров
        setFocusable(true);
        requestFocus();

        this.addKeyListener(new Listeners());
    }

    //Функции
    public void start() {
        thread = new Thread(this);
        thread.start();//запустили поток
    }

    public void run() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        background = new GameBack();
        player = new Player();
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();

        enemies.add(new Enemy(1, 1));
        enemies.add(new Enemy(1, 1));
        enemies.add(new Enemy(1, 1));
        enemies.add(new Enemy(1, 1));



        while (true) {
            gameUpdate();
            gameRender();
            gameDraw();

            try {
                thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameUpdate() {//обновление данных объектов
        background.update();

        player.update();
        //пули покидают поле
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).remove()) {
                bullets.remove(i);
                i--;
            }
        }

        for (Enemy e :
                enemies) {
            e.update();
        }

        //столкновение пульи врагов
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();
            for (int j = 0; j < bullets.size(); j++) {
                Bullet b = bullets.get(j);
                double bx = b.getX();
                double by = b.getY();
                double dx = ex - bx;
                double dy = ey - by;
                double distance = Math.sqrt(dx * dx + dy * dy);
                if ((int) distance <=  e.getR() + b.getR()) {//есть попадание
                    e.hit();
                    bullets.remove(j);
                    j--;
                }
            }

            if (e.remove()) {
                enemies.remove(i);
                i--;
            }
        }

        //столкновение игрока и врага
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();

            double px = player.getX();
            double py = player.getY();

            double dx = ex - px;
            double dy = ey - py;

            double distance = Math.sqrt(dx*dx + dy*dy);
            if ((int) distance <=  e.getR() + player.getR()){

            }
        }
    }

    public void gameRender() {//обновление графики
        background.draw(g);

        player.draw(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g);
        }

        for (Enemy e :
                enemies) {
            e.draw(g);
        }
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();//удаление обьекта который нарисовали
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class GamePanel extends JPanel implements Runnable {

    //Переменные Field
    public static int WIDTH = 400;//размеры панели
    public static int HEIGHT = 400;

    private Thread thread;

    private BufferedImage image;//холст где будем рисовать
    private Graphics2D g;//кисть

    public static GameBack background;//задний фон
    public static Player player;//игрок
    //Конструктор
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));//установка размеров
        setFocusable(true);
        requestFocus();


    }

    //Функции

    public void start(){
        thread = new Thread(this);
        thread.start();//запустили поток
    }

    public void run() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);



        background = new GameBack();
        player = new Player();

        while (true) {
            gameUpdate();
            gameRender();
            gameDrow();

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
    }

    public void gameRender() {//обновление графики
        background.draw(g);

        player.drow(g);
    }

    private void gameDrow() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();//удаление обьекта который нарисовали
    }

}

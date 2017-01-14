import javax.swing.*;

public class GameStart {
    public static void main(String[] args) {
        JFrame startFrame = new JFrame("Buble");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        startFrame.setContentPane(gamePanel);//добавление понели
        startFrame.pack();//размер по содержимому
        startFrame.setLocationRelativeTo(null);//позиция по центру
        startFrame.setVisible(true);
        gamePanel.start();
    }
}

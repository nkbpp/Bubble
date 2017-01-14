import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listeners implements KeyListener {

    public void keyTyped(KeyEvent e) { //вызывается системой каждый раз, когда пользователь нажимает на клавиатуре клавиши символы Unicode

    }

    public void keyPressed(KeyEvent e) { //Метод keyPressed вызывается системой в случае нажатия любой клавиши на клавиатуре
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = true;
        }

        if (key == KeyEvent.VK_UP) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = true;
        }

        if (key == KeyEvent.VK_SPACE) {
            Player.isFiring = true;
        }

    }

    public void keyReleased(KeyEvent e) {//Метод keyReleased вызывается при отпускании любой клавиши на клавиатуре
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = false;
        }

        if (key == KeyEvent.VK_UP) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = false;
        }

        if (key == KeyEvent.VK_SPACE) {
            Player.isFiring = false;
        }
    }
}

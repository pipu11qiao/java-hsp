package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements KeyListener, ActionListener {
    ImageIcon up = new ImageIcon("images/up.png");
    ImageIcon down = new ImageIcon("images/down.png");
    ImageIcon left = new ImageIcon("images/left.png");
    ImageIcon right = new ImageIcon("images/right.png");
    ImageIcon title = new ImageIcon("images/title.jpg");
    ImageIcon body = new ImageIcon("images/body.png");
    ImageIcon food = new ImageIcon("images/food.png");

    int[] snakeX = new int[750];
    int[] snakeY = new int[750];
    int len = 3;
    String direction = "R";

    Random r = new Random();

    int foodX = r.nextInt(34) * 25 + 25;
    int foodY = r.nextInt(24) * 25 + 25;

    boolean isStarted = false;
    boolean isFailed = false;

    public void initSnake() {
        isStarted = false;
        isFailed = false;
        len = 3;
        direction = "R";
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
    }

    public SnakePanel() {
        this.setFocusable(true);
        initSnake();
        this.addKeyListener(this);
        timer.start();
    }

    Timer timer = new Timer(150, this);

    public void paint(Graphics g) {
        this.setBackground(Color.black);
        g.fillRect(25, 75, 850, 600);
        title.paintIcon(this, g, 25, 11);

        if (direction.equals("R")) {
            right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("L")) {
            left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("U")) {
            up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (direction.equals("D")) {
            down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        for (int i = 1; i < len; i++) {
            body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        if (!isStarted) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("Press Space to Start or Pause", 230, 350);
        }
        if (!isFailed) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("Game Over,Press Space to Start", 230, 350);
        }

        food.paintIcon(this, g, foodX, foodY);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFailed) {
                initSnake();
            } else {
                isStarted = !isStarted;
            }
        } else if (keyCode == KeyEvent.VK_UP && !direction.equals("D")) {
            direction = "U";
        } else if (keyCode == KeyEvent.VK_DOWN && !direction.equals("U")) {
            direction = "D";
        } else if (keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")) {
            direction = "R";
        } else if (keyCode == KeyEvent.VK_LEFT && !direction.equals("R")) {
            direction = "L";
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (isStarted && !isFailed) {
            for (int i = len; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (direction.equals("R")) {
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (direction.equals("L")) {
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (direction.equals("U")) {
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] < 25) {
                    snakeY[0] = 850;
                }
            } else if (direction.equals("R")) {
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] > 850) {
                    snakeY[0] = 25;
                }
            }
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                len++;
                foodX = r.nextInt(34) * 25 + 25;
                foodY = r.nextInt(24) * 25 + 75;
            }
            for (int i = 1; i < len; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFailed = true;
                }
            }
        }
        repaint();
    }
}

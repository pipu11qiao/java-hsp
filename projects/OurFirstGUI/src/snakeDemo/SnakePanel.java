package snakeDemo;

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

public class SnakePanel extends JPanel implements KeyListener,ActionListener{
	//��������ͼƬ
	ImageIcon up = new ImageIcon("images/up.png");
	ImageIcon down = new ImageIcon("images/down.png");
	ImageIcon left = new ImageIcon("images/left.png");
	ImageIcon right = new ImageIcon("images/right.png");
	ImageIcon title = new ImageIcon("images/title.jpg");
	ImageIcon body = new ImageIcon("images/body.png");
	ImageIcon food = new ImageIcon("images/food.png");
	
	//�ߵ����ݽṹ���
	int[] snakex = new int[750];
	int[] snakey = new int[750];
	int len = 3;
	String direction = "R";//R��L��U��D��
	
	//ʳ������
	Random r = new Random();
	int foodx = r.nextInt(34)*25+25; // 34�����ӣ�һ������25�����أ�����25���ؿհ�
	int foody = r.nextInt(24)*25+75; // 24�����ӣ�һ������25�����أ�����75���ؿհ�
	
	//��Ϸ�Ƿ�ʼ
	boolean isStarted = false;
	
	//��Ϸ�Ƿ�ʧ��
	boolean isFaild = false;

	
	//	��ʼ����
	public void initSnake(){
		isStarted = false;
		isFaild = false;
		len = 3;
		direction = "R";
		snakex[0] = 100;
		snakey[0] = 100;
		snakex[1] = 75;
		snakey[1] = 100;
		snakex[2] = 50;
		snakey[2] = 100;
	}
	public SnakePanel() {
		this.setFocusable(true);
		initSnake(); //���þ�̬�ߣ�
		this.addKeyListener(this);//��Ӽ��̼����ӿ�
		timer.start();
	}
	//�������ƶ��ٶ�
	Timer timer = new Timer(150, this);
	
	public void paint(Graphics g){
		//���ñ�����ɫ
		this.setBackground(Color.black);
		g.fillRect(25, 75, 850, 600);
		//���ñ���
		title.paintIcon(this, g, 25, 11);
		
		//����ͷ
		if(direction.equals("R")){
			right.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(direction.equals("L")){
			left.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(direction.equals("U")){
			up.paintIcon(this, g, snakex[0], snakey[0]);
		}else if(direction.equals("D")){
			down.paintIcon(this, g, snakex[0], snakey[0]);
		}
		//������
		for(int i=1;i<len;i++){
			body.paintIcon(this, g, snakex[i],snakey[i]);
		}
		
		//����ʼ��ʾ��
		if(!isStarted){
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",Font.BOLD,30));
			g.drawString("Press Space to Start or Pause", 230, 350);
		}
		//��ʧ����ʾ��
		if (isFaild) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial",Font.BOLD,30));
			g.drawString("Game Over,Press Space to Start", 230, 350);
		}
		
		//��ʳ��
		food.paintIcon(this, g, foodx, foody);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//��������
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//ʵ�ֿո���ͣ ����
		if(keyCode == KeyEvent.VK_SPACE){
			if(isFaild){
				initSnake();
			}
			else{
			isStarted = !isStarted;
			}
//			repaint();
		}//ʵ��ת��
		else if(keyCode == KeyEvent.VK_UP && !direction.equals("D")){
			direction="U";
		}else if(keyCode == KeyEvent.VK_DOWN && !direction.equals("U")){
			direction="D";
		}else if(keyCode == KeyEvent.VK_LEFT && !direction.equals("R")){
			direction="L";
		}else if(keyCode == KeyEvent.VK_RIGHT && !direction.equals("L")){
			direction="R";
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * 1.��������
	 * 2.���ƶ�
	 * 3.�ػ�һ����
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
		if(isStarted && !isFaild){
			//�ƶ�����
			for(int i=len;i>0;i--){
				snakex[i] = snakex[i-1];
				snakey[i] = snakey[i-1];
			}
			//ͷ�ƶ�
			if(direction.equals("R")){
				//������+25
				snakex[0] = snakex[0]+25;
				if(snakex[0]>850) snakex[0] = 25;
				
				
			}else if(direction.equals("L")){
				//������-25
				snakex[0] = snakex[0]-25;
				if(snakex[0]<25) snakex[0] = 850;
			}else if(direction.equals("U")){
				//������-25
				snakey[0] = snakey[0]-25;
				if(snakey[0]<75) snakey[0] = 650;
			}else if(direction.equals("D")){
				//������+25
				snakey[0] = snakey[0]+25;
				if(snakey[0]>650) snakey[0] = 75;
			}
			//��ʳ��
			if(snakex[0] == foodx && snakey[0] == foody){
				len++;
				foodx = r.nextInt(34)*25+25;
				foody = r.nextInt(24)*25+75;
			}
			//�ж���Ϸʧ��
			for(int i=1;i<len;i++){
				if(snakex[0] == snakex[i] && snakey[0] == snakey[i]){
					isFaild = true;
				}
			}
		}
		repaint();
	}
}

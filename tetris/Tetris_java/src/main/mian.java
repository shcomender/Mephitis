package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mian{

	//��������
	private final static Tools tool = new Tools();			//������		
	public static GameMap Game_Map;							//��ͼ
	public static int Hor_index,Ver_index;					//С��������ڵ�ͼ���Ͻ�λ����
//	public final static int HOR_START=6,VER_START=1;
	public static int[][] Next_Tetris;
	public static int[][] Cur_Tetris;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		creatFrame();
	}
	
	public static void creatFrame() {
		//��ʼ������
		JFrame mj = new JFrame("����˹����");
		mj.setBounds(300, 50, 550, 650);
		mj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mj.setLayout(null);
		mj.setResizable(false);
		//��ʼ����ͼ
		Game_Map = new GameMap();
		mj.add(Game_Map);
		mj.addKeyListener(Game_Map);

		mj.setVisible(true);
	}
}

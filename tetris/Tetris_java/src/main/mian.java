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
	private static int cur_sorce = 0;						//��ǰ����
	private static int Top_sorce = 0;						//
	public static JPanel Right_Part;						//�Ҳ����
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
		Top_sorce = getTopSorce();
		cur_sorce =0;
		
		//��ʼ������
		JFrame mj = new JFrame("����˹����");
		mj.setBounds(300, 50, 550, 650);
		mj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mj.setLayout(null);
		mj.setResizable(false);
		//��ʼ���Ҳ�
		Game_Map = new GameMap();
		mj.add(Game_Map);
		mj.addKeyListener(Game_Map);
		Right_Part = tool.creatJPanle(350,0,200, 650, mj,new Color(180,180,180));
		//��ʼ���Ҳ�
		JLabel SorceTitle = tool.createJLabel(0,0,200,50,40,"��   ��",Right_Part);
		JLabel Sorce = tool.createJLabel(0, 60, 200, 50, 50, Integer.toString(cur_sorce), Right_Part);
		JLabel TopSorceTitle = tool.createJLabel(0, 120, 200, 50, 40, "�� �� ��", Right_Part);
		JLabel TopSorce = tool.createJLabel(0, 180, 200, 50, 50, Integer.toString(Top_sorce), Right_Part);
		JLabel NextTetris = tool.createJLabel(0,240,200,50,30,"��һ������",Right_Part);
		
		StartGame();
		
		
		mj.setVisible(true);
	}

	private static void StartGame() {
		// TODO Auto-generated method stub
		//��ʼ����ʾ�������
		TerisType teris_type = new TerisType();
		//��ȡ��ʼ��������״
		Next_Tetris=teris_type.getTetris();
		TetirsPaine tp = new TetirsPaine(Next_Tetris);
		Right_Part.add(tp);
		//Cur_Tetris=Next_Tetris;
		Game_Map.changeMap(Next_Tetris, 6, 1);
	}
	
	public void KeyPressed(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'W':System.out.println("1");
		break;
		}
	}
	
	
	//���ļ��ж�ȡ��߷�
	public  static int getTopSorce() {
		// TODO Auto-generated method stub
		int temp=0;
		return temp;
	}

}

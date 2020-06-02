package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameMap extends JPanel implements KeyListener{
	//map���������洢������ͼ�з����ռλ��Ϣ
	public int[][] map = new int[27][16];
	//ƫ�������������㷽��λ����������ĵ��ƫ�������������ÿ��С���λ��
	public int[][] offest = {{-1,-1},{0,-1},{1,-1},
							 {-1,0},{0,0},{1,0},
							 {-1,1},{0,1},{1,1} 
							};
	public static int[][] cur_Tetris=null;
	public static int[][] next_Tetris=null;
	
	public final static int START_HOR = 6,START_VER = 1;
	private static final String TopScore = "0";
	private static  String Score = "0";
	public static int hor_index,ver_index;
	public Timer timer;
	public boolean Can_Move = true;
	public static TerisType tp;
	
	public GameMap() {
		this.setBounds(0,0,550,650);
		this.setBackground(new Color(220, 220, 220));
		this.setVisible(true);
		this.setLayout(null);
		hor_index=START_HOR;
		ver_index=START_VER;
		timer = new Timer(500,this.TimeListener);
		timer.start();
		tp = new TerisType();
		cur_Tetris=tp.getTetris();
		next_Tetris=tp.getTetris();
		for(int i=0;i<16;i++)
			{
				map[25][i]=1;
				map[26][i]=1;
			}
	}
	
	ActionListener TimeListener = new  ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//�жϵ����鲻���ƶ��ˣ���ȡ�·��飬����ǰ��ͼ�����Ӽ��뱳������
			if(!Can_Move) {
				putInMap(cur_Tetris);
				isFilled(map);
				cur_Tetris=next_Tetris;
				next_Tetris=tp.getTetris();
				Can_Move=true;
				hor_index=START_HOR;
				ver_index=START_VER;
			}
			//������������
			if(ver_index<25) {
				ver_index++;
				if(!isOver(cur_Tetris, 1)) {
					ver_index--;
					putInMap(cur_Tetris);
				}
			//	System.out.println(Can_Move);
			}
			repaint();
			System.out.println(Can_Move+" "+ver_index);
		}
		//����ǰ������뱳������
		private void putInMap(int[][] cur_Tetris) {
			// TODO Auto-generated method stub
			Can_Move=false;
			int k=0;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(cur_Tetris[i][j]==1)map[ ver_index+offest[k][1] ] [ hor_index+offest[k][0] ]=1;
					k++;
				}
			}
			
		}
		
	};
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		//�����Ѿ��̶��ķ���
		for(int i=0;i<26;i++) {
			for(int j=0;j<14;j++) {
				if(map[i][j]!=0)g.fill3DRect(j*25,i*25, 25, 25, false);
			}
		}
		//���Ƶ�ǰ����
		int k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(cur_Tetris[i][j]!=0)g.fill3DRect((hor_index+offest[k][0])*25,(ver_index+offest[k][1])*25,25, 25, false);
				k++;
			}
		}
		//���Ʊ߽�
		g.setColor(Color.black);
		for(int i=0;i<26;i++) {
			if(map[i][15]==0)g.fill3DRect(350, i*25, 25, 25, false);
		}
		//����������Ϣ
		g.setFont(new Font("΢���ź�", Font.CENTER_BASELINE, 30));
		g.drawString("��Ϸ����:" + this.Score, 380, 50);
		g.drawString("��߼�¼:" + this.TopScore, 380, 100);
		g.drawString("��һ������", 380,150);
		g.setColor(Color.blue);
		k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(next_Tetris[i][j]!=0)g.fill3DRect(380+j*50,200+i*50, 50,50, false);
				k++;
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			ver_index++;
			if(isOver(cur_Tetris,1)) {
				repaint();
			}
			else ver_index--;
        }
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(hor_index<13) {
	           hor_index++;
	           if(isOver(cur_Tetris,2))
	           this.repaint();
	           else hor_index--;
			}
        }
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			hor_index--;
			if(isOver(cur_Tetris, 3)) {
				repaint();
			}
			else hor_index++;
			
        }if(e.getKeyCode()==KeyEvent.VK_SPACE) {
        	int[][] temp = TerisType.ChangeList.get(cur_Tetris);
        	if(isOver(temp,4))cur_Tetris=temp;
        	this.repaint();
        }	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//�߽���
	public boolean isOver(int[][] s,int x) {
		boolean flag = true;
		int dep=0,left=0,right=0,k;
		
		for(int i=0;i<3;i++)
			{
			if(s[i][0]==1)left=1;
			if(s[i][2]==1)right=1;
			}
		//�������޾�ֱ�Ӳ����ж�
		if(hor_index+right >13 || hor_index-left<0 || ver_index>24){ 
			flag = false;
			return flag;
		}
		//û�г��޵Ľ�����ײ�ж�
		k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(s[i][j]==1 && map[ ver_index+offest[k][1]] [ hor_index+offest[k][0] ]==1) {
					flag=false;
				}
					k++;
			}
		}
		return flag;
	}
	
	//������⣬�����ۼ�
	public void isFilled(int[][] s) {
		boolean flag;
		int i=-1;
		while(ver_index+i<=24 && i<2) {
			flag=true;
			System.out.println(ver_index+i);
			int[] temp = s[ver_index+i];
			//��Ϊtemp[15]Ϊ0������Ҫ�Լ�дһ�±�����������14
			for (int j : temp) {
				if(j==0)flag=false;
			}
			if(flag)System.out.println("this lap is filled");
			i++;
		}
	}
	
	
}

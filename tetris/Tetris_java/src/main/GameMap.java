package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GameMap extends JPanel implements KeyListener{
	//map数组用来存储整个地图中方块的占位信息
	public int[][] map = new int[29][14];
	//偏移数组用来计算方块位置相对于中心点的偏移量，方便计算每个小块的位置
	public int[][] offest = {{-1,-1},{0,-1},{1,-1},
							 {-1,0},{0,0},{1,0},
							 {-1,1},{0,1},{1,1} 
							};
	public final static int START_HOR = 6,START_VER = 1;
	public static int hor_index,ver_index;
	public static int[][] cur_Tetris=null;
	
	public GameMap() {
		this.setBounds(0,0,350,650);
		this.setBackground(new Color(220, 220, 220));
		this.setVisible(true);
		this.setLayout(null);
		hor_index=START_HOR;
		ver_index=START_VER;
	}
	
	private void move() {
		// TODO Auto-generated method stub
			ver_index++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ver_index);
			
	}

	//将当前移动的方块的中心坐标和形状输入到地图并显示出来
	public void changeMap(int[][] src,int hor_index,int ver_index) {
		cur_Tetris=src;
		this.hor_index=hor_index;
		this.ver_index=ver_index;
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		for(int i=3;i<29;i++) {
			for(int j=0;j<14;j++) {
				if(map[i][j]!=0)g.fill3DRect((i-3)*25, j*25, 25, 25, false);
			}
		}
		int k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(cur_Tetris[i][j]!=0)g.fill3DRect((hor_index+offest[k][0])*25,(ver_index+offest[k][1])*25,25, 25, false);
				k++;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			//向下移动的时候，需要将当前中心位置的上一层先全部置为0再向下
		if(ver_index<=23)	
			{ 
				ver_index++;
			if(isOver(cur_Tetris,1))
				this.repaint();
			else ver_index--;
          }
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
			if(hor_index>0)
		        {	hor_index--;
		        if(isOver(cur_Tetris,3))
		            this.repaint();
		        else hor_index++;
	            }
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
	
	public boolean isOver(int[][] s,int x) {
		boolean flag = true;
		int dep=0,left=0,right=0;
		for(int i=0;i<3;i++)
			{
			if(cur_Tetris[2][i]==1)dep=1;
			if(cur_Tetris[i][0]==1)left=1;
			if(cur_Tetris[i][2]==1)right=1;
			}
		
		switch(x) {
		case 1:if(ver_index+dep>24)flag = false;break;
		case 2:if(hor_index+right>13)flag = false;break;
		case 3:if(hor_index-left<0)flag = false;break;
		case 4:if(ver_index==24) flag = false;break;
		}
		System.out.println(flag);
		return flag;
	}
	
}

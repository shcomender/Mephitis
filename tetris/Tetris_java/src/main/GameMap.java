package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameMap extends JPanel{
	//map数组用来存储整个地图中方块的占位信息
	public int[][] map = new int[29][14];
	//偏移数组用来计算方块位置相对于中心点的偏移量，方便计算每个小块的位置
	public int[][] offest = {{-1,-1},{0,-1},{1,-1},
							 {-1,0},{0,0},{1,0},
							 {-1,1},{0,1},{1,0} 
							};
	
	public GameMap() {
		this.setBounds(0,0,350,650);
		this.setBackground(new Color(220, 220, 220));
		this.setVisible(true);
		this.setLayout(null);
	}
	
	public void test() {
		map[5][5]=1;
		repaint();
	}
	
	public void changeMap(int[][] src,int hor_index,int ver_index) {
		int k=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				map[hor_index+offest[k][0]][ver_index+offest[k][1]]=src[i][j];
				k++;
			}
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		for(int i=3;i<26;i++) {
			for(int j=0;j<14;j++) {
				if(map[i][j]!=0)g.fill3DRect(i*25, j*25, 25, 25, false);
			}
		}
	}
}

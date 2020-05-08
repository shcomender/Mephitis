package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TetirsPaine extends JPanel{
	public int[][] src;
	
	public TetirsPaine(int[][] src) {
		this.src=src;
		this.setBounds(10, 300, 150, 150);
	}
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(src[i][j]!=0)g.fill3DRect(j*50, i*50, 50, 50, false);
			}
		}
	}
}

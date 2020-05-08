package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Tools {

	public static JPanel creatJPanle(int x,int y,int width,int height,JFrame jf,Color color) {
		JPanel jp = new JPanel();
		jp.setBounds(x, y, width, height);
		jp.setBackground(color);
		jp.setVisible(true);
		jp.setLayout(null);
		jf.add(jp);
		return jp;
	}

	public static JLabel createJLabel(int x,int y,int w,int h,int size,String text,JPanel jp) {
		// TODO Auto-generated method stub
		JLabel jl = new JLabel(text);
		jl.setBounds(x, y, w, h);
		jl.setVisible(true);
		Font f = new Font("ËÎÌו",Font.BOLD,size);
		jl.setFont(f);
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		
		jp.add(jl);
		return jl;
	}
	
}

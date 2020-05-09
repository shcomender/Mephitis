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

	//变量声明
	private final static Tools tool = new Tools();			//工具类		
	public static GameMap Game_Map;							//地图
	public static int Hor_index,Ver_index;					//小方块相对于地图左上角位移量
//	public final static int HOR_START=6,VER_START=1;
	public static int[][] Next_Tetris;
	public static int[][] Cur_Tetris;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		creatFrame();
	}
	
	public static void creatFrame() {
		//初始化界面
		JFrame mj = new JFrame("俄罗斯方块");
		mj.setBounds(300, 50, 550, 650);
		mj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mj.setLayout(null);
		mj.setResizable(false);
		//初始化地图
		Game_Map = new GameMap();
		mj.add(Game_Map);
		mj.addKeyListener(Game_Map);

		mj.setVisible(true);
	}
}

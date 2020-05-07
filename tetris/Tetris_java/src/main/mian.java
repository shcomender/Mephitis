package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mian {

	//变量声明
	private final static Tools tool = new Tools();			//工具类
	private static int cur_sorce = 0;						//当前分数
	private static int Top_sorce = 0;						//
	public static JPanel Right_Part;						//右侧面板
	public static GameMap Game_Map;							//地图
	public static int Hor_index,Ver_index;					//小方块相对于地图左上角位移量
	public final static int HOR_START=6,VER_START=1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		creatFrame();
	}
	
	public static void creatFrame() {
		//初始化数据
		Top_sorce = getTopSorce();
		cur_sorce =0;
		
		//初始化界面
		JFrame mj = new JFrame("俄罗斯方块");
		mj.setBounds(300, 50, 550, 650);
		mj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mj.setLayout(null);
		mj.setResizable(false);
		//初始化右侧
		Game_Map = new GameMap();
		mj.add(Game_Map);
		Right_Part = tool.creatJPanle(350,0,200, 650, mj,new Color(180,180,180));
		//初始化右侧
		JLabel SorceTitle = tool.createJLabel(0,0,200,50,40,"分   数",Right_Part);
		JLabel Sorce = tool.createJLabel(0, 60, 200, 50, 50, Integer.toString(cur_sorce), Right_Part);
		JLabel TopSorceTitle = tool.createJLabel(0, 120, 200, 50, 40, "最 高 分", Right_Part);
		JLabel TopSorce = tool.createJLabel(0, 180, 200, 50, 50, Integer.toString(Top_sorce), Right_Part);
		JLabel NextTetris = tool.createJLabel(0,240,200,50,30,"下一个方块",Right_Part);
		
		StartGame();
		
		
		mj.setVisible(true);
	}

	private static void StartGame() {
		// TODO Auto-generated method stub
		//初始化提示区域面板
		TerisType teris_type = new TerisType();
		//获取初始化方块形状
		TetirsPaine tp = new TetirsPaine(teris_type.getTetris());
		Right_Part.add(tp);
		
		Game_Map.changeMap(teris_type.getTetris(), 6, 6);
	}

	public  static int getTopSorce() {
		// TODO Auto-generated method stub
		int temp=0;
		return temp;
	}
}

package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TerisType {
	
	//所有的方块类型都使用一个二维数组构成
	//一竖
	public int[][] t1 = {{0,1,0},{0,1,0},{0,1,0}};
	//一横
	public int[][] t2 = {{0,0,0},{1,1,1},{0,0,0}};
	//正方块
	public int[][] t3 = {{0,0,0},{1,1,0},{1,1,0}};
	//L
	public int[][] t4 = {{1,0,0},{1,1,1},{0,0,0}};
	//L2
	public int[][] t5 = {{0,1,0},{0,1,0},{1,1,0}};
	//L3
	public int[][] t6 = {{0,0,0},{1,1,1},{0,0,1}};
	//L4 
	public int[][] t7 = {{0,1,1},{0,1,0},{0,1,0}};
	//Z型
	public int[][] t8 = {{1,1,0},{0,1,1},{0,0,0}};
	//Z1
	public int[][] t9 = {{0,0,1},{0,1,1},{0,1,0}};
	//Z2
	public int[][] t10 = {{0,1,1},{1,1,0},{0,0,0}};
	//Z3
	public int[][] t11 = {{0,1,0},{0,1,1},{0,0,1}};
	
	static Map<Integer,int[][]> Ttype = new HashMap<>();
	static Map<int[][],int[][]> ChangeList = new HashMap<>();
	public TerisType() {
		//Ttype图初始化
		Ttype.put(1,t1);
		Ttype.put(2,t2);
		Ttype.put(3,t3);
		Ttype.put(4,t4);
		Ttype.put(5,t5);
		Ttype.put(6,t6);
		Ttype.put(7,t7);
		Ttype.put(8,t8);
		Ttype.put(9,t9);
		Ttype.put(10,t10);
		Ttype.put(11,t11);
		//转换图初始化
		//L
		ChangeList.put(t1, t2);
		ChangeList.put(t2, t1);
		//正方块
		ChangeList.put(t3, t3);
		//L形
		ChangeList.put(t4, t5);
		ChangeList.put(t5, t6);
		ChangeList.put(t6, t7);
		ChangeList.put(t7, t4);
		//Z1,z2
		ChangeList.put(t8, t9);
		ChangeList.put(t9, t8);
		//Z3,Z4
		ChangeList.put(t10, t11);
		ChangeList.put(t11, t10);
	}
	
	public int[][] getTetris(){
		int a =0;
		while(a==0) a = (new Random()).nextInt(11);
		if(!Ttype.isEmpty()) {
			return Ttype.get(a);
		}
		else return new int[][] {};
	}
}

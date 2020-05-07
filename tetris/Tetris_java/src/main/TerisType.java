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
	
	Map<Integer,int[][]> Ttype = new HashMap<>();
	
	public TerisType() {
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
	}
	
	public int[][] getTetris(){
		int a = (new Random()).nextInt(11);
		if(!Ttype.isEmpty()) {
			return Ttype.get(a);
		}
		else return new int[][] {};
	}
}

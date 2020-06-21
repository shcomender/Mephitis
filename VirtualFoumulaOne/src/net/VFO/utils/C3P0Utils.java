package net.VFO.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用C3P0提供数据库连接池
 * 
 * @author Gordon
 * @date 2020年6月14日下午4:41:56
 * @version V1.6.8
 */
public class C3P0Utils {
	
	// 使用配置文件构建一个数据源对象
	private static DataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");

	private C3P0Utils() {
	}

	/**
	 * 获取数据源对象
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

}

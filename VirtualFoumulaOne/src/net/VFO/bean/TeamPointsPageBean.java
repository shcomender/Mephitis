package net.VFO.bean;

import java.util.List;

/**
 * 存放用户信息相关的分页信息
 * 
 * @author Gordon
 * @date 2020年6月17日上午9:08:49
 * @version V1.6.8
 */
public class TeamPointsPageBean {

	private Integer page;// 当前页面
	private Integer size;// 页面条数
	private List<TeamPoints> userInfos;// 集合对象
	private Integer total;// 总数
	private Integer totalPages;// 总页数
	private Integer currPageCount;// 当前页面总数

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<TeamPoints> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<TeamPoints> userInfos) {
		this.userInfos = userInfos;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCurrPageCount() {
		return userInfos == null ? 0 : userInfos.size();
	}

	public void setCurrPageCount(Integer currPageCount) {
		this.currPageCount = currPageCount;
	}

}

package util;

import java.util.ArrayList;
import java.util.List;

public class PageList<T> {
	
	/*兼容easyui分页的对象*/
	private long total;//总条目数
	private List<T> rows = new ArrayList<>();//当前页的数据
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	

}

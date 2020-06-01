package query;

public class BaseQuery {
	/*兼容Easyui的分页条件*/
	private Integer page;//第几页
	private Integer rows;//每页显示的条目数
	private String q;//兼容combogrid查询的参数名
	private String isPregnantwoman;
	private String ispregnantwoman;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getIsPregnantwoman() {
		return isPregnantwoman;
	}
	public void setIsPregnantwoman(String isPregnantwoman) {
		this.isPregnantwoman = isPregnantwoman;
	}
	public String getIspregnantwoman() {
		return ispregnantwoman;
	}
	public void setIspregnantwoman(String ispregnantwoman) {
		this.ispregnantwoman = ispregnantwoman;
	}
	
	
}

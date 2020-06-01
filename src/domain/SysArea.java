package domain;

public class SysArea {
    private Integer id;

    private String name;

    private String citycode;

    private String provincecode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

	@Override
	public String toString() {
		return "SysArea [id=" + id + ", name=" + name + ", citycode=" + citycode + ", provincecode=" + provincecode
				+ "]";
	}
    
}
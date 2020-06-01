package domain;

public class SysStreet {
    private Integer id;

    private String name;

    private String areacode;

    private String provincecode;

    private String citycode;

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

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

	@Override
	public String toString() {
		return "SysStreet [id=" + id + ", name=" + name + ", areacode=" + areacode + ", provincecode=" + provincecode
				+ ", citycode=" + citycode + "]";
	}
    
}
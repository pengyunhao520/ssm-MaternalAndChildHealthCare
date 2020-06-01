package domain;

public class DictionaryDetails {
    private Integer id;

	private Integer typeid;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	@Override
	public String toString() {
		return "DictionaryDetails [id=" + id + ", typeid=" + typeid + ", name=" + name + "]";
	}
	
}
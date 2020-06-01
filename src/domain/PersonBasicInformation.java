package domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonBasicInformation {
	//编号
    private Integer id;
    //保健册号
    private String healthcode;
    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //出生日期
    private Date birthdate;
    //民族
    private Nation nation;
    //职业
    private String profession;
    //学历
    private Education education;
    //家庭角色
    private String familymembertype;
    //省
    private SysProvince province;
    //市
    private SysCity city;
    //县
    private SysArea county;
    //镇乡
    private SysStreet town;
    //村
    private String gardon;
    //工作单位
    private String workunit;
    //手机号
    private String phonenumber;
    //微信号
    private String wechat;
    //身份证号
    private String idNumber;
    //本地户口标示
    private String isLocal;
    //生育证号
    private String birthcertificatenumber;
    //休养地址
    private String restaddress;
    //孕妇标示
    private String isPregnantwoman;
    //生育标示
    private String isBirth;
    //婚史
    private Integer marryhistory;
    
    
    private GeneticHistory geneticHistory;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHealthcode() {
        return healthcode;
    }

    public void setHealthcode(String healthcode) {
        this.healthcode = healthcode == null ? null : healthcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getBirthdate() {
        return birthdate;
    }
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getFamilymembertype() {
        return familymembertype;
    }

    public void setFamilymembertype(String familymembertype) {
        this.familymembertype = familymembertype == null ? null : familymembertype.trim();
    }

   

	


    public SysCity getCity() {
		return city;
	}

	public void setCity(SysCity city) {
		this.city = city;
	}

	public SysArea getCounty() {
		return county;
	}

	public void setCounty(SysArea county) {
		this.county = county;
	}

	public SysStreet getTown() {
		return town;
	}

	public void setTown(SysStreet town) {
		this.town = town;
	}

	public SysProvince getProvince() {
		return province;
	}

	public void setProvince(SysProvince province) {
		this.province = province;
	}

	

    public String getGardon() {
        return gardon;
    }

    public void setGardon(String gardon) {
        this.gardon = gardon;
    }

    public String getWorkunit() {
        return workunit;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit == null ? null : workunit.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(String isLocal) {
        this.isLocal = isLocal == null ? null : isLocal.trim();
    }

    public String getBirthcertificatenumber() {
        return birthcertificatenumber;
    }

    public void setBirthcertificatenumber(String birthcertificatenumber) {
        this.birthcertificatenumber = birthcertificatenumber == null ? null : birthcertificatenumber.trim();
    }

    public String getRestaddress() {
        return restaddress;
    }

    public void setRestaddress(String restaddress) {
        this.restaddress = restaddress == null ? null : restaddress.trim();
    }

    public String getIsPregnantwoman() {
        return isPregnantwoman;
    }

    public void setIsPregnantwoman(String isPregnantwoman) {
        this.isPregnantwoman = isPregnantwoman == null ? null : isPregnantwoman.trim();
    }

    public String getIsBirth() {
        return isBirth;
    }

    public void setIsBirth(String isBirth) {
        this.isBirth = isBirth == null ? null : isBirth.trim();
    }

    public Integer getMarryhistory() {
        return marryhistory;
    }

    public void setMarryhistory(Integer marryhistory) {
        this.marryhistory = marryhistory;
    }
    
    

	public GeneticHistory getGeneticHistory() {
		return geneticHistory;
	}

	public void setGeneticHistory(GeneticHistory geneticHistory) {
		this.geneticHistory = geneticHistory;
	}

	@Override
	public String toString() {
		return "PersonBasicInformation [id=" + id + ", healthcode=" + healthcode + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", birthdate=" + birthdate + ", nation=" + nation + ", profession=" + profession
				+ ", education=" + education + ", familymembertype=" + familymembertype + ", province=" + province
				+ ", city=" + city + ", county=" + county + ", town=" + town + ", gardon=" + gardon + ", workunit="
				+ workunit + ", phonenumber=" + phonenumber + ", wechat=" + wechat + ", idNumber=" + idNumber
				+ ", isLocal=" + isLocal + ", birthcertificatenumber=" + birthcertificatenumber + ", restaddress="
				+ restaddress + ", isPregnantwoman=" + isPregnantwoman + ", isBirth=" + isBirth + ", marryhistory="
				+ marryhistory + ", geneticHistory=" + geneticHistory + "]";
	}

	
    
    
}
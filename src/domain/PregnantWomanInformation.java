package domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PregnantWomanInformation {
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
    //学历
    private Education education;
    //职业
    private String profession;
    //省
    private SysProvince province;
    //市
    private SysCity city;
    //县
    private SysArea county;
    //街道
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
    private String idnumber;
    //丈夫id
    private Integer husbandid;
    //丈夫姓名
    private String husbandname;
    //丈夫年龄
    private Integer husbandage;
    //丈夫电话号
    private String husbandphonenumber;
    //户口
    private String islocal;
    //生育证号
    private String birthcertificatenumber;
    //休养地址
    private String restaddress;
    //孕妇标示
    private String ispregnantwoman;
    //婚史
    private Integer marryhistory;
    //检查次数
    private Integer checkcount;
    //创建人
    private String establishperson;
    //检查时间
    private Date checktime;
    //孕妇遗传病史
    private PrewomanGeneticHistory prewomanGeneticHistory;
    //孕妇生育历史
    private AbnormalMaternalHistory abnormalMaternalHistory;

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
		this.healthcode = healthcode;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getGardon() {
        return gardon;
    }

    public void setGardon(String gardon) {
        this.gardon = gardon == null ? null : gardon.trim();
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

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public Integer getHusbandid() {
        return husbandid;
    }

    public void setHusbandid(Integer husbandid) {
        this.husbandid = husbandid;
    }

    public String getHusbandname() {
        return husbandname;
    }

    public void setHusbandname(String husbandname) {
        this.husbandname = husbandname == null ? null : husbandname.trim();
    }

    public Integer getHusbandage() {
        return husbandage;
    }

    public void setHusbandage(Integer husbandage) {
        this.husbandage = husbandage;
    }

    public String getHusbandphonenumber() {
        return husbandphonenumber;
    }

    public void setHusbandphonenumber(String husbandphonenumber) {
        this.husbandphonenumber = husbandphonenumber == null ? null : husbandphonenumber.trim();
    }

    public String getIslocal() {
        return islocal;
    }

    public void setIslocal(String islocal) {
        this.islocal = islocal == null ? null : islocal.trim();
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

    public String getIspregnantwoman() {
        return ispregnantwoman;
    }

    public void setIspregnantwoman(String ispregnantwoman) {
        this.ispregnantwoman = ispregnantwoman == null ? null : ispregnantwoman.trim();
    }

    public Integer getMarryhistory() {
        return marryhistory;
    }

    public void setMarryhistory(Integer marryhistory) {
        this.marryhistory = marryhistory;
    }

    public Integer getCheckcount() {
        return checkcount;
    }

    public void setCheckcount(Integer checkcount) {
        this.checkcount = checkcount;
    }

    public String getEstablishperson() {
        return establishperson;
    }

    public void setEstablishperson(String establishperson) {
        this.establishperson = establishperson == null ? null : establishperson.trim();
    }
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getChecktime() {
        return checktime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public SysProvince getProvince() {
		return province;
	}

	public void setProvince(SysProvince province) {
		this.province = province;
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

	public PrewomanGeneticHistory getPrewomanGeneticHistory() {
		return prewomanGeneticHistory;
	}

	public void setPrewomanGeneticHistory(PrewomanGeneticHistory prewomanGeneticHistory) {
		this.prewomanGeneticHistory = prewomanGeneticHistory;
	}
	
	
	
	public AbnormalMaternalHistory getAbnormalMaternalHistory() {
		return abnormalMaternalHistory;
	}

	public void setAbnormalMaternalHistory(AbnormalMaternalHistory abnormalMaternalHistory) {
		this.abnormalMaternalHistory = abnormalMaternalHistory;
	}
	

	@Override
	public String toString() {
		return "PregnantWomanInformation [id=" + id + ", healthcode=" + healthcode + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", birthdate=" + birthdate + ", nation=" + nation + ", education=" + education
				+ ", profession=" + profession + ", province=" + province + ", city=" + city + ", county=" + county
				+ ", town=" + town + ", gardon=" + gardon + ", workunit=" + workunit + ", phonenumber=" + phonenumber
				+ ", wechat=" + wechat + ", idnumber=" + idnumber + ", husbandid=" + husbandid + ", husbandname="
				+ husbandname + ", husbandage=" + husbandage + ", husbandphonenumber=" + husbandphonenumber
				+ ", islocal=" + islocal + ", birthcertificatenumber=" + birthcertificatenumber + ", restaddress="
				+ restaddress + ", ispregnantwoman=" + ispregnantwoman + ", marryhistory=" + marryhistory
				+ ", checkcount=" + checkcount + ", establishperson=" + establishperson + ", checktime=" + checktime
				+ ", prewomanGeneticHistory=" + prewomanGeneticHistory + ", abnormalMaternalHistory="
				+ abnormalMaternalHistory + "]";
	}

	

}
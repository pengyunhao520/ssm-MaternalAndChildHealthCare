package query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import domain.Education;
import domain.Nation;
import domain.SysArea;
import domain.SysCity;
import domain.SysProvince;
import domain.SysStreet;

public class PersonBasicInformationQuery extends BaseQuery{
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
    private Integer gardon;
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
    
    //出生日期
    private Date begintime;
    //出生日期
    private Date endtime;

	public Date getBegintime() {
		return begintime;
	}
	@DateTimeFormat(pattern="yyy-MM-dd")
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	@DateTimeFormat(pattern="yyy-MM-dd")
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
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
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
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
		this.profession = profession;
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
		this.familymembertype = familymembertype;
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
	public Integer getGardon() {
		return gardon;
	}
	public void setGardon(Integer gardon) {
		this.gardon = gardon;
	}
	public String getWorkunit() {
		return workunit;
	}
	public void setWorkunit(String workunit) {
		this.workunit = workunit;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(String isLocal) {
		this.isLocal = isLocal;
	}
	public String getBirthcertificatenumber() {
		return birthcertificatenumber;
	}
	public void setBirthcertificatenumber(String birthcertificatenumber) {
		this.birthcertificatenumber = birthcertificatenumber;
	}
	public String getRestaddress() {
		return restaddress;
	}
	public void setRestaddress(String restaddress) {
		this.restaddress = restaddress;
	}
	public String getIsPregnantwoman() {
		return isPregnantwoman;
	}
	public void setIsPregnantwoman(String isPregnantwoman) {
		this.isPregnantwoman = isPregnantwoman;
	}
	public String getIsBirth() {
		return isBirth;
	}
	public void setIsBirth(String isBirth) {
		this.isBirth = isBirth;
	}
	public Integer getMarryhistory() {
		return marryhistory;
	}
	public void setMarryhistory(Integer marryhistory) {
		this.marryhistory = marryhistory;
	}
	
	
}

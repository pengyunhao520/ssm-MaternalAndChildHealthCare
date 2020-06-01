package query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import domain.Education;
import domain.Nation;
import domain.SysArea;
import domain.SysCity;
import domain.SysProvince;
import domain.SysStreet;

public class PregnantWomanInformationQuery extends BaseQuery{
	//保健册号
    private String healthcode;
    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //出生日期
    private Date begintime;
    //出生日期
    private Date endtime;
    //职业
    private String profession;
    //工作单位
    private String workunit;
    //手机号
    private String phonenumber;
    //微信号
    private String wechat;
    //身份证号
    private String idnumber;
    //本地户口标示
    private String islocal;
    //生育证号
    private String birthcertificatenumber;
    //休养地址
    private String restaddress;
    //孕妇标示
    private String ispregnantwoman;
    //婚史
    private Integer marryhistory;
    

    //民族
    private Nation nation;
    //学历
    private Education education;

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

    //丈夫id
    private Integer husbandid;
    //丈夫姓名
    private String husbandname;
    //丈夫年龄
    private Integer husbandage;
    //丈夫电话号
    private String husbandphonenumber;
    //检查次数
    private Integer checkcount;
    //创建人
    private String establishperson;
    //检查时间
    private Date checktime;
    
    
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
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
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
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getIslocal() {
		return islocal;
	}
	public void setIslocal(String islocal) {
		this.islocal = islocal;
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
	public String getIspregnantwoman() {
		return ispregnantwoman;
	}
	public void setIspregnantwoman(String ispregnantwoman) {
		this.ispregnantwoman = ispregnantwoman;
	}
	public Integer getMarryhistory() {
		return marryhistory;
	}
	public void setMarryhistory(Integer marryhistory) {
		this.marryhistory = marryhistory;
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
	public String getGardon() {
		return gardon;
	}
	public void setGardon(String gardon) {
		this.gardon = gardon;
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
		this.husbandname = husbandname;
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
		this.husbandphonenumber = husbandphonenumber;
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
		this.establishperson = establishperson;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}

    
}

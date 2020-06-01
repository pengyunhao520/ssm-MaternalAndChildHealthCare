package query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PrenatalReviewRecordQuery extends BaseQuery{
	private Integer id;
    //身份证号
    private String preidnumber;
    //手机号
    private String prephonenumber;
    //姓名
    private String prename;
    //保健册号
    private String healthcode;
    //复查日期
    private Date reviewdate;
    //孕周
    private Integer gestationalweek;
    //收缩压
    private Integer systolicpressure;
    //舒张压
    private Integer diastolicpressure;
    //体重
    private Integer weight;
    //宫高
    private Integer fundalheight;
    //腹围
    private Integer abdominalcircumference;
    //胎位
    private Integer fetalposition;
    //胎先露
    private Integer fetalpresentation;
    //胎心
    private Integer fetalheart;
    //血糖
    private Float bloodsugar;
    //水肿
    private String edema;
    //尿蛋白
    private String urineprotein;
    //血色素
    private Float hemoglobin;
    //B超筛查
    private String bmode;
    //高危评定
    private String highriskevaluate;
    //预约日期
    private Date appointmentdate;
    //检查医生
    private String checkdoctor;
    //复查次数
    private Integer reviewcount;
    //复查问题描述
    private String reviewquestionsdescribe;
    //高危详情
    private String highriskdetails;
    
    private Date begintime;
    
    private Date endtime;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPreidnumber() {
		return preidnumber;
	}
	public void setPreidnumber(String preidnumber) {
		this.preidnumber = preidnumber;
	}
	public String getPrephonenumber() {
		return prephonenumber;
	}
	public void setPrephonenumber(String prephonenumber) {
		this.prephonenumber = prephonenumber;
	}
	public String getPrename() {
		return prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public String getHealthcode() {
		return healthcode;
	}
	public void setHealthcode(String healthcode) {
		this.healthcode = healthcode;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getReviewdate() {
		return reviewdate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	public Integer getGestationalweek() {
		return gestationalweek;
	}
	public void setGestationalweek(Integer gestationalweek) {
		this.gestationalweek = gestationalweek;
	}
	public Integer getSystolicpressure() {
		return systolicpressure;
	}
	public void setSystolicpressure(Integer systolicpressure) {
		this.systolicpressure = systolicpressure;
	}
	public Integer getDiastolicpressure() {
		return diastolicpressure;
	}
	public void setDiastolicpressure(Integer diastolicpressure) {
		this.diastolicpressure = diastolicpressure;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getFundalheight() {
		return fundalheight;
	}
	public void setFundalheight(Integer fundalheight) {
		this.fundalheight = fundalheight;
	}
	public Integer getAbdominalcircumference() {
		return abdominalcircumference;
	}
	public void setAbdominalcircumference(Integer abdominalcircumference) {
		this.abdominalcircumference = abdominalcircumference;
	}
	public Integer getFetalposition() {
		return fetalposition;
	}
	public void setFetalposition(Integer fetalposition) {
		this.fetalposition = fetalposition;
	}
	public Integer getFetalpresentation() {
		return fetalpresentation;
	}
	public void setFetalpresentation(Integer fetalpresentation) {
		this.fetalpresentation = fetalpresentation;
	}
	public Integer getFetalheart() {
		return fetalheart;
	}
	public void setFetalheart(Integer fetalheart) {
		this.fetalheart = fetalheart;
	}
	public Float getBloodsugar() {
		return bloodsugar;
	}
	public void setBloodsugar(Float bloodsugar) {
		this.bloodsugar = bloodsugar;
	}
	public String getEdema() {
		return edema;
	}
	public void setEdema(String edema) {
		this.edema = edema;
	}
	public String getUrineprotein() {
		return urineprotein;
	}
	public void setUrineprotein(String urineprotein) {
		this.urineprotein = urineprotein;
	}
	public Float getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(Float hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getBmode() {
		return bmode;
	}
	public void setBmode(String bmode) {
		this.bmode = bmode;
	}
	public String getHighriskevaluate() {
		return highriskevaluate;
	}
	public void setHighriskevaluate(String highriskevaluate) {
		this.highriskevaluate = highriskevaluate;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getAppointmentdate() {
		return appointmentdate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getCheckdoctor() {
		return checkdoctor;
	}
	public void setCheckdoctor(String checkdoctor) {
		this.checkdoctor = checkdoctor;
	}
	public Integer getReviewcount() {
		return reviewcount;
	}
	public void setReviewcount(Integer reviewcount) {
		this.reviewcount = reviewcount;
	}
	public String getReviewquestionsdescribe() {
		return reviewquestionsdescribe;
	}
	public void setReviewquestionsdescribe(String reviewquestionsdescribe) {
		this.reviewquestionsdescribe = reviewquestionsdescribe;
	}
	public String getHighriskdetails() {
		return highriskdetails;
	}
	public void setHighriskdetails(String highriskdetails) {
		this.highriskdetails = highriskdetails;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getBegintime() {
		return begintime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getEndtime() {
		return endtime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
    
}

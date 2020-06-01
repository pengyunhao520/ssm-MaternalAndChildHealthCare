package query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AntenatalInitialInspectionQuery extends BaseQuery{
	  private Integer id;
	    //保健册号
	    private String healthcode;
	    //孕妇idnumber
	    private String peidnumber;
	    //保健人姓名
	    private String prename;
	    //保健人手机号
	    private String prephonenumber;
	    //末次月经日期
	    private Date lastmenstruationdate;
	    //初检孕周
	    private Integer initialinspectionweek;
	    //预产期
	    private Date epectedchildbirthdate;
	    //孕次
	    private Integer pegnantcount;
	    //产次
	    private Integer productioncount;
	    //身高
	    private Integer height;
	    //体重
	    private Integer weight;
	    //收缩压
	    private Integer systolicpressure;
	    //舒张压
	    private Integer diastolicpressure;
	    //心脏
	    private String heart;
	    //肺部
	    private String lung;
	    //阴道炎
	    private String vaginitis;
	    //宫颈炎
	    private String cervicitis;
	    //双阴道双子宫
	    private String dublevaginaanduterus;
	    //子宫肌瘤
	    private String myomauterus;
	    //附件肿物
	    private String anexalmass;
	    //子宫大小与孕周相符
	    private String uterussizeationalweek;
	    //阴道出血
	    private String vaginalbleeding;
	    //剧吐
	    private String vomiting;
	    //发烧
	    private String fever;
	    //病毒性感染
	    private String viralinfection;
	    //孕前六个月内服用避孕药
	    private String acyeterion;
	    //尿蛋白
	    private String urineprotein;
	    //白带
	    private String leucorrhea;
	    //血糖
	    private String bloodsugar;
	    //弓形体
	    private String toxoplasma;
	    //甲胎蛋白
	    private String alphafetoprotein;
	    //巨细胞病毒
	    private String cytomegalovirus;
	    //GPTorALT
	    private String gptoralt;
	    //风疹病毒
	    private String rubellavirus;
	    //HBsAg
	    private String hbsag;
	    //梅毒
	    private String syphilis;
	    //血型
	    private String bloodtype;
	    //高危评定
	    private String highriskevaluate;
	    //髂前上棘间径
	    private Integer anteriorsuperiorspine;
	    //髂前间径
	    private Integer anterioriliac;
	    //骶耻外径
	    private Integer sacroiliacexternaldiameter;
	    //坐骨结节间径
	    private Integer sciatictubercle;
	    //检查日期
	    private Date checkdate;
	    //填表人
	    private String fillperson;
	    //录入人
	    private String inputperson;
	    //心脏详情
	    private String heartdetails;
	    //肺部详情
	    private String lungdetails;
	    //阴道炎详情
	    private String vaginitisdetails;
	    //宫颈炎详情
	    private String cervicitisdetails;
	    //双阴道双子宫详情
	    private String dublevaginaanduterusdetails;
	    //子宫肌瘤详情
	    private String myomauterusdetails;
	    //附件肿物详情
	    private String aexalmassdetails;
	    //子宫大小与孕周相符详情
	    private String uterussizeationalweekdetails;
	    //其他问题
	    private String otherquestions;
	    //其他检查详情
	    private String othercheckdetails;
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

	    public String getHealthcode() {
	        return healthcode;
	    }

	    public void setHealthcode(String healthcode) {
	        this.healthcode = healthcode == null ? null : healthcode.trim();
	    }

	    public String getPeidnumber() {
	        return peidnumber;
	    }

	    public void setPeidnumber(String peidnumber) {
	        this.peidnumber = peidnumber;
	    }

	    public String getPrename() {
	        return prename;
	    }

	    public void setPrename(String prename) {
	        this.prename = prename == null ? null : prename.trim();
	    }

	    public String getPrephonenumber() {
	        return prephonenumber;
	    }

	    public void setPrephonenumber(String prephonenumber) {
	        this.prephonenumber = prephonenumber;
	    }
	    
	    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	    public Date getLastmenstruationdate() {
	        return lastmenstruationdate;
	    }
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    public void setLastmenstruationdate(Date lastmenstruationdate) {
	        this.lastmenstruationdate = lastmenstruationdate;
	    }

	    public Integer getInitialinspectionweek() {
	        return initialinspectionweek;
	    }

	    public void setInitialinspectionweek(Integer initialinspectionweek) {
	        this.initialinspectionweek = initialinspectionweek;
	    }
	    
	    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	    public Date getEpectedchildbirthdate() {
	        return epectedchildbirthdate;
	    }
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    public void setEpectedchildbirthdate(Date epectedchildbirthdate) {
	        this.epectedchildbirthdate = epectedchildbirthdate;
	    }

	    public Integer getPegnantcount() {
	        return pegnantcount;
	    }

	    public void setPegnantcount(Integer pegnantcount) {
	        this.pegnantcount = pegnantcount;
	    }

	    public Integer getProductioncount() {
	        return productioncount;
	    }

	    public void setProductioncount(Integer productioncount) {
	        this.productioncount = productioncount;
	    }

	    public Integer getHeight() {
	        return height;
	    }

	    public void setHeight(Integer height) {
	        this.height = height;
	    }

	    public Integer getWeight() {
	        return weight;
	    }

	    public void setWeight(Integer weight) {
	        this.weight = weight;
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

	    public String getHeart() {
	        return heart;
	    }

	    public void setHeart(String heart) {
	        this.heart = heart == null ? null : heart.trim();
	    }

	    public String getLung() {
	        return lung;
	    }

	    public void setLung(String lung) {
	        this.lung = lung == null ? null : lung.trim();
	    }

	    public String getVaginitis() {
	        return vaginitis;
	    }

	    public void setVaginitis(String vaginitis) {
	        this.vaginitis = vaginitis == null ? null : vaginitis.trim();
	    }

	    public String getCervicitis() {
	        return cervicitis;
	    }

	    public void setCervicitis(String cervicitis) {
	        this.cervicitis = cervicitis == null ? null : cervicitis.trim();
	    }

	    public String getDublevaginaanduterus() {
	        return dublevaginaanduterus;
	    }

	    public void setDublevaginaanduterus(String dublevaginaanduterus) {
	        this.dublevaginaanduterus = dublevaginaanduterus == null ? null : dublevaginaanduterus.trim();
	    }

	    public String getMyomauterus() {
	        return myomauterus;
	    }

	    public void setMyomauterus(String myomauterus) {
	        this.myomauterus = myomauterus == null ? null : myomauterus.trim();
	    }

	    public String getAnexalmass() {
	        return anexalmass;
	    }

	    public void setAnexalmass(String anexalmass) {
	        this.anexalmass = anexalmass == null ? null : anexalmass.trim();
	    }

	    public String getUterussizeationalweek() {
	        return uterussizeationalweek;
	    }

	    public void setUterussizeationalweek(String uterussizeationalweek) {
	        this.uterussizeationalweek = uterussizeationalweek == null ? null : uterussizeationalweek.trim();
	    }

	    public String getVaginalbleeding() {
	        return vaginalbleeding;
	    }

	    public void setVaginalbleeding(String vaginalbleeding) {
	        this.vaginalbleeding = vaginalbleeding == null ? null : vaginalbleeding.trim();
	    }

	    public String getVomiting() {
	        return vomiting;
	    }

	    public void setVomiting(String vomiting) {
	        this.vomiting = vomiting == null ? null : vomiting.trim();
	    }

	    public String getFever() {
	        return fever;
	    }

	    public void setFever(String fever) {
	        this.fever = fever == null ? null : fever.trim();
	    }

	    public String getViralinfection() {
	        return viralinfection;
	    }

	    public void setViralinfection(String viralinfection) {
	        this.viralinfection = viralinfection == null ? null : viralinfection.trim();
	    }

	    public String getAcyeterion() {
	        return acyeterion;
	    }

	    public void setAcyeterion(String acyeterion) {
	        this.acyeterion = acyeterion == null ? null : acyeterion.trim();
	    }

	    public String getUrineprotein() {
	        return urineprotein;
	    }

	    public void setUrineprotein(String urineprotein) {
	        this.urineprotein = urineprotein == null ? null : urineprotein.trim();
	    }

	    public String getLeucorrhea() {
	        return leucorrhea;
	    }

	    public void setLeucorrhea(String leucorrhea) {
	        this.leucorrhea = leucorrhea == null ? null : leucorrhea.trim();
	    }

	    public String getBloodsugar() {
	        return bloodsugar;
	    }

	    public void setBloodsugar(String bloodsugar) {
	        this.bloodsugar = bloodsugar == null ? null : bloodsugar.trim();
	    }

	    public String getToxoplasma() {
	        return toxoplasma;
	    }

	    public void setToxoplasma(String toxoplasma) {
	        this.toxoplasma = toxoplasma == null ? null : toxoplasma.trim();
	    }

	    public String getAlphafetoprotein() {
	        return alphafetoprotein;
	    }

	    public void setAlphafetoprotein(String alphafetoprotein) {
	        this.alphafetoprotein = alphafetoprotein == null ? null : alphafetoprotein.trim();
	    }

	    public String getCytomegalovirus() {
	        return cytomegalovirus;
	    }

	    public void setCytomegalovirus(String cytomegalovirus) {
	        this.cytomegalovirus = cytomegalovirus == null ? null : cytomegalovirus.trim();
	    }

	    public String getGptoralt() {
	        return gptoralt;
	    }

	    public void setGptoralt(String gptoralt) {
	        this.gptoralt = gptoralt == null ? null : gptoralt.trim();
	    }

	    public String getRubellavirus() {
	        return rubellavirus;
	    }

	    public void setRubellavirus(String rubellavirus) {
	        this.rubellavirus = rubellavirus == null ? null : rubellavirus.trim();
	    }

	    public String getHbsag() {
	        return hbsag;
	    }

	    public void setHbsag(String hbsag) {
	        this.hbsag = hbsag == null ? null : hbsag.trim();
	    }

	    public String getSyphilis() {
	        return syphilis;
	    }

	    public void setSyphilis(String syphilis) {
	        this.syphilis = syphilis == null ? null : syphilis.trim();
	    }

	    public String getBloodtype() {
	        return bloodtype;
	    }

	    public void setBloodtype(String bloodtype) {
	        this.bloodtype = bloodtype == null ? null : bloodtype.trim();
	    }

	    public String getHighriskevaluate() {
	        return highriskevaluate;
	    }

	    public void setHighriskevaluate(String highriskevaluate) {
	        this.highriskevaluate = highriskevaluate == null ? null : highriskevaluate.trim();
	    }

	    public Integer getAnteriorsuperiorspine() {
	        return anteriorsuperiorspine;
	    }

	    public void setAnteriorsuperiorspine(Integer anteriorsuperiorspine) {
	        this.anteriorsuperiorspine = anteriorsuperiorspine;
	    }

	    public Integer getAnterioriliac() {
	        return anterioriliac;
	    }

	    public void setAnterioriliac(Integer anterioriliac) {
	        this.anterioriliac = anterioriliac;
	    }

	    public Integer getSacroiliacexternaldiameter() {
	        return sacroiliacexternaldiameter;
	    }

	    public void setSacroiliacexternaldiameter(Integer sacroiliacexternaldiameter) {
	        this.sacroiliacexternaldiameter = sacroiliacexternaldiameter;
	    }

	    public Integer getSciatictubercle() {
	        return sciatictubercle;
	    }

	    public void setSciatictubercle(Integer sciatictubercle) {
	        this.sciatictubercle = sciatictubercle;
	    }
	    
	    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	    public Date getCheckdate() {
	        return checkdate;
	    }
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    public void setCheckdate(Date checkdate) {
	        this.checkdate = checkdate;
	    }

	    public String getFillperson() {
	        return fillperson;
	    }

	    public void setFillperson(String fillperson) {
	        this.fillperson = fillperson == null ? null : fillperson.trim();
	    }

	    public String getInputperson() {
	        return inputperson;
	    }

	    public void setInputperson(String inputperson) {
	        this.inputperson = inputperson == null ? null : inputperson.trim();
	    }

	    public String getHeartdetails() {
	        return heartdetails;
	    }

	    public void setHeartdetails(String heartdetails) {
	        this.heartdetails = heartdetails == null ? null : heartdetails.trim();
	    }

	    public String getLungdetails() {
	        return lungdetails;
	    }

	    public void setLungdetails(String lungdetails) {
	        this.lungdetails = lungdetails == null ? null : lungdetails.trim();
	    }

	    public String getVaginitisdetails() {
	        return vaginitisdetails;
	    }

	    public void setVaginitisdetails(String vaginitisdetails) {
	        this.vaginitisdetails = vaginitisdetails == null ? null : vaginitisdetails.trim();
	    }

	    public String getCervicitisdetails() {
	        return cervicitisdetails;
	    }

	    public void setCervicitisdetails(String cervicitisdetails) {
	        this.cervicitisdetails = cervicitisdetails == null ? null : cervicitisdetails.trim();
	    }

	    public String getDublevaginaanduterusdetails() {
	        return dublevaginaanduterusdetails;
	    }

	    public void setDublevaginaanduterusdetails(String dublevaginaanduterusdetails) {
	        this.dublevaginaanduterusdetails = dublevaginaanduterusdetails == null ? null : dublevaginaanduterusdetails.trim();
	    }

	    public String getMyomauterusdetails() {
	        return myomauterusdetails;
	    }

	    public void setMyomauterusdetails(String myomauterusdetails) {
	        this.myomauterusdetails = myomauterusdetails == null ? null : myomauterusdetails.trim();
	    }

	    public String getAexalmassdetails() {
	        return aexalmassdetails;
	    }

	    public void setAexalmassdetails(String aexalmassdetails) {
	        this.aexalmassdetails = aexalmassdetails == null ? null : aexalmassdetails.trim();
	    }

	    public String getUterussizeationalweekdetails() {
	        return uterussizeationalweekdetails;
	    }

	    public void setUterussizeationalweekdetails(String uterussizeationalweekdetails) {
	        this.uterussizeationalweekdetails = uterussizeationalweekdetails == null ? null : uterussizeationalweekdetails.trim();
	    }

	    public String getOtherquestions() {
	        return otherquestions;
	    }

	    public void setOtherquestions(String otherquestions) {
	        this.otherquestions = otherquestions == null ? null : otherquestions.trim();
	    }

	    public String getOthercheckdetails() {
	        return othercheckdetails;
	    }

	    public void setOthercheckdetails(String othercheckdetails) {
	        this.othercheckdetails = othercheckdetails == null ? null : othercheckdetails.trim();
	    }

	    public String getHighriskdetails() {
	        return highriskdetails;
	    }

	    public void setHighriskdetails(String highriskdetails) {
	        this.highriskdetails = highriskdetails == null ? null : highriskdetails.trim();
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

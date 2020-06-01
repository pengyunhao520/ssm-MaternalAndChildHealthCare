package domain;

import java.util.Date;

public class NewbornSituation {
    private Integer id;
    //出生顺序
    private String birthorder;
    //胎儿娩出日期
    private Date birthdate;
    //Apga五分钟评分
    private String apgarfive;
    //出生缺陷
    private String birthdefect;
    //病理性黄疸
    private String pathologicjaundice;
    //呼吸窘迫综合症
    private String respiratorydistress;
    //分娩胎位
    private String deliveryposition;
    //分娩方式
    private String modeofdelivery;
    //肺炎
    private String pneumonia;
    //硬肿症
    private String scleroma;
    //产伤
    private String birthinjury;
    //性别
    private String sex;
    //缺氧缺血性脑病
    private String encephalopathyhie;
    //脐部感染
    private String umbilicalinfection;
    //外生殖器
    private String externalgenitalorgans;
    //败血症
    private String septicemia;
    //破伤风
    private String tetanus;
    //消化不良
    private String indigestion;
    //体重(g)
    private Double weight;
    //体长(cm)
    private Double height;
    //出生结局
    private String birthoutcomes;
    //新生儿存活
    private String neonatalsurvival;
    //死胎死产原因
    private String stillbirthcause;
    //新生儿死亡原因
    private String neonataldeathcause;
    //Apga一分钟评分
    private String apgaone;
    //母乳喂养
    private String breastfeeding;
    //新生儿疾病筛查
    private String neonatalscreening;
    //填表人
    private String filler;
    //录入人
    private String enter;
    //分娩胎位详情
    private String deliverypositiondetails;
    //分娩方式详情
    private String modeofdeliverydetails;
    //产伤详情
    private String birthinjurydetails;
    //出生结局详情
    private String birthoutcomesdetails;
    //死胎死产原因详情
    private String stillbirthcausedetails;
    //新生儿疾病筛查详情
    private String neonatalscreeningdetails;
    //保健指导
    private String healthguidance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBirthorder() {
        return birthorder;
    }

    public void setBirthorder(String birthorder) {
        this.birthorder = birthorder == null ? null : birthorder.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getApgarfive() {
        return apgarfive;
    }

    public void setApgarfive(String apgarfive) {
        this.apgarfive = apgarfive == null ? null : apgarfive.trim();
    }

    public String getBirthdefect() {
        return birthdefect;
    }

    public void setBirthdefect(String birthdefect) {
        this.birthdefect = birthdefect == null ? null : birthdefect.trim();
    }

    public String getPathologicjaundice() {
        return pathologicjaundice;
    }

    public void setPathologicjaundice(String pathologicjaundice) {
        this.pathologicjaundice = pathologicjaundice == null ? null : pathologicjaundice.trim();
    }

    public String getRespiratorydistress() {
        return respiratorydistress;
    }

    public void setRespiratorydistress(String respiratorydistress) {
        this.respiratorydistress = respiratorydistress == null ? null : respiratorydistress.trim();
    }

    public String getDeliveryposition() {
        return deliveryposition;
    }

    public void setDeliveryposition(String deliveryposition) {
        this.deliveryposition = deliveryposition == null ? null : deliveryposition.trim();
    }

    public String getModeofdelivery() {
        return modeofdelivery;
    }

    public void setModeofdelivery(String modeofdelivery) {
        this.modeofdelivery = modeofdelivery == null ? null : modeofdelivery.trim();
    }

    public String getPneumonia() {
        return pneumonia;
    }

    public void setPneumonia(String pneumonia) {
        this.pneumonia = pneumonia == null ? null : pneumonia.trim();
    }

    public String getScleroma() {
        return scleroma;
    }

    public void setScleroma(String scleroma) {
        this.scleroma = scleroma == null ? null : scleroma.trim();
    }

    public String getBirthinjury() {
        return birthinjury;
    }

    public void setBirthinjury(String birthinjury) {
        this.birthinjury = birthinjury == null ? null : birthinjury.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEncephalopathyhie() {
        return encephalopathyhie;
    }

    public void setEncephalopathyhie(String encephalopathyhie) {
        this.encephalopathyhie = encephalopathyhie == null ? null : encephalopathyhie.trim();
    }

    public String getUmbilicalinfection() {
        return umbilicalinfection;
    }

    public void setUmbilicalinfection(String umbilicalinfection) {
        this.umbilicalinfection = umbilicalinfection == null ? null : umbilicalinfection.trim();
    }

    public String getExternalgenitalorgans() {
        return externalgenitalorgans;
    }

    public void setExternalgenitalorgans(String externalgenitalorgans) {
        this.externalgenitalorgans = externalgenitalorgans == null ? null : externalgenitalorgans.trim();
    }

    public String getSepticemia() {
        return septicemia;
    }

    public void setSepticemia(String septicemia) {
        this.septicemia = septicemia == null ? null : septicemia.trim();
    }

    public String getTetanus() {
        return tetanus;
    }

    public void setTetanus(String tetanus) {
        this.tetanus = tetanus == null ? null : tetanus.trim();
    }

    public String getIndigestion() {
        return indigestion;
    }

    public void setIndigestion(String indigestion) {
        this.indigestion = indigestion == null ? null : indigestion.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getBirthoutcomes() {
        return birthoutcomes;
    }

    public void setBirthoutcomes(String birthoutcomes) {
        this.birthoutcomes = birthoutcomes == null ? null : birthoutcomes.trim();
    }

    public String getNeonatalsurvival() {
        return neonatalsurvival;
    }

    public void setNeonatalsurvival(String neonatalsurvival) {
        this.neonatalsurvival = neonatalsurvival == null ? null : neonatalsurvival.trim();
    }

    public String getStillbirthcause() {
        return stillbirthcause;
    }

    public void setStillbirthcause(String stillbirthcause) {
        this.stillbirthcause = stillbirthcause == null ? null : stillbirthcause.trim();
    }

    public String getNeonataldeathcause() {
        return neonataldeathcause;
    }

    public void setNeonataldeathcause(String neonataldeathcause) {
        this.neonataldeathcause = neonataldeathcause == null ? null : neonataldeathcause.trim();
    }

    public String getApgaone() {
        return apgaone;
    }

    public void setApgaone(String apgaone) {
        this.apgaone = apgaone == null ? null : apgaone.trim();
    }

    public String getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(String breastfeeding) {
        this.breastfeeding = breastfeeding == null ? null : breastfeeding.trim();
    }

    public String getNeonatalscreening() {
        return neonatalscreening;
    }

    public void setNeonatalscreening(String neonatalscreening) {
        this.neonatalscreening = neonatalscreening == null ? null : neonatalscreening.trim();
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
    }

    public String getEnter() {
        return enter;
    }

    public void setEnter(String enter) {
        this.enter = enter == null ? null : enter.trim();
    }

    public String getDeliverypositiondetails() {
        return deliverypositiondetails;
    }

    public void setDeliverypositiondetails(String deliverypositiondetails) {
        this.deliverypositiondetails = deliverypositiondetails == null ? null : deliverypositiondetails.trim();
    }

    public String getModeofdeliverydetails() {
        return modeofdeliverydetails;
    }

    public void setModeofdeliverydetails(String modeofdeliverydetails) {
        this.modeofdeliverydetails = modeofdeliverydetails == null ? null : modeofdeliverydetails.trim();
    }

    public String getBirthinjurydetails() {
        return birthinjurydetails;
    }

    public void setBirthinjurydetails(String birthinjurydetails) {
        this.birthinjurydetails = birthinjurydetails == null ? null : birthinjurydetails.trim();
    }

    public String getBirthoutcomesdetails() {
        return birthoutcomesdetails;
    }

    public void setBirthoutcomesdetails(String birthoutcomesdetails) {
        this.birthoutcomesdetails = birthoutcomesdetails == null ? null : birthoutcomesdetails.trim();
    }

    public String getStillbirthcausedetails() {
        return stillbirthcausedetails;
    }

    public void setStillbirthcausedetails(String stillbirthcausedetails) {
        this.stillbirthcausedetails = stillbirthcausedetails == null ? null : stillbirthcausedetails.trim();
    }

    public String getNeonatalscreeningdetails() {
        return neonatalscreeningdetails;
    }

    public void setNeonatalscreeningdetails(String neonatalscreeningdetails) {
        this.neonatalscreeningdetails = neonatalscreeningdetails == null ? null : neonatalscreeningdetails.trim();
    }

    public String getHealthguidance() {
        return healthguidance;
    }

    public void setHealthguidance(String healthguidance) {
        this.healthguidance = healthguidance == null ? null : healthguidance.trim();
    }

	@Override
	public String toString() {
		return "NewbornSituation [id=" + id + ", birthorder=" + birthorder + ", birthdate=" + birthdate + ", apgarfive="
				+ apgarfive + ", birthdefect=" + birthdefect + ", pathologicjaundice=" + pathologicjaundice
				+ ", respiratorydistress=" + respiratorydistress + ", deliveryposition=" + deliveryposition
				+ ", modeofdelivery=" + modeofdelivery + ", pneumonia=" + pneumonia + ", scleroma=" + scleroma
				+ ", birthinjury=" + birthinjury + ", sex=" + sex + ", encephalopathyhie=" + encephalopathyhie
				+ ", umbilicalinfection=" + umbilicalinfection + ", externalgenitalorgans=" + externalgenitalorgans
				+ ", septicemia=" + septicemia + ", tetanus=" + tetanus + ", indigestion=" + indigestion + ", weight="
				+ weight + ", height=" + height + ", birthoutcomes=" + birthoutcomes + ", neonatalsurvival="
				+ neonatalsurvival + ", stillbirthcause=" + stillbirthcause + ", neonataldeathcause="
				+ neonataldeathcause + ", apgaone=" + apgaone + ", breastfeeding=" + breastfeeding
				+ ", neonatalscreening=" + neonatalscreening + ", filler=" + filler + ", enter=" + enter
				+ ", deliverypositiondetails=" + deliverypositiondetails + ", modeofdeliverydetails="
				+ modeofdeliverydetails + ", birthinjurydetails=" + birthinjurydetails + ", birthoutcomesdetails="
				+ birthoutcomesdetails + ", stillbirthcausedetails=" + stillbirthcausedetails
				+ ", neonatalscreeningdetails=" + neonatalscreeningdetails + ", healthguidance=" + healthguidance
				+ ", getId()=" + getId() + ", getBirthorder()=" + getBirthorder() + ", getBirthdate()=" + getBirthdate()
				+ ", getApgarfive()=" + getApgarfive() + ", getBirthdefect()=" + getBirthdefect()
				+ ", getPathologicjaundice()=" + getPathologicjaundice() + ", getRespiratorydistress()="
				+ getRespiratorydistress() + ", getDeliveryposition()=" + getDeliveryposition()
				+ ", getModeofdelivery()=" + getModeofdelivery() + ", getPneumonia()=" + getPneumonia()
				+ ", getScleroma()=" + getScleroma() + ", getBirthinjury()=" + getBirthinjury() + ", getSex()="
				+ getSex() + ", getEncephalopathyhie()=" + getEncephalopathyhie() + ", getUmbilicalinfection()="
				+ getUmbilicalinfection() + ", getExternalgenitalorgans()=" + getExternalgenitalorgans()
				+ ", getSepticemia()=" + getSepticemia() + ", getTetanus()=" + getTetanus() + ", getIndigestion()="
				+ getIndigestion() + ", getWeight()=" + getWeight() + ", getHeight()=" + getHeight()
				+ ", getBirthoutcomes()=" + getBirthoutcomes() + ", getNeonatalsurvival()=" + getNeonatalsurvival()
				+ ", getStillbirthcause()=" + getStillbirthcause() + ", getNeonataldeathcause()="
				+ getNeonataldeathcause() + ", getApgaone()=" + getApgaone() + ", getBreastfeeding()="
				+ getBreastfeeding() + ", getNeonatalscreening()=" + getNeonatalscreening() + ", getFiller()="
				+ getFiller() + ", getEnter()=" + getEnter() + ", getDeliverypositiondetails()="
				+ getDeliverypositiondetails() + ", getModeofdeliverydetails()=" + getModeofdeliverydetails()
				+ ", getBirthinjurydetails()=" + getBirthinjurydetails() + ", getBirthoutcomesdetails()="
				+ getBirthoutcomesdetails() + ", getStillbirthcausedetails()=" + getStillbirthcausedetails()
				+ ", getNeonatalscreeningdetails()=" + getNeonatalscreeningdetails() + ", getHealthguidance()="
				+ getHealthguidance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
    
}
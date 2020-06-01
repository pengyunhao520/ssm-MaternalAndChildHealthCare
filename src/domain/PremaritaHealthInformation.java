package domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PremaritaHealthInformation {
	//id主键
	private Integer id;
    //保健人id
    private String preidnumber;
    //保健人姓名
	private String prename;
    //婚检日期
    private Date premaritalexaminationdate;
    //婚检地点
    private String premaritalexaminationaddress;
    //与配偶血缘关系
    private String consanguinity;
    //既往病史
    private String medicalhistory;
    //现病史
    private String nowmedicalhistory;
    //初潮年龄
    private Integer menarcheage;
    //经期周期(天)
    private Integer menstrualcycle;
    //amount
    private Integer amount;
    //既往婚育史
    private String pastmarriagehistory;
    //家族遗传史
    private String familygenetichistory;
    //家族近亲婚配
    private String familymarriage;
    //特殊体态
    private String specialposture;
    //精神状态
    private String mentaloutlook;
    //特殊面容
    private String specialface;
    //智力
    private String intelligence;
    //皮肤毛发
    private String skinhair;
    //肺
    private String lung;
    //肝
    private String liver;
    //四肢脊柱
    private String limbsspine;
    //阴毛
    private String pubichair;
    //乳房
    private String breast;
    //生殖器
    private String genitals;
    //阴道检查
    private String vaginalexamination;
    //实验室检查
    private String laboratoryexamination;
    //婚检结果
    private String premaritalexamination;
    //医学意见
    private String medicaladvice;
    //咨询指导
    private String consultationguidance;
    //叶酸开始日期
    private Date folicbegintime;
    //叶酸结束日期
    private Date folicdetailsendtime;
    //碘丸开始日期
    private Date iodinepillsbegintime;
    //碘丸用量/次(粒)
    private Integer iodinepillsdosage;
    //与配偶血缘关系详情
    private String consanguinitydetails;
    //既往病史详情
    private String medicalhistorydetails;
    //现病史详情
    private String nowmedicalhistorydetails;
    //初潮年龄详情
    private String menarcheagedetails;
    //经期周期详情
    private String menstrualcycledetails;
    //量详情
    private String amountdetails;
    //既往婚育史详情
    private String pastmarriagehistorydetails;
    //家族遗传史详情
    private String familygenetichistorydetails;
    //家族近亲婚配详情
    private String familymarriagedetails;
    //特殊体态详情
    private String specialposturedetails;
    //精神状态详情
    private String mentaloutlookdetails;
    //特殊面容详情
    private String specialfacedetails;
    //智力详情
    private String intelligencedetails;
    //皮肤毛发详情
    private String skinhairdetails;
    //肺详情
    private String lungdetails;
    //肝详情
    private String liverdetails;
    //四肢脊柱详情
    private String limbsspinedetails;
    //阴毛详情
    private String pubichairdetails;
    //乳房详情
    private String breastdetails;
    //生殖器详情
    private String genitalsdetails;
    //阴道检查详情
    private String vaginalexaminationdetails;
    //实验室检查详情
    private String laboratoryexaminationdetails;
    //婚检结果详情
    private String premaritalexaminationdetails;
    //医学意见详情
    private String medicaladvicedetails;
    //咨询指导详情
    private String consultationguidancedetails;

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
        this.preidnumber = preidnumber == null ? null : preidnumber.trim();
    }
    
	public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename == null ? null : prename.trim();
    }
	
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getPremaritalexaminationdate() {
        return premaritalexaminationdate;
    }
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setPremaritalexaminationdate(Date premaritalexaminationdate) {
        this.premaritalexaminationdate = premaritalexaminationdate;
    }

    public String getPremaritalexaminationaddress() {
        return premaritalexaminationaddress;
    }

    public void setPremaritalexaminationaddress(String premaritalexaminationaddress) {
        this.premaritalexaminationaddress = premaritalexaminationaddress == null ? null : premaritalexaminationaddress.trim();
    }

    public String getConsanguinity() {
        return consanguinity;
    }

    public void setConsanguinity(String consanguinity) {
        this.consanguinity = consanguinity == null ? null : consanguinity.trim();
    }

    public String getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(String medicalhistory) {
        this.medicalhistory = medicalhistory == null ? null : medicalhistory.trim();
    }

    public String getNowmedicalhistory() {
        return nowmedicalhistory;
    }

    public void setNowmedicalhistory(String nowmedicalhistory) {
        this.nowmedicalhistory = nowmedicalhistory == null ? null : nowmedicalhistory.trim();
    }

    public Integer getMenarcheage() {
        return menarcheage;
    }

    public void setMenarcheage(Integer menarcheage) {
        this.menarcheage = menarcheage;
    }

    public Integer getMenstrualcycle() {
        return menstrualcycle;
    }

    public void setMenstrualcycle(Integer menstrualcycle) {
        this.menstrualcycle = menstrualcycle;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPastmarriagehistory() {
        return pastmarriagehistory;
    }

    public void setPastmarriagehistory(String pastmarriagehistory) {
        this.pastmarriagehistory = pastmarriagehistory == null ? null : pastmarriagehistory.trim();
    }

    public String getFamilygenetichistory() {
        return familygenetichistory;
    }

    public void setFamilygenetichistory(String familygenetichistory) {
        this.familygenetichistory = familygenetichistory == null ? null : familygenetichistory.trim();
    }

    public String getFamilymarriage() {
        return familymarriage;
    }

    public void setFamilymarriage(String familymarriage) {
        this.familymarriage = familymarriage == null ? null : familymarriage.trim();
    }

    public String getSpecialposture() {
        return specialposture;
    }

    public void setSpecialposture(String specialposture) {
        this.specialposture = specialposture == null ? null : specialposture.trim();
    }

    public String getMentaloutlook() {
        return mentaloutlook;
    }

    public void setMentaloutlook(String mentaloutlook) {
        this.mentaloutlook = mentaloutlook == null ? null : mentaloutlook.trim();
    }

    public String getSpecialface() {
        return specialface;
    }

    public void setSpecialface(String specialface) {
        this.specialface = specialface == null ? null : specialface.trim();
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence == null ? null : intelligence.trim();
    }

    public String getSkinhair() {
        return skinhair;
    }

    public void setSkinhair(String skinhair) {
        this.skinhair = skinhair == null ? null : skinhair.trim();
    }

    public String getLung() {
        return lung;
    }

    public void setLung(String lung) {
        this.lung = lung == null ? null : lung.trim();
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver == null ? null : liver.trim();
    }

    public String getLimbsspine() {
        return limbsspine;
    }

    public void setLimbsspine(String limbsspine) {
        this.limbsspine = limbsspine == null ? null : limbsspine.trim();
    }

    public String getPubichair() {
        return pubichair;
    }

    public void setPubichair(String pubichair) {
        this.pubichair = pubichair == null ? null : pubichair.trim();
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast == null ? null : breast.trim();
    }

    public String getGenitals() {
        return genitals;
    }

    public void setGenitals(String genitals) {
        this.genitals = genitals == null ? null : genitals.trim();
    }

    public String getVaginalexamination() {
        return vaginalexamination;
    }

    public void setVaginalexamination(String vaginalexamination) {
        this.vaginalexamination = vaginalexamination == null ? null : vaginalexamination.trim();
    }

    public String getLaboratoryexamination() {
        return laboratoryexamination;
    }

    public void setLaboratoryexamination(String laboratoryexamination) {
        this.laboratoryexamination = laboratoryexamination == null ? null : laboratoryexamination.trim();
    }

    public String getPremaritalexamination() {
        return premaritalexamination;
    }

    public void setPremaritalexamination(String premaritalexamination) {
        this.premaritalexamination = premaritalexamination == null ? null : premaritalexamination.trim();
    }

    public String getMedicaladvice() {
        return medicaladvice;
    }

    public void setMedicaladvice(String medicaladvice) {
        this.medicaladvice = medicaladvice == null ? null : medicaladvice.trim();
    }

    public String getConsultationguidance() {
        return consultationguidance;
    }

    public void setConsultationguidance(String consultationguidance) {
        this.consultationguidance = consultationguidance == null ? null : consultationguidance.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getFolicbegintime() {
        return folicbegintime;
    }
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setFolicbegintime(Date folicbegintime) {
        this.folicbegintime = folicbegintime;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getFolicdetailsendtime() {
        return folicdetailsendtime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setFolicdetailsendtime(Date folicdetailsendtime) {
        this.folicdetailsendtime = folicdetailsendtime;
    }
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getIodinepillsbegintime() {
        return iodinepillsbegintime;
    }
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setIodinepillsbegintime(Date iodinepillsbegintime) {
        this.iodinepillsbegintime = iodinepillsbegintime;
    }

    public Integer getIodinepillsdosage() {
        return iodinepillsdosage;
    }

    public void setIodinepillsdosage(Integer iodinepillsdosage) {
        this.iodinepillsdosage = iodinepillsdosage;
    }

    public String getConsanguinitydetails() {
        return consanguinitydetails;
    }

    public void setConsanguinitydetails(String consanguinitydetails) {
        this.consanguinitydetails = consanguinitydetails == null ? null : consanguinitydetails.trim();
    }

    public String getMedicalhistorydetails() {
        return medicalhistorydetails;
    }

    public void setMedicalhistorydetails(String medicalhistorydetails) {
        this.medicalhistorydetails = medicalhistorydetails == null ? null : medicalhistorydetails.trim();
    }

    public String getNowmedicalhistorydetails() {
        return nowmedicalhistorydetails;
    }

    public void setNowmedicalhistorydetails(String nowmedicalhistorydetails) {
        this.nowmedicalhistorydetails = nowmedicalhistorydetails == null ? null : nowmedicalhistorydetails.trim();
    }

    public String getMenarcheagedetails() {
        return menarcheagedetails;
    }

    public void setMenarcheagedetails(String menarcheagedetails) {
        this.menarcheagedetails = menarcheagedetails == null ? null : menarcheagedetails.trim();
    }

    public String getMenstrualcycledetails() {
        return menstrualcycledetails;
    }

    public void setMenstrualcycledetails(String menstrualcycledetails) {
        this.menstrualcycledetails = menstrualcycledetails == null ? null : menstrualcycledetails.trim();
    }

    public String getAmountdetails() {
        return amountdetails;
    }

    public void setAmountdetails(String amountdetails) {
        this.amountdetails = amountdetails == null ? null : amountdetails.trim();
    }

    public String getPastmarriagehistorydetails() {
        return pastmarriagehistorydetails;
    }

    public void setPastmarriagehistorydetails(String pastmarriagehistorydetails) {
        this.pastmarriagehistorydetails = pastmarriagehistorydetails == null ? null : pastmarriagehistorydetails.trim();
    }

    public String getFamilygenetichistorydetails() {
        return familygenetichistorydetails;
    }

    public void setFamilygenetichistorydetails(String familygenetichistorydetails) {
        this.familygenetichistorydetails = familygenetichistorydetails == null ? null : familygenetichistorydetails.trim();
    }

    public String getFamilymarriagedetails() {
        return familymarriagedetails;
    }

    public void setFamilymarriagedetails(String familymarriagedetails) {
        this.familymarriagedetails = familymarriagedetails == null ? null : familymarriagedetails.trim();
    }

    public String getSpecialposturedetails() {
        return specialposturedetails;
    }

    public void setSpecialposturedetails(String specialposturedetails) {
        this.specialposturedetails = specialposturedetails == null ? null : specialposturedetails.trim();
    }

    public String getMentaloutlookdetails() {
        return mentaloutlookdetails;
    }

    public void setMentaloutlookdetails(String mentaloutlookdetails) {
        this.mentaloutlookdetails = mentaloutlookdetails == null ? null : mentaloutlookdetails.trim();
    }

    public String getSpecialfacedetails() {
        return specialfacedetails;
    }

    public void setSpecialfacedetails(String specialfacedetails) {
        this.specialfacedetails = specialfacedetails == null ? null : specialfacedetails.trim();
    }

    public String getIntelligencedetails() {
        return intelligencedetails;
    }

    public void setIntelligencedetails(String intelligencedetails) {
        this.intelligencedetails = intelligencedetails == null ? null : intelligencedetails.trim();
    }

    public String getSkinhairdetails() {
        return skinhairdetails;
    }

    public void setSkinhairdetails(String skinhairdetails) {
        this.skinhairdetails = skinhairdetails == null ? null : skinhairdetails.trim();
    }

    public String getLungdetails() {
        return lungdetails;
    }

    public void setLungdetails(String lungdetails) {
        this.lungdetails = lungdetails == null ? null : lungdetails.trim();
    }

    public String getLiverdetails() {
        return liverdetails;
    }

    public void setLiverdetails(String liverdetails) {
        this.liverdetails = liverdetails == null ? null : liverdetails.trim();
    }

    public String getLimbsspinedetails() {
        return limbsspinedetails;
    }

    public void setLimbsspinedetails(String limbsspinedetails) {
        this.limbsspinedetails = limbsspinedetails == null ? null : limbsspinedetails.trim();
    }

    public String getPubichairdetails() {
        return pubichairdetails;
    }

    public void setPubichairdetails(String pubichairdetails) {
        this.pubichairdetails = pubichairdetails == null ? null : pubichairdetails.trim();
    }

    public String getBreastdetails() {
        return breastdetails;
    }

    public void setBreastdetails(String breastdetails) {
        this.breastdetails = breastdetails == null ? null : breastdetails.trim();
    }

    public String getGenitalsdetails() {
        return genitalsdetails;
    }

    public void setGenitalsdetails(String genitalsdetails) {
        this.genitalsdetails = genitalsdetails == null ? null : genitalsdetails.trim();
    }

    public String getVaginalexaminationdetails() {
        return vaginalexaminationdetails;
    }

    public void setVaginalexaminationdetails(String vaginalexaminationdetails) {
        this.vaginalexaminationdetails = vaginalexaminationdetails == null ? null : vaginalexaminationdetails.trim();
    }

    public String getLaboratoryexaminationdetails() {
        return laboratoryexaminationdetails;
    }

    public void setLaboratoryexaminationdetails(String laboratoryexaminationdetails) {
        this.laboratoryexaminationdetails = laboratoryexaminationdetails == null ? null : laboratoryexaminationdetails.trim();
    }

    public String getPremaritalexaminationdetails() {
        return premaritalexaminationdetails;
    }

    public void setPremaritalexaminationdetails(String premaritalexaminationdetails) {
        this.premaritalexaminationdetails = premaritalexaminationdetails == null ? null : premaritalexaminationdetails.trim();
    }

    public String getMedicaladvicedetails() {
        return medicaladvicedetails;
    }

    public void setMedicaladvicedetails(String medicaladvicedetails) {
        this.medicaladvicedetails = medicaladvicedetails == null ? null : medicaladvicedetails.trim();
    }

    public String getConsultationguidancedetails() {
        return consultationguidancedetails;
    }

    public void setConsultationguidancedetails(String consultationguidancedetails) {
        this.consultationguidancedetails = consultationguidancedetails == null ? null : consultationguidancedetails.trim();
    }
}
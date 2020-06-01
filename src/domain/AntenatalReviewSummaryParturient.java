package domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AntenatalReviewSummaryParturient {
    private Integer id;
    //产前复查总数
    private Integer previewcount;
    //妊高征
    private DictionaryDetails ppih;
    //前置胎盘
    private DictionaryDetails placentaprevia;
    //胎盘早剥
    private DictionaryDetails placentalabruption;
    //胎位
    private DictionaryDetails fetalposition;
    //多胎
    private String multiplebirth;
    //羊水
    private String amnioticfluid;
    //骨盆狭窄
    private String pelvicstenosis;
    //胎儿发育迟缓
    private String developmentaldelay;
    //胎儿窘迫
    private String fetaldistress;
    //心脏病
    private DictionaryDetails heartdisease;
    //病毒性肝炎
    private DictionaryDetails viralhepatitis;
    //尿蛋白
    private String purineprotein;
    //血红蛋白
    private Float hemoglobin;
    //高危评定
    private String phighriskevaluate;
    //高危变化
    private DictionaryDetails phighriskchange;
    //总结日期
    private Date summarydate;
    //填表人
    private String fillperson;
    //录入人
    private String inputperson;
    //补充说明
    private String additionalremarks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpreviewcount() {
		return previewcount;
	}
	public void setpreviewcount(Integer previewcount) {
		this.previewcount = previewcount;
	}
	public DictionaryDetails getppih() {
		return ppih;
	}
	public void setppih(DictionaryDetails ppih) {
		this.ppih = ppih;
	}
	public DictionaryDetails getPlacentaprevia() {
		return placentaprevia;
	}
	public void setPlacentaprevia(DictionaryDetails placentaprevia) {
		this.placentaprevia = placentaprevia;
	}
	public DictionaryDetails getPlacentalabruption() {
		return placentalabruption;
	}
	public void setPlacentalabruption(DictionaryDetails placentalabruption) {
		this.placentalabruption = placentalabruption;
	}
	public DictionaryDetails getFetalposition() {
		return fetalposition;
	}
	public void setFetalposition(DictionaryDetails fetalposition) {
		this.fetalposition = fetalposition;
	}
	public String getMultiplebirth() {
		return multiplebirth;
	}
	public void setMultiplebirth(String multiplebirth) {
		this.multiplebirth = multiplebirth;
	}
	public String getAmnioticfluid() {
		return amnioticfluid;
	}
	public void setAmnioticfluid(String amnioticfluid) {
		this.amnioticfluid = amnioticfluid;
	}
	public String getPelvicstenosis() {
		return pelvicstenosis;
	}
	public void setPelvicstenosis(String pelvicstenosis) {
		this.pelvicstenosis = pelvicstenosis;
	}
	public String getDevelopmentaldelay() {
		return developmentaldelay;
	}
	public void setDevelopmentaldelay(String developmentaldelay) {
		this.developmentaldelay = developmentaldelay;
	}
	public String getFetaldistress() {
		return fetaldistress;
	}
	public void setFetaldistress(String fetaldistress) {
		this.fetaldistress = fetaldistress;
	}
	public DictionaryDetails getHeartdisease() {
		return heartdisease;
	}
	public void setHeartdisease(DictionaryDetails heartdisease) {
		this.heartdisease = heartdisease;
	}
	public DictionaryDetails getViralhepatitis() {
		return viralhepatitis;
	}
	public void setViralhepatitis(DictionaryDetails viralhepatitis) {
		this.viralhepatitis = viralhepatitis;
	}
	public String getpurineprotein() {
		return purineprotein;
	}
	public void setpurineprotein(String purineprotein) {
		this.purineprotein = purineprotein;
	}
	public Float getHemoglobin() {
		return hemoglobin;
	}
	public void setHemoglobin(Float hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getphighriskevaluate() {
		return phighriskevaluate;
	}
	public void setphighriskevaluate(String phighriskevaluate) {
		this.phighriskevaluate = phighriskevaluate;
	}
	public DictionaryDetails getphighriskchange() {
		return phighriskchange;
	}
	public void setphighriskchange(DictionaryDetails phighriskchange) {
		this.phighriskchange = phighriskchange;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getSummarydate() {
		return summarydate;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setSummarydate(Date summarydate) {
		this.summarydate = summarydate;
	}
	public String getFillperson() {
		return fillperson;
	}
	public void setFillperson(String fillperson) {
		this.fillperson = fillperson;
	}
	public String getInputperson() {
		return inputperson;
	}
	public void setInputperson(String inputperson) {
		this.inputperson = inputperson;
	}
	public String getAdditionalremarks() {
		return additionalremarks;
	}
	public void setAdditionalremarks(String additionalremarks) {
		this.additionalremarks = additionalremarks;
	}
	@Override
	public String toString() {
		return "AntenatalReviewSummaryParturient [id=" + id + ", previewcount=" + previewcount + ", ppih=" + ppih
				+ ", placentaprevia=" + placentaprevia + ", placentalabruption=" + placentalabruption
				+ ", fetalposition=" + fetalposition + ", multiplebirth=" + multiplebirth + ", amnioticfluid="
				+ amnioticfluid + ", pelvicstenosis=" + pelvicstenosis + ", developmentaldelay=" + developmentaldelay
				+ ", fetaldistress=" + fetaldistress + ", heartdisease=" + heartdisease + ", viralhepatitis="
				+ viralhepatitis + ", purineprotein=" + purineprotein + ", hemoglobin=" + hemoglobin
				+ ", phighriskevaluate=" + phighriskevaluate + ", phighriskchange=" + phighriskchange + ", summarydate="
				+ summarydate + ", fillperson=" + fillperson + ", inputperson=" + inputperson + ", additionalremarks="
				+ additionalremarks + "]";
	}

    
}
package domain;

public class AntenatalReviewSummary {
    private Integer id;
    //身份证号
    private String preidnumber;
    //姓名
    private String prename;
    //手机号
    private String prephonenumber;
    //保健册号
    private String healthcode;
    //产前复查总数
    private Integer reviewcount;
    //阴道出血
    private String vaginalbleeding;
    //妊高征
    private DictionaryDetails pih;
    //尿蛋白
    private String urineprotein;
    //B超筛查
    private String bmode;
    //高危因素
    private DictionaryDetails highriskfactor;
    //高危评定
    private String highriskevaluate;
    //高危变化
    private DictionaryDetails highriskchange;
    //28周-临产复查总结
    private AntenatalReviewSummaryParturient antenatalReviewSummaryParturient;
    
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
	public String getPrename() {
		return prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public String getPrephonenumber() {
		return prephonenumber;
	}
	public void setPrephonenumber(String prephonenumber) {
		this.prephonenumber = prephonenumber;
	}
	public String getHealthcode() {
		return healthcode;
	}
	public void setHealthcode(String healthcode) {
		this.healthcode = healthcode;
	}
	public Integer getReviewcount() {
		return reviewcount;
	}
	public void setReviewcount(Integer reviewcount) {
		this.reviewcount = reviewcount;
	}
	public String getVaginalbleeding() {
		return vaginalbleeding;
	}
	public void setVaginalbleeding(String vaginalbleeding) {
		this.vaginalbleeding = vaginalbleeding;
	}
	public DictionaryDetails getPih() {
		return pih;
	}
	public void setPih(DictionaryDetails pih) {
		this.pih = pih;
	}
	public String getUrineprotein() {
		return urineprotein;
	}
	public void setUrineprotein(String urineprotein) {
		this.urineprotein = urineprotein;
	}
	public String getBmode() {
		return bmode;
	}
	public void setBmode(String bmode) {
		this.bmode = bmode;
	}
	public DictionaryDetails getHighriskfactor() {
		return highriskfactor;
	}
	public void setHighriskfactor(DictionaryDetails highriskfactor) {
		this.highriskfactor = highriskfactor;
	}
	public String getHighriskevaluate() {
		return highriskevaluate;
	}
	public void setHighriskevaluate(String highriskevaluate) {
		this.highriskevaluate = highriskevaluate;
	}
	public DictionaryDetails getHighriskchange() {
		return highriskchange;
	}
	public void setHighriskchange(DictionaryDetails highriskchange) {
		this.highriskchange = highriskchange;
	}
	
	public AntenatalReviewSummaryParturient getAntenatalReviewSummaryParturient() {
		return antenatalReviewSummaryParturient;
	}
	public void setAntenatalReviewSummaryParturient(AntenatalReviewSummaryParturient antenatalReviewSummaryParturient) {
		this.antenatalReviewSummaryParturient = antenatalReviewSummaryParturient;
	}
	@Override
	public String toString() {
		return "AntenatalReviewSummary [id=" + id + ", preidnumber=" + preidnumber + ", prename=" + prename
				+ ", prephonenumber=" + prephonenumber + ", healthcode=" + healthcode + ", reviewcount=" + reviewcount
				+ ", vaginalbleeding=" + vaginalbleeding + ", pih=" + pih + ", urineprotein=" + urineprotein
				+ ", bmode=" + bmode + ", highriskfactor=" + highriskfactor + ", highriskevaluate=" + highriskevaluate
				+ ", highriskchange=" + highriskchange + ", antenatalReviewSummaryParturient="
				+ antenatalReviewSummaryParturient + "]";
	}

    
}
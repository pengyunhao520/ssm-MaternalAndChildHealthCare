package domain;

public class AbnormalMaternalHistory {
    private Integer id;
    //孕妇身份证号
    private String prewomanid;
    //自然流产
    private Integer spontaneousabortion;
    //人工流产
    private Integer artificialabortion;
    //葡萄胎
    private Integer hydatidiformmole;
    //死胎死产
    private Integer stillbornfoetus;
    //生育畸形
    private Integer birthmalformation;
    //早产
    private Integer prematurebirth;
    //药流
    private Integer medicalabortion;
    //引产
    private Integer inducedlabor;
    //难产
    private Integer difficultlabour;
    //宫外孕
    private Integer extrauterinepregnancy;
    //心脏病
    private String heartdisease;
    //结核
    private String tuberculosis;
    //肾病
    private String nephropathy;
    //血液病
    private String hematopathy;
    //甲亢
    private String hyperthyroidism;
    //接触有害物质
    private String harmfulsubstance;
    //肝病
    private String hepatopathy;
    //高血压
    private String hypertension;
    //糖尿病
    private String diabetes;
    //其他疾病
    private String otherdiseases;
    //自然流产详情
    private String spontaneousabortiondescribe;
    //人工流产详情
    private String artificialabortiondescribe;
    //葡萄胎详情
    private String hydatidiformmoledescribe;
    //死胎死产详情
    private String stillbornfoetusdescribe;
    //生育畸形
    private String birthmalformationdescribe;
    //早产
    private String prematurebirthdescribe;
    //药流
    private String medicalabortiondescribe;
    //引产详情
    private String inducedlabordescribe;
    //难产详情
    private String difficultlabourdescribe;
    //宫外孕详情
    private String extrauterinepregnancydescribe;
    //心脏病详情
    private String heartdiseasedescribe;
    //结核详情
    private String tuberculosisdescribe;
    //肾病详情
    private String nephropathydescribe;
    //血液病详情
    private String hematopathydescribe;
    //甲亢详情
    private String hyperthyroidismdescribe;
    //接触有害物质详情
    private String harmfulsubstancedescribe;
    //肝病详情
    private String hepatopathydescribe;
    //高血压详情
    private String hypertensiondescribe;
    //糖尿病详情
    private String diabetesdescribe;
    //其他疾病详情
    private String otherdiseasesdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrewomanid() {
        return prewomanid;
    }

    public void setPrewomanid(String prewomanid) {
        this.prewomanid = prewomanid == null ? null : prewomanid.trim();
    }

    public Integer getSpontaneousabortion() {
        return spontaneousabortion;
    }

    public void setSpontaneousabortion(Integer spontaneousabortion) {
        this.spontaneousabortion = spontaneousabortion;
    }

    public Integer getArtificialabortion() {
        return artificialabortion;
    }

    public void setArtificialabortion(Integer artificialabortion) {
        this.artificialabortion = artificialabortion;
    }

    public Integer getHydatidiformmole() {
        return hydatidiformmole;
    }

    public void setHydatidiformmole(Integer hydatidiformmole) {
        this.hydatidiformmole = hydatidiformmole;
    }

    public Integer getStillbornfoetus() {
        return stillbornfoetus;
    }

    public void setStillbornfoetus(Integer stillbornfoetus) {
        this.stillbornfoetus = stillbornfoetus;
    }

    public Integer getBirthmalformation() {
        return birthmalformation;
    }

    public void setBirthmalformation(Integer birthmalformation) {
        this.birthmalformation = birthmalformation;
    }

    public Integer getPrematurebirth() {
        return prematurebirth;
    }

    public void setPrematurebirth(Integer prematurebirth) {
        this.prematurebirth = prematurebirth;
    }

    public Integer getMedicalabortion() {
        return medicalabortion;
    }

    public void setMedicalabortion(Integer medicalabortion) {
        this.medicalabortion = medicalabortion;
    }

    public Integer getInducedlabor() {
        return inducedlabor;
    }

    public void setInducedlabor(Integer inducedlabor) {
        this.inducedlabor = inducedlabor;
    }

    public Integer getDifficultlabour() {
        return difficultlabour;
    }

    public void setDifficultlabour(Integer difficultlabour) {
        this.difficultlabour = difficultlabour;
    }

    public Integer getExtrauterinepregnancy() {
        return extrauterinepregnancy;
    }

    public void setExtrauterinepregnancy(Integer extrauterinepregnancy) {
        this.extrauterinepregnancy = extrauterinepregnancy;
    }

    public String getHeartdisease() {
        return heartdisease;
    }

    public void setHeartdisease(String heartdisease) {
        this.heartdisease = heartdisease == null ? null : heartdisease.trim();
    }

    public String getTuberculosis() {
        return tuberculosis;
    }

    public void setTuberculosis(String tuberculosis) {
        this.tuberculosis = tuberculosis == null ? null : tuberculosis.trim();
    }

    public String getNephropathy() {
        return nephropathy;
    }

    public void setNephropathy(String nephropathy) {
        this.nephropathy = nephropathy == null ? null : nephropathy.trim();
    }

    public String getHematopathy() {
        return hematopathy;
    }

    public void setHematopathy(String hematopathy) {
        this.hematopathy = hematopathy == null ? null : hematopathy.trim();
    }

    public String getHyperthyroidism() {
        return hyperthyroidism;
    }

    public void setHyperthyroidism(String hyperthyroidism) {
        this.hyperthyroidism = hyperthyroidism == null ? null : hyperthyroidism.trim();
    }

    public String getHarmfulsubstance() {
        return harmfulsubstance;
    }

    public void setHarmfulsubstance(String harmfulsubstance) {
        this.harmfulsubstance = harmfulsubstance == null ? null : harmfulsubstance.trim();
    }

    public String getHepatopathy() {
        return hepatopathy;
    }

    public void setHepatopathy(String hepatopathy) {
        this.hepatopathy = hepatopathy == null ? null : hepatopathy.trim();
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension == null ? null : hypertension.trim();
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes == null ? null : diabetes.trim();
    }

    public String getOtherdiseases() {
        return otherdiseases;
    }

    public void setOtherdiseases(String otherdiseases) {
        this.otherdiseases = otherdiseases == null ? null : otherdiseases.trim();
    }

    public String getSpontaneousabortiondescribe() {
        return spontaneousabortiondescribe;
    }

    public void setSpontaneousabortiondescribe(String spontaneousabortiondescribe) {
        this.spontaneousabortiondescribe = spontaneousabortiondescribe == null ? null : spontaneousabortiondescribe.trim();
    }

    public String getArtificialabortiondescribe() {
        return artificialabortiondescribe;
    }

    public void setArtificialabortiondescribe(String artificialabortiondescribe) {
        this.artificialabortiondescribe = artificialabortiondescribe == null ? null : artificialabortiondescribe.trim();
    }

    public String getHydatidiformmoledescribe() {
        return hydatidiformmoledescribe;
    }

    public void setHydatidiformmoledescribe(String hydatidiformmoledescribe) {
        this.hydatidiformmoledescribe = hydatidiformmoledescribe == null ? null : hydatidiformmoledescribe.trim();
    }

    public String getStillbornfoetusdescribe() {
        return stillbornfoetusdescribe;
    }

    public void setStillbornfoetusdescribe(String stillbornfoetusdescribe) {
        this.stillbornfoetusdescribe = stillbornfoetusdescribe == null ? null : stillbornfoetusdescribe.trim();
    }

    public String getBirthmalformationdescribe() {
        return birthmalformationdescribe;
    }

    public void setBirthmalformationdescribe(String birthmalformationdescribe) {
        this.birthmalformationdescribe = birthmalformationdescribe == null ? null : birthmalformationdescribe.trim();
    }

    public String getPrematurebirthdescribe() {
        return prematurebirthdescribe;
    }

    public void setPrematurebirthdescribe(String prematurebirthdescribe) {
        this.prematurebirthdescribe = prematurebirthdescribe == null ? null : prematurebirthdescribe.trim();
    }

    public String getMedicalabortiondescribe() {
        return medicalabortiondescribe;
    }

    public void setMedicalabortiondescribe(String medicalabortiondescribe) {
        this.medicalabortiondescribe = medicalabortiondescribe == null ? null : medicalabortiondescribe.trim();
    }

    public String getInducedlabordescribe() {
        return inducedlabordescribe;
    }

    public void setInducedlabordescribe(String inducedlabordescribe) {
        this.inducedlabordescribe = inducedlabordescribe == null ? null : inducedlabordescribe.trim();
    }

    public String getDifficultlabourdescribe() {
        return difficultlabourdescribe;
    }

    public void setDifficultlabourdescribe(String difficultlabourdescribe) {
        this.difficultlabourdescribe = difficultlabourdescribe == null ? null : difficultlabourdescribe.trim();
    }

    public String getExtrauterinepregnancydescribe() {
        return extrauterinepregnancydescribe;
    }

    public void setExtrauterinepregnancydescribe(String extrauterinepregnancydescribe) {
        this.extrauterinepregnancydescribe = extrauterinepregnancydescribe == null ? null : extrauterinepregnancydescribe.trim();
    }

    public String getHeartdiseasedescribe() {
        return heartdiseasedescribe;
    }

    public void setHeartdiseasedescribe(String heartdiseasedescribe) {
        this.heartdiseasedescribe = heartdiseasedescribe == null ? null : heartdiseasedescribe.trim();
    }

    public String getTuberculosisdescribe() {
        return tuberculosisdescribe;
    }

    public void setTuberculosisdescribe(String tuberculosisdescribe) {
        this.tuberculosisdescribe = tuberculosisdescribe == null ? null : tuberculosisdescribe.trim();
    }

    public String getNephropathydescribe() {
        return nephropathydescribe;
    }

    public void setNephropathydescribe(String nephropathydescribe) {
        this.nephropathydescribe = nephropathydescribe == null ? null : nephropathydescribe.trim();
    }

    public String getHematopathydescribe() {
        return hematopathydescribe;
    }

    public void setHematopathydescribe(String hematopathydescribe) {
        this.hematopathydescribe = hematopathydescribe == null ? null : hematopathydescribe.trim();
    }

    public String getHyperthyroidismdescribe() {
        return hyperthyroidismdescribe;
    }

    public void setHyperthyroidismdescribe(String hyperthyroidismdescribe) {
        this.hyperthyroidismdescribe = hyperthyroidismdescribe == null ? null : hyperthyroidismdescribe.trim();
    }

    public String getHarmfulsubstancedescribe() {
        return harmfulsubstancedescribe;
    }

    public void setHarmfulsubstancedescribe(String harmfulsubstancedescribe) {
        this.harmfulsubstancedescribe = harmfulsubstancedescribe == null ? null : harmfulsubstancedescribe.trim();
    }

    public String getHepatopathydescribe() {
        return hepatopathydescribe;
    }

    public void setHepatopathydescribe(String hepatopathydescribe) {
        this.hepatopathydescribe = hepatopathydescribe == null ? null : hepatopathydescribe.trim();
    }

    public String getHypertensiondescribe() {
        return hypertensiondescribe;
    }

    public void setHypertensiondescribe(String hypertensiondescribe) {
        this.hypertensiondescribe = hypertensiondescribe == null ? null : hypertensiondescribe.trim();
    }

    public String getDiabetesdescribe() {
        return diabetesdescribe;
    }

    public void setDiabetesdescribe(String diabetesdescribe) {
        this.diabetesdescribe = diabetesdescribe == null ? null : diabetesdescribe.trim();
    }

    public String getOtherdiseasesdescribe() {
        return otherdiseasesdescribe;
    }

    public void setOtherdiseasesdescribe(String otherdiseasesdescribe) {
        this.otherdiseasesdescribe = otherdiseasesdescribe == null ? null : otherdiseasesdescribe.trim();
    }

	@Override
	public String toString() {
		return "abnormalMaternalHistory [id=" + id + ", prewomanid=" + prewomanid + ", spontaneousabortion="
				+ spontaneousabortion + ", artificialabortion=" + artificialabortion + ", hydatidiformmole="
				+ hydatidiformmole + ", stillbornfoetus=" + stillbornfoetus + ", birthmalformation=" + birthmalformation
				+ ", prematurebirth=" + prematurebirth + ", medicalabortion=" + medicalabortion + ", inducedlabor="
				+ inducedlabor + ", difficultlabour=" + difficultlabour + ", extrauterinepregnancy="
				+ extrauterinepregnancy + ", heartdisease=" + heartdisease + ", tuberculosis=" + tuberculosis
				+ ", nephropathy=" + nephropathy + ", hematopathy=" + hematopathy + ", hyperthyroidism="
				+ hyperthyroidism + ", harmfulsubstance=" + harmfulsubstance + ", hepatopathy=" + hepatopathy
				+ ", hypertension=" + hypertension + ", diabetes=" + diabetes + ", otherdiseases=" + otherdiseases
				+ ", spontaneousabortiondescribe=" + spontaneousabortiondescribe + ", artificialabortiondescribe="
				+ artificialabortiondescribe + ", hydatidiformmoledescribe=" + hydatidiformmoledescribe
				+ ", stillbornfoetusdescribe=" + stillbornfoetusdescribe + ", birthmalformationdescribe="
				+ birthmalformationdescribe + ", prematurebirthdescribe=" + prematurebirthdescribe
				+ ", medicalabortiondescribe=" + medicalabortiondescribe + ", inducedlabordescribe="
				+ inducedlabordescribe + ", difficultlabourdescribe=" + difficultlabourdescribe
				+ ", extrauterinepregnancydescribe=" + extrauterinepregnancydescribe + ", heartdiseasedescribe="
				+ heartdiseasedescribe + ", tuberculosisdescribe=" + tuberculosisdescribe + ", nephropathydescribe="
				+ nephropathydescribe + ", hematopathydescribe=" + hematopathydescribe + ", hyperthyroidismdescribe="
				+ hyperthyroidismdescribe + ", harmfulsubstancedescribe=" + harmfulsubstancedescribe
				+ ", hepatopathydescribe=" + hepatopathydescribe + ", hypertensiondescribe=" + hypertensiondescribe
				+ ", diabetesdescribe=" + diabetesdescribe + ", otherdiseasesdescribe=" + otherdiseasesdescribe + "]";
	}
    
    
}
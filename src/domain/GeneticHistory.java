package domain;

public class GeneticHistory {
    private Integer id;
    //精神病
    private String psychosis;
    //痴呆
    private String dementia;
    //畸形
    private String malformation;
    //遗传病史
    private String geneticdisease;
    //精神病史描述
    private String psychosisdescribe;
    //痴呆病史描述
    private String dementiadescribe;
    //畸形描述
    private String malformationdescribe;
    //遗传病史描述
    private String geneticdiseasedescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPsychosis() {
        return psychosis;
    }

    public void setPsychosis(String psychosis) {
        this.psychosis = psychosis == null ? null : psychosis.trim();
    }

    public String getDementia() {
        return dementia;
    }

    public void setDementia(String dementia) {
        this.dementia = dementia == null ? null : dementia.trim();
    }

    public String getMalformation() {
        return malformation;
    }

    public void setMalformation(String malformation) {
        this.malformation = malformation == null ? null : malformation.trim();
    }

    public String getGeneticdisease() {
        return geneticdisease;
    }

    public void setGeneticdisease(String geneticdisease) {
        this.geneticdisease = geneticdisease == null ? null : geneticdisease.trim();
    }

    public String getPsychosisdescribe() {
        return psychosisdescribe;
    }

    public void setPsychosisdescribe(String psychosisdescribe) {
        this.psychosisdescribe = psychosisdescribe == null ? null : psychosisdescribe.trim();
    }

    public String getDementiadescribe() {
        return dementiadescribe;
    }

    public void setDementiadescribe(String dementiadescribe) {
        this.dementiadescribe = dementiadescribe == null ? null : dementiadescribe.trim();
    }

    public String getMalformationdescribe() {
        return malformationdescribe;
    }

    public void setMalformationdescribe(String malformationdescribe) {
        this.malformationdescribe = malformationdescribe == null ? null : malformationdescribe.trim();
    }

    public String getGeneticdiseasedescribe() {
        return geneticdiseasedescribe;
    }

    public void setGeneticdiseasedescribe(String geneticdiseasedescribe) {
        this.geneticdiseasedescribe = geneticdiseasedescribe == null ? null : geneticdiseasedescribe.trim();
    }

	@Override
	public String toString() {
		return "GeneticHistory [id=" + id + ", psychosis=" + psychosis + ", dementia=" + dementia + ", malformation="
				+ malformation + ", geneticdisease=" + geneticdisease + ", psychosisdescribe=" + psychosisdescribe
				+ ", dementiadescribe=" + dementiadescribe + ", malformationdescribe=" + malformationdescribe
				+ ", geneticdiseasedescribe=" + geneticdiseasedescribe + "]";
	}

	
    
}
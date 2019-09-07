package com.ref.to;

public class VechilePartScheduleTo {

    private int vechilePartScheduleId;
    private long changeAfterKm;
    private String scheduleName;
    private VechileModelTo vechileModel;

    public int getVechilePartScheduleId() {
	return vechilePartScheduleId;
    }

    public void setVechilePartScheduleId(int vechilePartScheduleId) {
	this.vechilePartScheduleId = vechilePartScheduleId;
    }

    public long getChangeAfterKm() {
	return changeAfterKm;
    }

    public void setChangeAfterKm(long changeAfterKm) {
	this.changeAfterKm = changeAfterKm;
    }

    public String getScheduleName() {
	return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
	this.scheduleName = scheduleName;
    }

    public VechileModelTo getVechileModel() {
	return vechileModel;
    }

    public void setVechileModel(VechileModelTo vechileModel) {
	this.vechileModel = vechileModel;
    }

}

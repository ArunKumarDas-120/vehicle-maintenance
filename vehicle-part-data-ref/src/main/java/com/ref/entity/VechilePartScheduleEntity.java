package com.ref.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VECHILE_PART_SCHEDULE")
@Access(AccessType.PROPERTY)
public class VechilePartScheduleEntity {

    private int vechilePartScheduleId;
    private long changeAfterKm;
    private String scheduleName;
    private VechileModelEntity vechileModel;

    @Id
    @Column(name = "VEC_PRT_SCHD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getVechilePartScheduleId() {
	return vechilePartScheduleId;
    }

    public void setVechilePartScheduleId(int vechilePartScheduleId) {
	this.vechilePartScheduleId = vechilePartScheduleId;
    }

    @Column(name = "VEC_PRT_CHANGE_AFTER", nullable = false)
    public long getChangeAfterKm() {
	return changeAfterKm;
    }

    public void setChangeAfterKm(long changeAfterKm) {
	this.changeAfterKm = changeAfterKm;
    }

    @Column(name = "VEC_PRT_SCHD_NAME", nullable = false)
    public String getScheduleName() {
	return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
	this.scheduleName = scheduleName;
    }

    @ManyToOne
    @JoinColumn(name = "MODEL_FK", referencedColumnName = "VECHILE_MODEL_ID", nullable = false)
    public VechileModelEntity getVechileModel() {
	return vechileModel;
    }

    public void setVechileModel(VechileModelEntity vechileModel) {
	this.vechileModel = vechileModel;
    }

}

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
@Table(name = "VECHILE_MODEL")
@Access(AccessType.PROPERTY)
public class VechileModelEntity {

    private int vechileModelId;
    private String vechileModelName;
    private VechileCompanyEntity vechileCompany;

    @Id
    @Column(name = "VECHILE_MODEL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getVechileModelId() {
	return vechileModelId;
    }

    public void setVechileModelId(int vechileModelId) {
	this.vechileModelId = vechileModelId;
    }

    @Column(name = "VECHILE_MODEL_NAME", nullable = false, unique = true)
    public String getVechileModelName() {
	return vechileModelName;
    }

    public void setVechileModelName(String vechileModelName) {
	this.vechileModelName = vechileModelName;
    }

    @ManyToOne
    @JoinColumn(name = "COMP_ID_FK", referencedColumnName = "VECHILE_COMPANY_ID", nullable = false)
    public VechileCompanyEntity getVechileCompany() {
	return vechileCompany;
    }

    public void setVechileCompany(VechileCompanyEntity vechileCompany) {
	this.vechileCompany = vechileCompany;
    }

}

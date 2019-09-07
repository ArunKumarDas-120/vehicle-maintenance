package com.ref.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VECHILE_COMPANY")
@Access(AccessType.PROPERTY)
public class VechileCompanyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int vechileCompanyId;
    private String vechileCompanyName;

    @Id
    @Column(name = "VECHILE_COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getVechileCompanyId() {
	return vechileCompanyId;
    }

    public void setVechileCompanyId(int vechileCompanyId) {
	this.vechileCompanyId = vechileCompanyId;
    }

    @Column(name = "VECHILE_COMPANY_NAME", nullable = false, unique = true)
    public String getVechileCompanyName() {
	return vechileCompanyName;
    }

    public void setVechileCompanyName(String vechileCompanyName) {
	this.vechileCompanyName = vechileCompanyName;
    }

}

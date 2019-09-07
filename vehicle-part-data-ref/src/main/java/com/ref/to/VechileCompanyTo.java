package com.ref.to;

import java.io.Serializable;

public class VechileCompanyTo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int vechileCompanyId;
    private String vechileCompanyName;

    public int getVechileCompanyId() {
	return vechileCompanyId;
    }

    public void setVechileCompanyId(int vechileCompanyId) {
	this.vechileCompanyId = vechileCompanyId;
    }

    public String getVechileCompanyName() {
	return vechileCompanyName;
    }

    public void setVechileCompanyName(String vechileCompanyName) {
	this.vechileCompanyName = vechileCompanyName;
    }

}

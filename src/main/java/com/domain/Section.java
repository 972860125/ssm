package com.domain;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Section {

    @Id
    private Integer id;

    private String sectionname;

    private Integer companyid;

    @Transient
    Company company; //一个部门对应的一个公司对象

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}
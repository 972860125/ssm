package com.domain;

import javax.persistence.Id;

public class Permis {

    @Id
    private Integer id;

    private String permistitle;

    private String href;

    private Integer parent;

    private String permisname;

    private Integer permistype;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermistitle() {
        return permistitle;
    }

    public void setPermistitle(String permistitle) {
        this.permistitle = permistitle;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getPermisname() {
        return permisname;
    }

    public void setPermisname(String permisname) {
        this.permisname = permisname;
    }

    public Integer getPermistype() {
        return permistype;
    }

    public void setPermistype(Integer permistype) {
        this.permistype = permistype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
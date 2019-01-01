package com.pes;

public class Meta {
    private Float data_version;
    private String created;
    private Integer revision;

    public Float getData_version() {
        return this.data_version;
    }

    public void setData_version(Float version) {
        this.data_version = version;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }
}
package com.lf.test.admin.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class PmsBrand implements Serializable {
    private Long id;

    private String brandName;

    private String sort;

    private Boolean brandFactoryStatus;

    private Boolean showStatus;

    private String delStatus;

    private String brandLogoPic;

    private String showPic;

    private Date createTime;

    private Long creatorId;

    private Date modifyTime;

    private Long modifierId;

    private String brandStory;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Boolean getBrandFactoryStatus() {
        return brandFactoryStatus;
    }

    public void setBrandFactoryStatus(Boolean brandFactoryStatus) {
        this.brandFactoryStatus = brandFactoryStatus;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getBrandLogoPic() {
        return brandLogoPic;
    }

    public void setBrandLogoPic(String brandLogoPic) {
        this.brandLogoPic = brandLogoPic;
    }

    public String getShowPic() {
        return showPic;
    }

    public void setShowPic(String showPic) {
        this.showPic = showPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", sort=").append(sort);
        sb.append(", brandFactoryStatus=").append(brandFactoryStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", brandLogoPic=").append(brandLogoPic);
        sb.append(", showPic=").append(showPic);
        sb.append(", createTime=").append(createTime);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", brandStory=").append(brandStory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
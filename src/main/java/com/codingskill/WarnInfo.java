package com.codingskill;

import java.io.Serializable;

/**
 * 线路预警消息记录 entity
 *
 * @author huangzhaoyu
 */
public class WarnInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 行程id
     */
    private String rid;
    /**
     * 车牌号
     */
    private String vno;
    /**
     * 出发地
     */
    private String sLoc;
    /**
     * 目的地
     */
    private String dLoc;
    /**
     * 报警地点
     */
    private String adr;
    /**
     * 报警类型：偏离、停车、离线、位置信息
     */
    private String type;
    /**
     * 报警发生时间
     */
    private Long time;
    /**
     * 报警持续时间
     */
    private Long warnTime;
    /**
     * 报警持续时间
     */
    private Long outTime;
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 所属企业路径
     */
    private String orgSeq;
    /**
     * 所属企业id
     */
    private Long orgId;
    /**
     * 修改时间
     */
    private java.util.Date updateTime;
    /**
     * 逻辑删除标识1 已删除 0 未删除
     */
    private Integer delFlag;

    private String maplon;//纬度
    private String maplat;//经度

    private String num;//x类型报警的数量

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMaplon() {
        return maplon;
    }

    public void setMaplon(String maplon) {
        this.maplon = maplon;
    }

    public String getMaplat() {
        return maplat;
    }

    public void setMaplat(String maplat) {
        this.maplat = maplat;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public String getsLoc() {
        return sLoc;
    }

    public void setsLoc(String sLoc) {
        this.sLoc = sLoc;
    }

    public String getdLoc() {
        return dLoc;
    }

    public void setdLoc(String dLoc) {
        this.dLoc = dLoc;
    }

    public Long getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Long warnTime) {
        this.warnTime = warnTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getOrgSeq() {
        return orgSeq;
    }

    public void setOrgSeq(String orgSeq) {
        this.orgSeq = orgSeq;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}


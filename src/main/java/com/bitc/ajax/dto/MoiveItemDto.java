package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class MoiveItemDto {

    private int rnum;
    private int rank;
    private int rankInten;
    private String rankOldAndNew;
    private int movieCd;
    private String movieNm;
    private String openDt;
    private String salesAmt;
    private String salesShare;
    private String salesChange;
    private String salesAcc;
    private String audiCnt;
    private String audiInten;
    private String audiChange;
    private String audiAcc;
    private int scrnCnt;
    private int showCnt;

    @XmlElement
    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRankInten() {
        return rankInten;
    }

    public void setRankInten(int rankInten) {
        this.rankInten = rankInten;
    }

    public String getRankOldAndNew() {
        return rankOldAndNew;
    }

    public void setRankOldAndNew(String rankOldAndNew) {
        this.rankOldAndNew = rankOldAndNew;
    }

    public int getMovieCd() {
        return movieCd;
    }

    public void setMovieCd(int movieCd) {
        this.movieCd = movieCd;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getSalesAmt() {
        return salesAmt;
    }

    public void setSalesAmt(String salesAmt) {
        this.salesAmt = salesAmt;
    }

    public String getSalesShare() {
        return salesShare;
    }

    public void setSalesShare(String salesShare) {
        this.salesShare = salesShare;
    }

    public String getSalesChange() {
        return salesChange;
    }

    public void setSalesChange(String salesChange) {
        this.salesChange = salesChange;
    }

    public String getSalesAcc() {
        return salesAcc;
    }

    public void setSalesAcc(String salesAcc) {
        this.salesAcc = salesAcc;
    }

    public String getAudiCnt() {
        return audiCnt;
    }

    public void setAudiCnt(String audiCnt) {
        this.audiCnt = audiCnt;
    }

    public String getAudiInten() {
        return audiInten;
    }

    public void setAudiInten(String audiInten) {
        this.audiInten = audiInten;
    }

    public String getAudiChange() {
        return audiChange;
    }

    public void setAudiChange(String audiChange) {
        this.audiChange = audiChange;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }

    public int getScrnCnt() {
        return scrnCnt;
    }

    public void setScrnCnt(int scrnCnt) {
        this.scrnCnt = scrnCnt;
    }

    public int getShowCnt() {
        return showCnt;
    }

    public void setShowCnt(int showCnt) {
        this.showCnt = showCnt;
    }
}

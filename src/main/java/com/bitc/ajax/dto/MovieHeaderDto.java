package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "header")
public class MovieHeaderDto {

    private String boxofficeType;
    private String showRange;

    @XmlElement
    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }
}

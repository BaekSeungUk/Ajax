package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "itmes")
public class MovieItmesDto {

    private List<MoiveItemDto> itemList;

    @XmlElement(name = "item")
    public List<MoiveItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<MoiveItemDto> itemList) {
        this.itemList = itemList;
    }
}

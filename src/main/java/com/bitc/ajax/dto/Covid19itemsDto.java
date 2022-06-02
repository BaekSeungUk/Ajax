package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "items")
public class Covid19itemsDto {

    private List<Covid19itemDto> itemList;

    @XmlElement(name = "item")
    public List<Covid19itemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<Covid19itemDto> itemList) {
        this.itemList = itemList;
    }
}

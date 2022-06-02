package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class MovieBodyDto {

    private MovieItmesDto items;

    @XmlElement
    public MovieItmesDto getItems() {
        return items;
    }

    public void setItems(MovieItmesDto items) {
        this.items = items;
    }
}

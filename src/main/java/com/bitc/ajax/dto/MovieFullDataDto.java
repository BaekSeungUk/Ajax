package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class MovieFullDataDto {

    private MovieHeaderDto header;
    private MovieBodyDto body;

    @XmlElement(name = "header")
    public MovieHeaderDto getHeader() {
        return header;
    }

    public void setHeader(MovieHeaderDto header) {
        this.header = header;
    }
    @XmlElement(name = "body")
    public MovieBodyDto getBody() {
        return body;
    }

    public void setBody(MovieBodyDto body) {
        this.body = body;
    }
}

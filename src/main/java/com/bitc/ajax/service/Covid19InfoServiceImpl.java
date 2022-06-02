package com.bitc.ajax.service;

import com.bitc.ajax.dto.Covid19FullDataDto;
import com.bitc.ajax.dto.Covid19itemDto;
import com.bitc.ajax.dto.PharmacyFullDataDto;
import com.bitc.ajax.dto.PharmacyItemDto;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class Covid19InfoServiceImpl implements Covid19InfoService {

    @Override
    public List<Covid19itemDto> getItemListUrl(String serviceUrl) throws Exception {
        List<Covid19itemDto> itemList = null;

        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(Covid19FullDataDto.class);
            Unmarshaller um = jc.createUnmarshaller();

            Covid19FullDataDto fullData = (Covid19FullDataDto) um.unmarshal(url);
            itemList = fullData.getBody().getItems().getItemList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (urlConn != null)
                urlConn.disconnect();
        }

        return itemList;
    }
}

package com.bitc.ajax.service;

import com.bitc.ajax.dto.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService{
    @Override
    public List<MoiveItemDto> getItemListUrl(String serviceUrl) throws Exception {
        List<MoiveItemDto> itemList = null;

        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(MovieFullDataDto.class);
            Unmarshaller um = jc.createUnmarshaller();

            MovieFullDataDto fullData = (MovieFullDataDto) um.unmarshal(url);
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

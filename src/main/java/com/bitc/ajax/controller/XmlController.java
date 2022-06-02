package com.bitc.ajax.controller;

import com.bitc.ajax.dto.Covid19itemDto;
import com.bitc.ajax.dto.MoiveItemDto;
import com.bitc.ajax.dto.PharmacyItemDto;
import com.bitc.ajax.service.Covid19InfoService;
import com.bitc.ajax.service.MovieInfoService;
import com.bitc.ajax.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class XmlController {

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private Covid19InfoService covid19InfoService;

    @Autowired
    private MovieInfoService movieInfoService;

    // @Value : 해당 어노테이션은 application.properties 파일에 지정한 내용을 불러와서 사용할 수 있음
    @Value("${user.key}")
    private String secKey;

    @RequestMapping(value = "/pharmacy/fullData", method = RequestMethod.GET)
    public ModelAndView getPharmacyFullData() throws Exception {
        ModelAndView mv = new ModelAndView("/ajax/pharmarcyList");

        List<PharmacyItemDto> itemList = pharmacyService.getItemList();
        mv.addObject("pharmacyDataList", itemList);

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/pharmacy/ajaxFullData", method = RequestMethod.POST)
    public Object getAjaxPharmacyFullDate(@RequestParam Map<String, String> request) throws Exception {

        List<PharmacyItemDto> itemList = pharmacyService.getItemList();

        return itemList;
    }

    @ResponseBody
    @RequestMapping(value = "/pharmacy/ajaxFullDataUrl", method = RequestMethod.POST)
    public Object getAjaxPharmacyFullDataUrl(@RequestParam("pageNo") int pageNo, @RequestParam("numOfRows") int numOfRows) throws Exception {
        // https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/    -- 서버 주소
        // getParmacyFullDown  -- 조회 명령
        // ?serviceKey=zS0Cy3A6AtdC4%2BPnULOEiueENRVEZt9EbHQgDMICDvfvXo%2BZM5PpZr3ApBLdRuTncDZfXZqP0Su2gCEwHF8pvg%3D%3D
        // &pageNo=1       -- 옵션 1
        // &numOfRows=10   -- 옵션 2
        String endPoint = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/";
        String serviceFunc = "getParmacyFullDown?";
        String serviceKey = "serviceKey=zS0Cy3A6AtdC4%2BPnULOEiueENRVEZt9EbHQgDMICDvfvXo%2BZM5PpZr3ApBLdRuTncDZfXZqP0Su2gCEwHF8pvg%3D%3D";
        String option1 = " &pageNo=";
        String option2 = "&numOfRows=";

        String serviceUrl = endPoint + serviceFunc + serviceKey + "&" + option1 + pageNo + option2 + numOfRows;

        List<PharmacyItemDto> itemList = pharmacyService.getItemListUrl(serviceUrl);

        return itemList;
    }

    @RequestMapping(value = "/covid19/infoState", method = RequestMethod.GET)
    public String getCovid19InfoState() throws Exception {
        return "/ajax/covid19Info";
    }

    @ResponseBody
    @RequestMapping(value = "/covid19/InfoStateData", method = RequestMethod.POST)
    public Object getAjaxCovid19FullDataUrl(@RequestParam("pageNo") String  pageNo, @RequestParam("numOfRows") String numOfRows, @RequestParam("startCreateDt") String  startCreateDt, @RequestParam("endCreateDt") String  endCreateDt) throws Exception {
        String endPoint = "http://openapi.data.go.kr/openapi/service/rest/Covid19/";
        String serviceFunc = "getCovid19InfStateJson?";
        String serviceKey = "serviceKey=";
        String option1 = "&pageNo=";
        String option2 = "&numOfRows=";
        String option3 = "&startCreateDt=";
        String option4 = "&endCreateDt=";

        String serviceUrl = endPoint + serviceFunc + serviceKey + secKey + option1 + pageNo + option2 + numOfRows + option3 + startCreateDt.replace("-", "") + option4 + endCreateDt.replace("-", "");

        List<Covid19itemDto> itemList = covid19InfoService.getItemListUrl(serviceUrl);

        return itemList;
    }

    @RequestMapping(value = "/movie/infoState", method = RequestMethod.GET)
    public String getMovieInfoState() throws Exception {
        return "/ajax/movieInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/movie/InfoStateData", method = RequestMethod.POST)
    public Object getMovieFullDataUrl(@RequestParam("pageNo") String  pageNo, @RequestParam("targetDt") String targetDt) throws Exception {
       //http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/
        // searchDailyBoxOfficeList.xml?
        // key=f5eef3421c602c6cb7ea224104795888
        // &targetDt=20120101
        String endPoint = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/";
        String serviceFunc = "searchDailyBoxOfficeList.xml?";
        String serviceKey = "key=f5eef3421c602c6cb7ea224104795888";
        String option1 = "&targetDt=";

        String serviceUrl = endPoint + serviceFunc + serviceKey + "&" + option1 + targetDt;

        List<MoiveItemDto> itemList = movieInfoService.getItemListUrl(serviceUrl);

        return itemList;
    }

}

package com.bitc.ajax.service;

import com.bitc.ajax.dto.Covid19itemDto;
import com.bitc.ajax.dto.MoiveItemDto;

import java.util.List;

public interface MovieInfoService {
    List<MoiveItemDto> getItemListUrl(String serviceUrl) throws Exception;
}

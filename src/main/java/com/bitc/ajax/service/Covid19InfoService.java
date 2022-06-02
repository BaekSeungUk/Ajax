package com.bitc.ajax.service;

import com.bitc.ajax.dto.Covid19itemDto;
import com.bitc.ajax.dto.PharmacyItemDto;

import java.util.List;

public interface Covid19InfoService {
    List<Covid19itemDto> getItemListUrl(String serviceUrl) throws Exception;
}

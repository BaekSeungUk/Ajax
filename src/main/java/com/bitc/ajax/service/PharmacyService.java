package com.bitc.ajax.service;

import com.bitc.ajax.dto.PharmacyItemDto;
import com.bitc.ajax.dto.PharmacyItemsDto;

import java.util.List;

public interface PharmacyService {
    public List<PharmacyItemDto> getItemList() throws Exception;

    List<PharmacyItemDto> getItemListUrl(String serviceUrl) throws Exception;
}

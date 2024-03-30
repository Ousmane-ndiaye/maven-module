package com.aumones.tools.commons.exemple.service.jpa;

import com.aumones.tools.commons.exemple.data.jpa.model.JpaExempleModel;
import com.aumones.tools.commons.exemple.web.dto.request.ExempleSearchRequestDto;
import com.aumones.tools.commons.exemple.web.dto.request.JpaExempleCreateRequestDto;
import com.aumones.tools.commons.exemple.web.dto.request.JpaExempleUpdateRequestDto;
import com.aumones.tools.commons.service.AbstractCRUDAndSearchService;

public interface JpaExempleService extends AbstractCRUDAndSearchService<Long, JpaExempleModel, ExempleSearchRequestDto,
    JpaExempleCreateRequestDto, JpaExempleUpdateRequestDto> {
}

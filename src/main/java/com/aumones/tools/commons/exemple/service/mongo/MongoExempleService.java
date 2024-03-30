package com.aumones.tools.commons.exemple.service.mongo;

import com.aumones.tools.commons.exemple.data.mongo.model.MongoExempleModel;
import com.aumones.tools.commons.exemple.web.dto.request.MongoExempleCreateRequestDto;
import com.aumones.tools.commons.exemple.web.dto.request.ExempleSearchRequestDto;
import com.aumones.tools.commons.exemple.web.dto.request.MongoExempleUpdateRequestDto;
import com.aumones.tools.commons.service.AbstractCRUDAndSearchService;

public interface MongoExempleService extends AbstractCRUDAndSearchService<String, MongoExempleModel, ExempleSearchRequestDto,
    MongoExempleCreateRequestDto, MongoExempleUpdateRequestDto> {
}

package com.aumones.tools.commons.exemple.data.mongo.repository.customQuery;

import com.aumones.tools.commons.data.repository.AbstractCustomQuery;
import com.aumones.tools.commons.exemple.data.mongo.model.MongoExempleModel;
import com.aumones.tools.commons.exemple.web.dto.request.ExempleSearchRequestDto;

public interface MongoExempleCustomQuery extends AbstractCustomQuery<String, MongoExempleModel, ExempleSearchRequestDto> {
}

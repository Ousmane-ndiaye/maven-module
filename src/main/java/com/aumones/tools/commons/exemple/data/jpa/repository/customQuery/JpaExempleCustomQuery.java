package com.aumones.tools.commons.exemple.data.jpa.repository.customQuery;

import com.aumones.tools.commons.data.repository.AbstractCustomQuery;
import com.aumones.tools.commons.exemple.data.jpa.model.JpaExempleModel;
import com.aumones.tools.commons.exemple.web.dto.request.ExempleSearchRequestDto;

public interface JpaExempleCustomQuery extends AbstractCustomQuery<Long, JpaExempleModel, ExempleSearchRequestDto> {
}

package com.aumones.tools.commons.data.repository;

import com.aumones.tools.commons.data.model.AbstractModel;
import com.aumones.tools.commons.web.dto.request.AbstractSearchRequestDto;

public interface AbstractRepositoryCustom<ID, T extends AbstractModel<ID>, S extends AbstractSearchRequestDto>
    extends AbstractRepository<ID, T>, AbstractCustomQuery<ID, T, S> {

}

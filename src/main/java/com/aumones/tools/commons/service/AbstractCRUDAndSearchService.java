package com.aumones.tools.commons.service;

import com.aumones.tools.commons.data.model.AbstractModel;
import com.aumones.tools.commons.web.dto.request.AbstractCreateRequestDto;
import com.aumones.tools.commons.web.dto.request.AbstractSearchRequestDto;
import com.aumones.tools.commons.web.dto.request.AbstractUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AbstractCRUDAndSearchService<ID, T extends AbstractModel<ID>, S extends AbstractSearchRequestDto,
    C extends AbstractCreateRequestDto<T>, U extends AbstractUpdateRequestDto<T>> extends AbstractCRUDService<ID, T, C, U> {

  List<T> list(S searchRequest);

  Page<T> list(S searchRequest, Pageable page);
}

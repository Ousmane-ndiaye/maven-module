package com.aumones.tools.commons.exemple.service.mongo;

import com.aumones.tools.commons.exemple.data.mongo.repository.MongoExempleRepository;
import com.aumones.tools.commons.exemple.web.dto.request.MongoExempleCreateRequestDto;
import com.aumones.tools.commons.exemple.web.dto.request.ExempleSearchRequestDto;
import com.aumones.tools.commons.exemple.web.dto.request.MongoExempleUpdateRequestDto;
import com.aumones.tools.commons.exemple.data.mongo.model.MongoExempleModel;
import com.aumones.tools.commons.service.impl.AbstractCRUDAndSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MongoExempleServiceImpl extends AbstractCRUDAndSearchServiceImpl<String, MongoExempleModel, ExempleSearchRequestDto,
    MongoExempleCreateRequestDto, MongoExempleUpdateRequestDto> implements MongoExempleService {

  public MongoExempleServiceImpl(MongoExempleRepository repository) {
    super(repository);
  }
}

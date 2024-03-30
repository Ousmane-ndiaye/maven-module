package com.aumones.tools.commons.data.repository.mongo;

import com.aumones.tools.commons.data.model.mongo.MongoAbstractModel;
import com.aumones.tools.commons.data.repository.AbstractRepositoryCustom;
import com.aumones.tools.commons.web.dto.request.AbstractSearchRequestDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MongoAbstractRepositoryCustom<T extends MongoAbstractModel, S extends AbstractSearchRequestDto>
    extends AbstractRepositoryCustom<String, T, S>, MongoAbstractRepository<T> {

}

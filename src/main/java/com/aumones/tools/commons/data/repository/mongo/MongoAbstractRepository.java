package com.aumones.tools.commons.data.repository.mongo;

import com.aumones.tools.commons.data.model.mongo.MongoAbstractModel;
import com.aumones.tools.commons.data.repository.AbstractRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface MongoAbstractRepository<T extends MongoAbstractModel> extends AbstractRepository<String, T>,
    MongoRepository<T, String> {

}

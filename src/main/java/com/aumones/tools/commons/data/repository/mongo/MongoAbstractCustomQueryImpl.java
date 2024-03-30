package com.aumones.tools.commons.data.repository.mongo;

import com.aumones.tools.commons.data.model.mongo.MongoAbstractModel;
import com.aumones.tools.commons.data.repository.AbstractCustomQuery;
import com.aumones.tools.commons.web.dto.request.AbstractSearchRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

@NoRepositoryBean
public abstract class MongoAbstractCustomQueryImpl<T extends MongoAbstractModel, S extends AbstractSearchRequestDto>
    implements AbstractCustomQuery<String, T, S> {

  protected MongoTemplate mongoTemplate;

  protected Sort.Direction sortDirection = Sort.Direction.DESC;

  protected String sortField = "createdDate";

  public MongoAbstractCustomQueryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<T> search(S searchRequest) {
    final Query query = new Query().with(Sort.by(sortDirection, sortField));
    final List<Criteria> listCriteria = setListCriteria(searchRequest);

    if (!listCriteria.isEmpty())
      query.addCriteria(new Criteria().andOperator(listCriteria.toArray(new Criteria[0])));

    return mongoTemplate.find(query, getDocumentClass());
  }

  @Override
  public Page<T> search(S searchRequest, Pageable page) {
    final Query query = new Query().with(Sort.by(sortDirection, sortField));
    final List<Criteria> listCriteria = setListCriteria(searchRequest);

    if (!listCriteria.isEmpty())
      query.addCriteria(new Criteria().andOperator(listCriteria.toArray(new Criteria[0])));

    List<T> items = mongoTemplate.find(query, getDocumentClass());

    return PageableExecutionUtils.getPage(
        items,
        page,
        () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), getDocumentClass()));
  }

  public abstract List<Criteria> setListCriteria(S searchRequest);

  public abstract Class<T> getDocumentClass();
}

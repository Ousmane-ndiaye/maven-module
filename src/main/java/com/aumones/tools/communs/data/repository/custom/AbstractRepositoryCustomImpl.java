package com.aumones.tools.communs.data.repository.custom;

import com.aumones.tools.communs.data.model.AbstractModel;
import com.aumones.tools.communs.web.dto.request.AbstractSearchRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AbstractRepositoryCustomImpl<T extends AbstractModel, S extends AbstractSearchRequestDto>
    implements AbstractRepositoryCustom<T, S> {

  @Autowired
  private MongoTemplate mongoTemplate;

  protected Sort.Direction sortDirection = Sort.Direction.DESC;

  protected String sortField = "createdDate";

  public List<T> search(S searchRequest) {
    final Query query = new Query().with(Sort.by(sortDirection, sortField));
    final List<Criteria> listCriteria = setListCriteria(searchRequest);

    if (!listCriteria.isEmpty())
      query.addCriteria(new Criteria().andOperator(listCriteria.toArray(new Criteria[0])));

    return mongoTemplate.find(query, getDocumentClass());
  }

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

  public List<Criteria> setListCriteria(S searchRequest) {
    return new ArrayList<>();
  }

  public Class<T> getDocumentClass() {
    return null;
  }
}

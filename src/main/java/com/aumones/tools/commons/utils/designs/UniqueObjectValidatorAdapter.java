package com.aumones.tools.commons.utils.designs;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

public interface UniqueObjectValidatorAdapter {

  List<Criteria> buildUniqueObjectValidatorCriteria();

}

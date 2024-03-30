package com.aumones.tools.commons.data.repository.jpa;

import com.aumones.tools.commons.data.model.jpa.JpaAbstractModel;
import com.aumones.tools.commons.data.repository.AbstractRepositoryCustom;
import com.aumones.tools.commons.web.dto.request.AbstractSearchRequestDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaAbstractRepositoryCustom<T extends JpaAbstractModel, S extends AbstractSearchRequestDto>
    extends AbstractRepositoryCustom<Long, T, S>, JpaAbstractRepository<T> {

}

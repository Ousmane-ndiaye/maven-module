package com.aumones.tools.commons.exemple.data.jpa.repository;

import com.aumones.tools.commons.data.repository.jpa.JpaAbstractRepositoryCustom;
import com.aumones.tools.commons.exemple.data.jpa.model.JpaExempleModel;
import com.aumones.tools.commons.exemple.data.jpa.repository.customQuery.JpaExempleCustomQuery;
import com.aumones.tools.commons.exemple.web.dto.request.ExempleSearchRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaExempleRepository extends JpaAbstractRepositoryCustom<JpaExempleModel, ExempleSearchRequestDto>,
    JpaExempleCustomQuery {

}

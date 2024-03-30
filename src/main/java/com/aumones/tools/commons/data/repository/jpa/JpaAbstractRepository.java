package com.aumones.tools.commons.data.repository.jpa;

import com.aumones.tools.commons.data.model.jpa.JpaAbstractModel;
import com.aumones.tools.commons.data.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaAbstractRepository<T extends JpaAbstractModel> extends AbstractRepository<Long, T>, JpaRepository<T, Long> {

}

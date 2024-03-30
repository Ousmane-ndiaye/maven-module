package com.aumones.tools.commons.data.model;

import com.aumones.tools.commons.utils.designs.AuditMetadata;

public abstract class AbstractModel<ID> extends AuditMetadata<ID> {

  public abstract ID getId();

  public abstract void setId(ID id);
}

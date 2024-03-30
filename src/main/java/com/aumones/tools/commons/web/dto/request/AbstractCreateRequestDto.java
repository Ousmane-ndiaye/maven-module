package com.aumones.tools.commons.web.dto.request;

import com.aumones.tools.commons.data.model.AbstractModel;

public abstract class AbstractCreateRequestDto<T extends AbstractModel<?>> {

  public abstract T toModel();
}

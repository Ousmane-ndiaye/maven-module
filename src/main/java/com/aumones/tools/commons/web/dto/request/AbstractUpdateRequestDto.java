package com.aumones.tools.commons.web.dto.request;

import com.aumones.tools.commons.data.model.AbstractModel;

public abstract class AbstractUpdateRequestDto<T extends AbstractModel> {

  public abstract T toModel(T currItem);
}

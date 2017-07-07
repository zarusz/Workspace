package com.cs.fx.service.model;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by Tomasz on 06.07.2017.
 */
@Data
public class ForwardTradeDto extends FxTradeDto implements HasValueDate {

    private DateTime valueDate;

}

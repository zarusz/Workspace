package com.cs.fx.service.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class SpotTradeDto extends FxTradeDto implements HasValueDate {

    private DateTime valueDate;

}

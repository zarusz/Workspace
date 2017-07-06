package com.cs.fx.service.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class SpotTradeDto extends FxTradeDto {

    private DateTime valueDate;

}

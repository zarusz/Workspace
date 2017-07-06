package com.cs.fx.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Tomasz on 06.07.2017.
 */
@Data
public abstract class FxTradeDto extends TradeDto {

    private String ccyPair;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MMdd")
    private DateTime tradeDate;

    private BigDecimal amount1;
    private BigDecimal amount2;
    private BigDecimal rate;

}

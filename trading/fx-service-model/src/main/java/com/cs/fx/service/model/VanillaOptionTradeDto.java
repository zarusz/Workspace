package com.cs.fx.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Tomasz on 06.07.2017.
 */
@Data
public class VanillaOptionTradeDto extends FxTradeDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime tradeDate;

    private OptionStyle style;
    private OptionStrategy strategy;

    private DateTime deliveryDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MMdd")
    private DateTime expiryDate;

    private String payCcy;
    private BigDecimal premium;
    private String premiumCcy;
    private String premiumType;
    private DateTime premiumDate;

    /**
     * Applies only when style is AMERICAN.
     */
    private DateTime excerciseStartDate;
}

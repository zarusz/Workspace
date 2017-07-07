package com.cs.fx.fxservice.validation;

import com.cs.fx.service.model.ErrorCodeDto;
import com.cs.fx.service.model.TradeDto;

import java.util.List;

/**
 * Validator that performs trade validation.
 * Created by Tomasz on 07.07.2017.
 *
 */
public interface TradeValidator {

    /**
     * Check if the the validator can validate the provided trade object.
     * @param trade
     * @return
     */
    boolean canValidate(TradeDto trade);

    /**
     * Peforms validaton of the provided trade object.
     * @param trade the trade to validate.
     * @param issues the collection of issues found for the given trade.
     */
    void validate(TradeDto trade, List<ErrorCodeDto> issues);

}



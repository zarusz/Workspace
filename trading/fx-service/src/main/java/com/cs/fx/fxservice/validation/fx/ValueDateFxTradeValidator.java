package com.cs.fx.fxservice.validation.fx;

import com.cs.fx.domainmodel.CustomerRepository;
import com.cs.fx.domainmodel.ScheduleService;
import com.cs.fx.fxservice.validation.TradeValidator;
import com.cs.fx.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Checks if the value date of the trade if valid.
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class ValueDateFxTradeValidator implements TradeValidator {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean canValidate(TradeDto trade) {
        return trade instanceof FxTradeDto;
    }

    @Override
    public void validate(TradeDto trade, List<ErrorCodeDto> issues) {

        FxTradeDto fxTrade = (FxTradeDto) trade;

        if (fxTrade instanceof HasValueDate) {
            HasValueDate hasValueDate = (HasValueDate) fxTrade;

            // Rule #1
            if(hasValueDate.getValueDate().isBefore(fxTrade.getTradeDate())) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidValueDate, "Value date cannot be before trade date"));
            }

            // Rule #2
            if(!scheduleService.isWorkDayForCcyPair(fxTrade.getCcyPair(), hasValueDate.getValueDate())) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidValueDate, "Value date cannot fall on weekend or non-working day for currency"));
            }
        }
    }
}

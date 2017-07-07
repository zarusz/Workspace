package com.cs.fx.fxservice.validation;

import com.cs.fx.service.model.ErrorCodeDto;
import com.cs.fx.service.model.ErrorCodes;
import com.cs.fx.service.model.TradeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Manages the execution of each known validator against an incoming trade.
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class ValidationManager {

    private static final Logger LOG = LoggerFactory.getLogger(ValidationManager.class);

    // Note the order of validation is irrelevant.
    @Autowired
    private TradeValidator[] validators;

    public List<ErrorCodeDto> validate(TradeDto trade) {
        List<ErrorCodeDto> issues = new LinkedList<>();

        for (TradeValidator validator : validators) {
            try {
                if (validator.canValidate(trade)) {
                    LOG.debug("Executing validator {}", validator.getClass());
                    validator.validate(trade, issues);
                }
            } catch (Exception e) {
                LOG.error("Validator of type {} failed. Will have to reject the trade.", validator.getClass(), e);
                issues.add(new ErrorCodeDto(ErrorCodes.InternalError, "Internal gate error. Trade will be rejected. Please retry."));
            }
        }
        return issues;
    }

}

package com.cs.fx.fxservice.validation.fx;

import com.cs.fx.fxservice.validation.TradeValidator;
import com.cs.fx.service.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Checks if the Options trade if valid.
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class OptionsFxTradeValidator implements TradeValidator {

    @Override
    public boolean canValidate(TradeDto trade) {
        return trade instanceof VanillaOptionTradeDto;
    }

    @Override
    public void validate(TradeDto trade, List<ErrorCodeDto> issues) {

        VanillaOptionTradeDto optionsTrade = (VanillaOptionTradeDto) trade;

        if (optionsTrade.getStyle() == OptionStyle.AMERICAN) {
            // Ensure Excercise Start date is provided for american
            if (optionsTrade.getExcerciseStartDate() == null) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidExcerciseStartDate, "American style options need ExcerciseStartDate"));
            } else {
                if(!optionsTrade.getExcerciseStartDate().isAfter(optionsTrade.getTradeDate())) {
                    issues.add(new ErrorCodeDto(ErrorCodes.InvalidExcerciseStartDate, "ExcerciseStartDate must be after trade date"));
                }
                if(!optionsTrade.getExcerciseStartDate().isBefore(optionsTrade.getExpiryDate())) {
                    issues.add(new ErrorCodeDto(ErrorCodes.InvalidExcerciseStartDate, "ExcerciseStartDate must be before the expiry date"));
                }
            }
        }

        // Ensure delivery date is provided
        if (optionsTrade.getDeliveryDate() == null) {
            issues.add(new ErrorCodeDto(ErrorCodes.InvalidDeliveryDate, "Delivery date must be provided for options"));
        } else {
            // Ensure expiry date is provided
            if (optionsTrade.getExpiryDate() == null) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidExpiryDate, "Expiry date must be provided for options"));
            } else if (!optionsTrade.getExpiryDate().isBefore(optionsTrade.getDeliveryDate())) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidExpiryDate, "Expiry date must be before the delivery date"));
            }

            // Ensure premium date is provided
            if (optionsTrade.getPremiumDate() == null) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidPremiumDate, "Premium date must be provided for options"));
            } else if (!optionsTrade.getPremiumDate().isBefore(optionsTrade.getDeliveryDate())) {
                issues.add(new ErrorCodeDto(ErrorCodes.InvalidPremiumDate, "Premium date must be before the delivery date"));
            }
        }
    }
}

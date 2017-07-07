package com.cs.fx.fxservice.validation.fx;

import com.cs.fx.domainmodel.Currency;
import com.cs.fx.domainmodel.CurrencyRepository;
import com.cs.fx.fxservice.validation.TradeValidator;
import com.cs.fx.service.model.ErrorCodeDto;
import com.cs.fx.service.model.ErrorCodes;
import com.cs.fx.service.model.FxTradeDto;
import com.cs.fx.service.model.TradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Checks if the currency pair of the trade if valid.
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class CurrencyPairFxTradeValidator implements TradeValidator {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public boolean canValidate(TradeDto trade) {
        return trade instanceof FxTradeDto;
    }

    @Override
    public void validate(TradeDto trade, List<ErrorCodeDto> issues) {

        FxTradeDto fxTrade = (FxTradeDto) trade;

        String ccyPair = fxTrade.getCcyPair();
        if (ccyPair.length() != 6) {
            issues.add(new ErrorCodeDto(ErrorCodes.InvalidCurrencyPair, "The provided currency pair has an invalid length"));
        }

        String currencyIso1 = ccyPair.substring(0, 3);
        String currencyIso2 = ccyPair.substring(3);

        Currency currency1 = currencyRepository.findByIsoCode(currencyIso1);
        if (currency1 == null) {
            issues.add(new ErrorCodeDto(ErrorCodes.InvalidCurrencyPair, "The provided currency pair is invalid (unknown 1st currency)"));
        }

        Currency currency2 = currencyRepository.findByIsoCode(currencyIso2);
        if (currency2 == null) {
            issues.add(new ErrorCodeDto(ErrorCodes.InvalidCurrencyPair, "The provided currency pair is invalid (unknown 2nd currency)"));
        }
    }
}

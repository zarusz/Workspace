package com.cs.fx.fxservice.validation;

import com.cs.fx.domainmodel.LegalEntity;
import com.cs.fx.domainmodel.LegalEntityRepository;
import com.cs.fx.service.model.ErrorCodeDto;
import com.cs.fx.service.model.ErrorCodes;
import com.cs.fx.service.model.TradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Checks if the customer of the trade if valid.
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class LegalEntityTradeValidator implements TradeValidator {

    @Autowired
    private LegalEntityRepository legalEntityRepository;

    @Override
    public boolean canValidate(TradeDto trade) {
        return true;
    }

    @Override
    public void validate(TradeDto trade, List<ErrorCodeDto> issues) {

        LegalEntity legalEntity = legalEntityRepository.findById(trade.getLegalEntity());
        if (legalEntity == null) {
            issues.add(new ErrorCodeDto(ErrorCodes.InvalidLegalEntity, "The legal entity is not recognized"));
        }
    }
}

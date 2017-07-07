package com.cs.fx.fxservice.validation;

import com.cs.fx.domainmodel.Customer;
import com.cs.fx.domainmodel.CustomerRepository;
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
public class CustomerTradeValidator implements TradeValidator {

    @Autowired
    private CustomerRepository customerRespository;

    @Override
    public boolean canValidate(TradeDto trade) {
        return true;
    }

    @Override
    public void validate(TradeDto trade, List<ErrorCodeDto> issues) {

        Customer customer = customerRespository.findById(trade.getCustomer());
        if (customer == null) {
            issues.add(new ErrorCodeDto(ErrorCodes.InvalidCouterParty, "The customer is not recognized"));
        }
    }
}

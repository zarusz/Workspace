package com.cs.fx.fxservice.rest;

import com.cs.fx.fxservice.orders.OrderInformation;
import com.cs.fx.fxservice.orders.OrderManager;
import com.cs.fx.fxservice.validation.ValidationManager;
import com.cs.fx.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The REST endpoint exposed to post trades.
 * Created by Tomasz on 06.07.2017.
 */
@RestController
public class TradeRest {

    @Autowired
    private ValidationManager validationManager;

    @Autowired
    private OrderManager orderManager;

    @PostMapping(value = "/trade/batch", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BatchTradeResultDto submitBatch(@RequestBody List<TradeDto> trades) {
        BatchTradeResultDto batchResult = new BatchTradeResultDto();

        for (TradeDto trade : trades) {
            TradeResultDto tradeResult = ProcessTrade(batchResult, trade);
            batchResult.getResults().add(tradeResult);
        }

        return batchResult;
    }

    private TradeResultDto ProcessTrade(BatchTradeResultDto batchResult, TradeDto trade) {
        TradeResultDto tradeResult = new TradeResultDto();

        List<ErrorCodeDto> issues = validationManager.validate(trade);
        if (issues.isEmpty()) {
            OrderInformation orderInformation = orderManager.executeTrade(trade);

            tradeResult.setSuccess(true);
            // generate a TX id
            tradeResult.setTransactionId(orderInformation.getTransactionId());
        } else {
            tradeResult.setSuccess(false);
            tradeResult.setErrors(issues);
        }
        return tradeResult;
    }
}

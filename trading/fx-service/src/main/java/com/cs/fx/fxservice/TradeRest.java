package com.cs.fx.fxservice;

import com.cs.fx.service.model.BatchTradeResultDto;
import com.cs.fx.service.model.TradeDto;
import com.cs.fx.service.model.TradeResultDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tomasz on 06.07.2017.
 */
@RestController
public class TradeRest {

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    @PostMapping(value = "/trade/batch", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BatchTradeResultDto submitBatch(@RequestBody List<TradeDto> trades) {
        BatchTradeResultDto batchResult = new BatchTradeResultDto();

        for (TradeDto trade : trades) {
            TradeResultDto tradeResult = new TradeResultDto();

            // generate a TX id
            tradeResult.setTransactionId(UUID.randomUUID().toString());
            tradeResult.setSuccess(true);

            batchResult.getResults().add(tradeResult);
        }

        return batchResult;
    }
}

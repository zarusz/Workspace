package com.cs.fx.fxclient;

import com.cs.fx.fxclient.config.RestTemplateConfiguration;
import com.cs.fx.fxclient.utils.SampleUtil;
import com.cs.fx.service.model.BatchTradeResultDto;
import com.cs.fx.service.model.ErrorCodeDto;
import com.cs.fx.service.model.TradeDto;
import com.cs.fx.service.model.TradeResultDto;
import com.cs.fx.service.model.config.SerializationConfiguration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by Tomasz on 06.07.2017.
 */
@SpringBootApplication
@Import({SerializationConfiguration.class, RestTemplateConfiguration.class})
public class MainApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        // See example: https://github.com/spring-projects/spring-boot/blob/v1.4.2.RELEASE/spring-boot-samples/spring-boot-sample-simple/src/main/java/sample/simple/SampleSimpleApplication.java
        SpringApplication.run(MainApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${service.url}")
    private String serviceUrl;
    @Value("${service.batch_method}")
    private String serviceBatchMethod;

    @Override
    public void run(String[] args) throws IOException {
        // Get sample trades
        List<TradeDto> trades = loadSampleTrades();

        // Call REST service
        BatchTradeResultDto batchResult;
        try {
            batchResult = postTrades(trades);
        } catch (ResourceAccessException e) {
            LOG.error("Failed to post trades to REST service. Client will terminate.", e);
            return;
        }

        LOG.info("Got response from REST service.");

        for(int tradeIndex = 0; tradeIndex < trades.size(); tradeIndex++) {
            TradeResultDto tradeResult = batchResult.getResults().get(tradeIndex);

            int tradeNumber = tradeIndex + 1;

            LOG.info("Trade #{} was {}", tradeNumber, tradeResult.isSuccess() ? "successful" : "failed");
            if (tradeResult.isSuccess()) {
                LOG.info("Trade #{} transaction ID is {}", tradeNumber, tradeResult.getTransactionId());
            } else {
                int errorNumber = 0;
                for (ErrorCodeDto errorCode: tradeResult.getErrors()) {
                    LOG.error("Trade #{} validation error #{} - code: {} message: {}", tradeNumber, errorNumber, tradeResult.getTransactionId(), errorCode.getCode(), errorCode.getMessage());
                    errorNumber++;
                }
            }
        }
    }

    /**
     * Posts trades to the REST service
     * @param trades
     * @return
     * @throws ResourceAccessException
     */
    private BatchTradeResultDto postTrades(List<TradeDto> trades) throws ResourceAccessException {
        String url = serviceUrl + serviceBatchMethod;
        LOG.info("Posting trades to REST service ({})...", url);
        // See example: https://spring.io/guides/gs/consuming-rest/
        BatchTradeResultDto batchResult = restTemplate.postForObject(url, trades, BatchTradeResultDto.class);
        return batchResult;
    }

    /**
     * Loads sample trades fom the embedded JSON resource
     * @return
     * @throws IOException
     */
    private List<TradeDto> loadSampleTrades() throws IOException {
        LOG.info("Loading sample trades...");
        String content = SampleUtil.loadSample("/test-trade-data.json");
        TypeReference<List<TradeDto>> typeReference = new TypeReference<List<TradeDto>>() {};
        List<TradeDto> trades = objectMapper.readValue(content, typeReference);
        return trades;
    }
}

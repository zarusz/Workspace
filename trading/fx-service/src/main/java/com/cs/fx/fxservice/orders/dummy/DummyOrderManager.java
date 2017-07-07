package com.cs.fx.fxservice.orders.dummy;

import com.cs.fx.fxservice.orders.OrderInformation;
import com.cs.fx.fxservice.orders.OrderManager;
import com.cs.fx.service.model.TradeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Dummy order manager that submits the validated trades into the processing queues
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class DummyOrderManager implements OrderManager {

    private static final Logger LOG = LoggerFactory.getLogger(DummyOrderManager.class);

    @Override
    public OrderInformation executeTrade(TradeDto tradeDto) {

        OrderInformation oi = new OrderInformation(UUID.randomUUID().toString());

        LOG.info("Processing trade ... Assigned transaction ID: {}", oi.getTransactionId());

        return oi;
    }

}

package com.cs.fx.fxservice.orders;

import com.cs.fx.service.model.TradeDto;

/**
 * Created by Tomasz on 07.07.2017.
 */
public interface OrderManager {

    OrderInformation executeTrade(TradeDto tradeDto);
}

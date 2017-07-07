package com.cs.fx.service.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 07.07.2017.
 */
@Data
public class BatchTradeResultDto {

    private List<TradeResultDto> results = new ArrayList<>();

}

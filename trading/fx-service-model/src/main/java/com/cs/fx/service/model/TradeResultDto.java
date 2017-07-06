package com.cs.fx.service.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 06.07.2017.
 */
@Data
public class TradeResultDto {

    private boolean success;
    private String transactionId;

    private List<ErrorCodeDto> errors = new ArrayList<ErrorCodeDto>();
}



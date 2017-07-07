package com.cs.fx.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz on 06.07.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorCodeDto {

    private String code;
    private String message;

}

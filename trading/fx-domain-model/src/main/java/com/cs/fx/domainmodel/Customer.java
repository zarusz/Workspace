package com.cs.fx.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Aggregate root representing the customer.
 * Created by Tomasz on 07.07.2017.
 */
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String id;
    private String name;

}

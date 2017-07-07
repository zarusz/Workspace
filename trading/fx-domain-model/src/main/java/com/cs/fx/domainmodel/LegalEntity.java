package com.cs.fx.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Aggregate root representing the legal entity.
 * Created by Tomasz on 07.07.2017.
 */
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntity {

    private String id;
    private String name;

}

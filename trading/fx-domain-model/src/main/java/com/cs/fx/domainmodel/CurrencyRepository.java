package com.cs.fx.domainmodel;

/**
 * Created by Tomasz on 07.07.2017.
 */
public interface CurrencyRepository extends Repository<Currency, Integer> {

    Currency findByIsoCode(String isoCode);

}

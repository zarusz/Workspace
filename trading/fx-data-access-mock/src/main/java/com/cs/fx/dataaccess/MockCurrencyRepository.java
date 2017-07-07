package com.cs.fx.dataaccess;

import com.cs.fx.domainmodel.Currency;
import com.cs.fx.domainmodel.CurrencyRepository;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class MockCurrencyRepository implements CurrencyRepository {

    private Map<Integer, Currency> currencyById = new HashMap<>();
    private Map<String, Currency> currencyByIsoCode = new HashMap<>();

    public MockCurrencyRepository() {
        String[] codes = new String[]{
                "EUR", "USD", "PLN", "CAD"
        };

        List<Currency> all = new LinkedList<>();
        for (int i = 0; i < codes.length; i++) {
            all.add(new Currency(1, codes[i]));
        }

        all.stream().forEach(x -> {
            currencyById.put(x.getId(), x);
            currencyByIsoCode.put(x.getIsoCode(), x);
        });
    }

    @Override
    public Currency findById(Integer id) {
        return currencyById.getOrDefault(id, null);
    }

    @Override
    public Currency findByIsoCode(String isoCode) {
        return currencyByIsoCode.getOrDefault(isoCode, null);
    }
}

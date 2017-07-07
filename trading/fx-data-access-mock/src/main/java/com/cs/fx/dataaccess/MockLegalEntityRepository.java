package com.cs.fx.dataaccess;

import com.cs.fx.domainmodel.LegalEntity;
import com.cs.fx.domainmodel.LegalEntityRepository;

/**
 * Created by Tomasz on 07.07.2017.
 */
public class MockLegalEntityRepository implements LegalEntityRepository {

    private static final String ID1 = "CS Zurich";

    @Override
    public LegalEntity findById(String id) {
        if (ID1.equals(id)) {
            return new LegalEntity(ID1, "Credit Suisse Zurich");
        }
        return null;
    }
}

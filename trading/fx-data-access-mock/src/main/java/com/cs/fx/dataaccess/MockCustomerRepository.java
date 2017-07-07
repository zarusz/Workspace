package com.cs.fx.dataaccess;

import com.cs.fx.domainmodel.Customer;
import com.cs.fx.domainmodel.CustomerRepository;

/**
 * Created by Tomasz on 07.07.2017.
 */
public class MockCustomerRepository implements CustomerRepository {

    private static final String ID1 = "PLUTO1";
    private static final String ID2 = "PLUTO2";

    @Override
    public Customer findById(String id) {
        if (ID1.equals(id)) {
            return new Customer(ID1, "PLUTO 1");
        }
        if (ID2.equals(id)) {
            return new Customer(ID2, "PLUTO 2");
        }
        return null;
    }
}

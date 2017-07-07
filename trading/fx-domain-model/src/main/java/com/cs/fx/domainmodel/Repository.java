package com.cs.fx.domainmodel;

/**
 * Common interface across all repositories.
 * Created by Tomasz on 07.07.2017.
 */
public interface Repository<T, K> {

    T findById(K id);

}

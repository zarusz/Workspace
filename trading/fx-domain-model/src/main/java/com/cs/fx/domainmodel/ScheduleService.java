package com.cs.fx.domainmodel;

import org.joda.time.DateTime;

/**
 * Service that provides insight into the calendar.
 * Created by Tomasz on 07.07.2017.
 */
public interface ScheduleService {

    DateTime getCurrentDateForCcyPair(String ccyPair);

    boolean isWorkDayForCcyPair(String ccyPair, DateTime date);

}

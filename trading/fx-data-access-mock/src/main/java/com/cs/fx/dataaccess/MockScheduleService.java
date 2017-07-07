package com.cs.fx.dataaccess;

import com.cs.fx.domainmodel.ScheduleService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz on 07.07.2017.
 */
@Component
public class MockScheduleService implements ScheduleService {
    // assumption that current date is 09.10.2016
    private final DateTime fixedDate = new DateTime("2016-10-09");

    public DateTime getCurrentDateForCcyPair(String ccyPair) {
        // let's make it same date for all currencies
        return fixedDate;
    }

    @Override
    public boolean isWorkDayForCcyPair(String ccyPair, DateTime date) {
        // let's assume that as long as it's a workday there is no holidays.
        // normally we would have a lookup table or pull this from config.
        int dow = date.getDayOfWeek();
        return dow != DateTimeConstants.SATURDAY && dow != DateTimeConstants.SUNDAY;
    }
}

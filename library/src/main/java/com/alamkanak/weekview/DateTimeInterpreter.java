package com.alamkanak.weekview;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * Created by Raquib on 1/6/2015.
 */
public interface DateTimeInterpreter {
    String interpretDate(DayOfWeek day);

    String interpretTime(int hour, int minutes);
}

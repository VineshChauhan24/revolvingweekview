package com.alamkanak.weekview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MonthLoader implements WeekViewLoader {

    private MonthChangeListener mOnMonthChangeListener;

    public MonthLoader(MonthChangeListener listener) {
        this.mOnMonthChangeListener = listener;
    }

    @Override
    public List<? extends WeekViewEvent> onLoad() {
        return mOnMonthChangeListener.onMonthChange();
    }

    public MonthChangeListener getOnMonthChangeListener() {
        return mOnMonthChangeListener;
    }

    public void setOnMonthChangeListener(MonthChangeListener onMonthChangeListener) {
        this.mOnMonthChangeListener = onMonthChangeListener;
    }

    public interface MonthChangeListener {
        /**
         * <p>Very important interface, it's the base to load events in the calendar.
         * This method is called three times: once to load the previous month, once to load the next month and once
         * to load the current month.</p>
         * <strong>That's why you can have three times the same event at the same place if you mess up with the
         * configuration</strong>
         *
         * @param newYear : year of the events required by the view.
         * @param newMonth : <p>month of the events required by the view </p><strong>1 based (not like JAVA API) :
         * January = 1 and December = 12</strong>.
         * @return a list of the events happening <strong>during the specified month</strong>.
         */
        List<? extends WeekViewEvent> onMonthChange();
    }
}

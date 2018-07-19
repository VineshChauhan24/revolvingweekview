package com.alamkanak.weekview;

import android.support.annotation.NonNull;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class DayTime implements Comparable<DayTime> {

    private LocalTime time;
    private DayOfWeek day;

    public DayTime(DayTime dayTime) {
        this.time = dayTime.time; // LocalTime is immutable
        this.day = dayTime.day;
    }

    /**
     * Create a DayTime object event.
     * @param day A {@link DayOfWeek# day of the week}.
     * @param time The {@link LocalTime# time}.
     */
    public DayTime(DayOfWeek day, LocalTime time) {
        this.time = time;
        this.day = day;
    }

    /**
     * Create a DayTime object event.
     * @param day A {@link DayOfWeek day of the week}.
     * @param hour Hour of day from 0-23.
     * @param minute Minute of day from 0-59.
     */
    public DayTime(DayOfWeek day, int hour, int minute) {
        this(day, LocalTime.of(hour, minute));
    }

    /**
     * Create a DayTime object event.
     * @param day Integer representing a day of the week based on {@link DayOfWeek}
     * @param hour Hour of day from 0-23.
     * @param minute Minute of day from 0-59.
     */
    public DayTime(int day, int hour, int minute) {
        this(DayOfWeek.of(day), hour, minute);
    }

    /**
     * Create a DayTime object event.
     * @param day Integer representing a day of the weej based on {@link DayOfWeek}
     * @param time The {@link LocalTime# time}.
     */
    public DayTime(int day, LocalTime time) {
        this(DayOfWeek.of(day), time);
    }

    /**
     * Default constructor with no parameters.
     */
    public DayTime() {}

    public DayTime(LocalDateTime localDateTime) {
        this.day = localDateTime.getDayOfWeek();
        this.time = localDateTime.toLocalTime();
    }

    @Override
    public int compareTo(@NonNull DayTime dayTime) {
        if (this.day == dayTime.day) {
            return this.time.compareTo(dayTime.time);
        } else {
            return this.day.compareTo(dayTime.day);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DayTime dayTime = (DayTime) o;
        return Objects.equals(time, dayTime.time) &&
                day == dayTime.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, day);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setTime(int hour, int minute) {
        this.time = time.withHour(hour).withMinute(minute);
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    /**
     * Sets the day of week based on values in #{@link DayOfWeek}.
     * @param day Integer representing the day of the week.
     */
    public void setDay(int day) {
        this.day = DayOfWeek.of(day);
    }

    /**
     * Adds hours to this time.
     * @param hours Hours to add.
     */
    public void addHours(int hours) {
        this.time = this.time.plusHours(hours);
    }

    /**
     * Subtracts minutes from this time.
     * @param minutes Minutes to substract.
     */
    public void subtractMinutes(int minutes) {
        this.time = this.time.minusMinutes(minutes);
    }

    /**
     * Adds minutes to this time.
     * @param minutes Minutes to add.
     */
    public void addMinutes(int minutes) {
        this.time = this.time.plusMinutes(minutes);
    }

    /**
     * Sets time to minimum time of 0:00.
     */
    public void setMinimumTime() {
        this.time = LocalTime.MIN;
    }

    /**
     * Adds days to this DayTime object.
     * @param days Days to add.
     */
    public void addDays(int days) {
        this.day = this.day.plus(days);
    }

    /**
     * Get this DayTime object as a numerical unit of NanoSeconds + DayValue.
     * @return A number representing the day.
     */
    public long toNumericalUnit() {
        return (this.getTime().toNanoOfDay()) + this.getDay().getValue();
    }

    /**
     * Get minute in time.
     * @return Minute in time.
     */
    public int getMinute() {
        return this.time.getMinute();
    }

    /**
     * Get hour in time
     * @return Hour in time.
     */
    public int getHour() {
        return this.time.getHour();
    }

    /**
     * Check if this DayTime is before.
     * @param otherDayTime Other DayTime to compare to.
     * @return true if it is before else false.
     */
    public boolean isBefore(DayTime otherDayTime) {
        return this.compareTo(otherDayTime) < 0;
    }

    /**
     * Check if this DayTime is after.
     * @param otherDayTime Other DayTime to compare to.
     * @return true if it is after else false.
     */
    public boolean isAfter(DayTime otherDayTime) {
        return this.compareTo(otherDayTime) > 0;
    }

    /**
     * Check if this DayTime is same.
     * @param otherDayTime Other DayTime to compare to.
     * @return true if it is same time else false.
     */
    public boolean isSame(DayTime otherDayTime) {
        return this.compareTo(otherDayTime) == 0;
    }
}

package com.orangeandbronze;

/**
 * Created by training on 2/19/16.
 */

enum Days {MTH, TF, WS}
enum Period {H0830, H1000, H1130, H1300, H1430, H1600}

public class Schedule {
    private final Days days;
    private final Period period;

    Schedule(Days days, Period period) {
        this.days = days;
        this.period = period;
    }

    public Days getDays() {
        return days;
    }

    public Period getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "Schedule: " + days + " " + period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (days != schedule.days) return false;
        return period == schedule.period;

    }

    @Override
    public int hashCode() {
        int result = days.hashCode();
        result = 31 * result + period.hashCode();
        return result;
    }
}

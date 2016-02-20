package com.orangeandbronze;

import java.util.HashMap;
import java.util.Map;

enum Days {
    MTH, TF, WS
}

enum Period {
    H0830, H0900, H1000, H1030, H1100, H1130, H1300, H1330, H1400, H1430, H1600
}

public class Schedule {
    private final Days days;
    private final Period startPeriod;
    private final Period endPeriod;
    private static final Map<Period, Integer> time;

    Schedule(Days days, Period periodStart, Period periodEnd) {
        this.days = days;
        this.startPeriod = periodStart;
        this.endPeriod = periodEnd;
    }

    static {
        time = new HashMap<Period, Integer>();
        for (Period period : Period.values()) {
            time.put(period, Integer.parseInt(period.name().substring(1, period.name().length())));
        }
    }

    int getTimeValueStartPeriod(Schedule schedule) {
        return time.get(schedule.startPeriod);
    }

    int getTimeValueEndPeriod(Schedule schedule) {
        return time.get(schedule.endPeriod);
    }


    @Override
    public String toString() {
        return days + " " + startPeriod + " - " + endPeriod;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((days == null) ? 0 : days.hashCode());
        result = prime * result + ((startPeriod == null) ? 0 : startPeriod.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Schedule other = (Schedule) obj;
        if (days != other.days)
            return false;
        if (startPeriod != other.startPeriod)
            return false;
        return true;
    }
}

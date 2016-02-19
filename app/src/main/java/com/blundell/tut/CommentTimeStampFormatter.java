package com.blundell.tut;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class CommentTimeStampFormatter {

    public String format(Date commentedAt) {
        long millisFromNow = getMillisFromNow(commentedAt);

        long minutesFromNow = TimeUnit.MILLISECONDS.toMinutes(millisFromNow);
        if (minutesFromNow < 1) {
            return "just now";
        }
        long hoursFromNow = TimeUnit.MILLISECONDS.toHours(millisFromNow);
        if (hoursFromNow < 1) {
            return formatMinutes(minutesFromNow);
        }
        long daysFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow);
        if (daysFromNow < 1) {
            return formatHours(hoursFromNow);
        }
        long weeksFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow) / 7;
        if (weeksFromNow < 1) {
            return formatDays(daysFromNow);
        }
        long monthsFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow) / 7 / 30;
        if (monthsFromNow < 1) {
            return formatWeeks(weeksFromNow);
        }
        long yearsFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow) / 7 / 30 / 365;
        if (yearsFromNow < 1) {
            return formatMonths(monthsFromNow);
        }
        return formatYears(yearsFromNow);
    }

    private long getMillisFromNow(Date commentedAt) {
        long commentedAtMillis = commentedAt.getTime();
        long nowMillis = System.currentTimeMillis();
        return nowMillis - commentedAtMillis;
    }

    private String formatMinutes(long minutes) {
        return format(minutes, " minute ago", " minutes ago");
    }

    private String formatHours(long hours) {
        return format(hours, " hour ago", " hours ago");
    }

    private String formatDays(long days) {
        return format(days, " day ago", " days ago");
    }

    private String formatWeeks(long weeks) {
        return format(weeks, " week ago", " weeks ago");
    }

    private String formatMonths(long months) {
        return format(months, " month ago", " months ago");
    }

    private String formatYears(long years) {
        return format(years, " year ago", " years ago");
    }

    private String format(long hand, String singular, String plural) {
        if (hand == 1) {
            return hand + singular;
        } else {
            return hand + plural;
        }
    }

}

package com.blundell.tut

import java.util.Date
import java.util.concurrent.TimeUnit

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.Hours
import org.joda.time.Minutes
import org.joda.time.Months
import org.joda.time.Weeks
import org.joda.time.Years

class TimeStampFormatter {

    /**
     * For use with java.util.Date
     */
    fun format(timestamp: Date?): String {
        val millisFromNow = getMillisFromNow(timestamp)

        val minutesFromNow = TimeUnit.MILLISECONDS.toMinutes(millisFromNow)
        if (minutesFromNow < 1) {
            return "just now"
        }
        val hoursFromNow = TimeUnit.MILLISECONDS.toHours(millisFromNow)
        if (hoursFromNow < 1) {
            return formatMinutes(minutesFromNow)
        }
        val daysFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow)
        if (daysFromNow < 1) {
            return formatHours(hoursFromNow)
        }
        val weeksFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow) / 7
        if (weeksFromNow < 1) {
            return formatDays(daysFromNow)
        }
        val monthsFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow) / 30
        if (monthsFromNow < 1) {
            return formatWeeks(weeksFromNow)
        }
        val yearsFromNow = TimeUnit.MILLISECONDS.toDays(millisFromNow) / 365
        return if (yearsFromNow < 1) {
            formatMonths(monthsFromNow)
        } else formatYears(yearsFromNow)
    }

    private fun getMillisFromNow(commentedAt: Date?): Long {
        val commentedAtMillis = commentedAt?.time
        val nowMillis = System.currentTimeMillis()
        return nowMillis - commentedAtMillis!!
    }

    /**
     * For use with org.joda.DateTime
     */
    fun format(commentedAt: DateTime): String {
        val now = DateTime.now()
        val minutesBetween = Minutes.minutesBetween(commentedAt, now)
        if (minutesBetween.isLessThan(Minutes.ONE)) {
            return "just now"
        }
        val hoursBetween = Hours.hoursBetween(commentedAt, now)
        if (hoursBetween.isLessThan(Hours.ONE)) {
            return formatMinutes(minutesBetween.minutes.toLong())
        }
        val daysBetween = Days.daysBetween(commentedAt, now)
        if (daysBetween.isLessThan(Days.ONE)) {
            return formatHours(hoursBetween.hours.toLong())
        }
        val weeksBetween = Weeks.weeksBetween(commentedAt, now)
        if (weeksBetween.isLessThan(Weeks.ONE)) {
            return formatDays(daysBetween.days.toLong())
        }
        val monthsBetween = Months.monthsBetween(commentedAt, now)
        if (monthsBetween.isLessThan(Months.ONE)) {
            return formatWeeks(weeksBetween.weeks.toLong())
        }
        val yearsBetween = Years.yearsBetween(commentedAt, now)
        return if (yearsBetween.isLessThan(Years.ONE)) {
            formatMonths(monthsBetween.months.toLong())
        } else formatYears(yearsBetween.years.toLong())
    }

    private fun formatMinutes(minutes: Long): String {
        return format(minutes, " minute ago", " minutes ago")
    }

    private fun formatHours(hours: Long): String {
        return format(hours, " hour ago", " hours ago")
    }

    private fun formatDays(days: Long): String {
        return format(days, " day ago", " days ago")
    }

    private fun formatWeeks(weeks: Long): String {
        return format(weeks, " week ago", " weeks ago")
    }

    private fun formatMonths(months: Long): String {
        return format(months, " month ago", " months ago")
    }

    private fun formatYears(years: Long): String {
        return format(years, " year ago", " years ago")
    }

    private fun format(hand: Long, singular: String, plural: String): String {
        return if (hand == 1L) {
            hand.toString() + singular
        } else {
            hand.toString() + plural
        }
    }

}

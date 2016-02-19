package com.blundell.tut;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeStampFormatterTest {

    private static final int DAYS_IN_A_WEEK = 7;
    private static final int AVERAGE_DAYS_IN_A_MONTH = 30;
    private static final int DAYS_IN_YEAR = 365; // We don't need the level of accuracy of leap years

    @Test
    public void givenCommentedUnder60SecondsAgo_thenFormatSaysJustNow() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusSeconds(59, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("just now", commentedAtFormatted);
    }

    @Test
    public void givenCommented1MinuteAgo_thenFormatSays1MinuteAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusMinutes(1, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 minute ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedUnder60MinuteAgo_thenFormatSaysXMinutesAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusMinutes(59, minusSeconds(59, now()));

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("59 minutes ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1HourAgo_thenFormatSays1HourAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusHours(1, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 hour ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedUnder24HoursAgo_thenFormatSaysXHoursAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusHours(23, minusMinutes(59, now()));

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("23 hours ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1DayAgo_thenFormatSays1DayAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusDays(1, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 day ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedLessThan7DayAgo_thenFormatSaysXDaysAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusDays(6, minusHours(23, minusMinutes(59, now())));

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("6 days ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1WeekAgo_thenFormatSays1WeekAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusWeeks(1, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 week ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedLessThan4WeeksAgo_thenFormatSaysXWeeksAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusWeeks(3, minusDays(6, minusHours(23, minusMinutes(59, now()))));

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("3 weeks ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1MonthAgo_thenFormatSays1MonthAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusMonths(1, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 month ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedLessThan1YearAgo_thenFormatSaysXMonthsAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusMonths(11, minusWeeks(3, minusDays(6, minusHours(23, minusMinutes(59, now())))));

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("11 months ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1YearAgo_thenFormatSays1YearAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusYears(1, now());

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 year ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedOver1YearAgo_thenFormatSaysXYearsAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        Date commentedAt = minusYears(2, minusMonths(11, minusWeeks(3, minusDays(6, minusHours(23, minusMinutes(59, now()))))));

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("2 years ago", commentedAtFormatted);
    }

    private Date minusSeconds(int seconds, Date date) {
        return minus(date, TimeUnit.SECONDS.toMillis(seconds));
    }

    private Date minusMinutes(int minutes, Date date) {
        return minus(date, TimeUnit.MINUTES.toMillis(minutes));
    }

    private Date minusHours(int hours, Date date) {
        return minus(date, TimeUnit.HOURS.toMillis(hours));
    }

    private Date minusDays(int days, Date date) {
        return minus(date, TimeUnit.DAYS.toMillis(days));
    }

    private Date minusWeeks(int weeks, Date date) {
        return minus(date, TimeUnit.DAYS.toMillis(weeks * DAYS_IN_A_WEEK));
    }

    private Date minusMonths(int months, Date date) {
        return minus(date, TimeUnit.DAYS.toMillis(months * AVERAGE_DAYS_IN_A_MONTH));
    }

    private Date minusYears(int years, Date date) {
        return minus(date, TimeUnit.DAYS.toMillis(years * DAYS_IN_YEAR));
    }

    private Date minus(Date date, long minutesInMillis) {
        date.setTime(date.getTime() - minutesInMillis);
        return date;
    }

    private Date now() {
        return new Date();
    }
}

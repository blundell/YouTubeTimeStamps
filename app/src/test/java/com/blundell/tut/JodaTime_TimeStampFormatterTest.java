package com.blundell.tut;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JodaTime_TimeStampFormatterTest {

    @Test
    public void givenCommentedUnder60SecondsAgo_thenFormatSaysJustNow() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusSeconds(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("just now", commentedAtFormatted);
    }

    @Test
    public void givenCommented1MinuteAgo_thenFormatSays1MinuteAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusMinutes(1);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 minute ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedUnder60MinuteAgo_thenFormatSaysXMinutesAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusMinutes(59).minusSeconds(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("59 minutes ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1HourAgo_thenFormatSays1HourAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusHours(1);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 hour ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedUnder24HoursAgo_thenFormatSaysXHoursAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusHours(23).minusMinutes(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("23 hours ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1DayAgo_thenFormatSays1DayAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusDays(1);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 day ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedLessThan7DayAgo_thenFormatSaysXDaysAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusDays(6).minusHours(23).minusMinutes(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("6 days ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1WeekAgo_thenFormatSays1WeekAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusWeeks(1);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 week ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedLessThan4WeeksAgo_thenFormatSaysXWeeksAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusWeeks(3).minusDays(6).minusHours(23).minusMinutes(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("3 weeks ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1MonthAgo_thenFormatSays1MonthAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusMonths(1);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 month ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedLessThan1YearAgo_thenFormatSaysXMonthsAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusMonths(11).minusWeeks(3).minusDays(6).minusHours(23).minusMinutes(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("11 months ago", commentedAtFormatted);
    }

    @Test
    public void givenCommented1YearAgo_thenFormatSays1YearAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusYears(1);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("1 year ago", commentedAtFormatted);
    }

    @Test
    public void givenCommentedOver1YearAgo_thenFormatSaysXYearsAgo() throws Exception {
        TimeStampFormatter formatter = new TimeStampFormatter();
        DateTime commentedAt = DateTime.now().minusYears(2).minusMonths(11).minusWeeks(3).minusDays(6).minusHours(23).minusMinutes(59);

        String commentedAtFormatted = formatter.format(commentedAt);

        assertEquals("2 years ago", commentedAtFormatted);
    }
}

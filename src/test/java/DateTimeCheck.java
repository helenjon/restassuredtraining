import org.assertj.core.api.SoftAssertions;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeCheck {

    @Test
    public void verifyPassedNameAndDetailsOfStages() {
        List<String> dateTimeList = new ArrayList<>();
        dateTimeList.add("18:20 - Mon Oct 27");
        dateTimeList.add("18:25 - Mon Oct 27");
        dateTimeList.add("18:30 - Mon Oct 27");
        dateTimeList.add("18:35 - Mon Oct 27");
        dateTimeList.add("18:40 - Mon Oct 27");
        List<Calendar> dateTimeCal = appendCalendar(dateTimeList);
        assertCheckDetailsOfStagesDateTime(dateTimeCal);
    }


    private void assertCheckDetailsOfStagesDateTime(List<Calendar> dateTimeCal) {
        SoftAssertions softy = new SoftAssertions();
        for (int i = 0; i < dateTimeCal.size() - 1; i++) {
            Calendar previousDate = dateTimeCal.get(i);
            Calendar nextDate = dateTimeCal.get(i + 1);
            softy.assertThat(chekPreviousBeforeNext(previousDate, nextDate))
                    .as(String.format("FAILED. previousDate %s is bigger %s ", new DateTime(previousDate), new DateTime(nextDate)))
                    .isEqualTo(true);
        }
        softy.assertAll();
    }

    private List<Calendar> appendCalendar(List<String> dateTimeList) {
        List<Calendar> dateTimeCal = new ArrayList<>();
        String timeFormatPattern = "HH:mm - EEE MMM d";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormatPattern);
        dateTimeList.forEach(e -> {
            try {
                Date date = simpleDateFormat.parse(e);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                dateTimeCal.add(cal);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });
        return dateTimeCal;
    }

    private boolean chekPreviousBeforeNext(Calendar previousDate, Calendar nextDate) {
        return previousDate.before(nextDate);
    }

}

package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DateTimeMapping {

    ZoneId zEastern=ZoneId.of("America/New_York");
    ZoneId zPacific=ZoneId.of("America/Los_Angeles");
    ZoneId zUTC=ZoneId.of("UTC");
    ZoneId zoneId=ZoneId.systemDefault();

    // Input: Year, Month, Day, Hour, Minute, Second, NanoSecond, ZoneId
    ZonedDateTime specificTime = ZonedDateTime.of(2026, 10, 13, 17, 30, 0, 0, zoneId);


    /*LocalDateTime localDateTime=LocalDateTime.now();
    ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);*/

    ZonedDateTime zonedDateTimeEastern=specificTime.withZoneSameInstant(zEastern);
    LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();

    ZonedDateTime zonedDateTimePacific=specificTime.withZoneSameInstant(zPacific);
    LocalDateTime localDateTimePacific=zonedDateTimePacific.toLocalDateTime();

    ZonedDateTime zonedDateTimeUTC = specificTime.withZoneSameInstant(zUTC);
    LocalDateTime localDateTimeUTC=zonedDateTimeUTC.toLocalDateTime();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @RequestMapping(path = "/easternTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showEasternTime()  {

        return localDateTimeEastern.format(formatter) + " Eastern Time";
    }

    @RequestMapping(path = "/pacificTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String pacificTime()  {

        return localDateTimePacific.format(formatter) + " Mountain Time";
    }

    @RequestMapping(path = "/UTCTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String UTCTime()  {

        return localDateTimeUTC.format(formatter) + " UTC";
    }

    @RequestMapping(path = "/livePresentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String livePresentation()  {

        return "Join us for a online live presentation held at the Landon Hotel on October " +
                "13, 2026 at";
    }
}

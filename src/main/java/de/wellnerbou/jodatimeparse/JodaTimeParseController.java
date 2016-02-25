package de.wellnerbou.jodatimeparse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JodaTimeParseController {

	@RequestMapping("/parse")
	public DateTime parse(@RequestParam(value = "format") String dateFormat, @RequestParam(value = "datestr") String dateStr) {
		final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormat);
		return dateTimeFormatter.parseDateTime(dateStr);
	}
}

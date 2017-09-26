package de.wellnerbou.jodatimeparse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class JavaTimeParseController {

	@RequestMapping("/parse")
	public Map<String, Object> parse(@RequestParam(value = "format") String dateFormat, @RequestParam(value = "datestr") String dateStr) {
		final TemporalAccessor temporalAccessor = getTemporalAccessor(dateFormat, dateStr);
		return createMapFromTemporalAccessor(temporalAccessor);
	}

	TemporalAccessor getTemporalAccessor(final @RequestParam(value = "format") String dateFormat, final @RequestParam(value = "datestr") String dateStr) {
		final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
		return dateTimeFormatter.parse(dateStr);
	}

	private Map<String, Object> createMapFromTemporalAccessor(final TemporalAccessor temporalAccessor) {
		return Arrays.stream(ChronoField.values()).filter(temporalAccessor::isSupported).collect(Collectors.toMap(ChronoField::toString, (Function<ChronoField, Object>) temporalAccessor::getLong));
	}
}

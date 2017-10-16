package de.wellnerbou.jodatimeparse;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class JavaTimeParseControllerTest {

	@Test(expected = DateTimeException.class)
	public void testJava8DateApi_localTimeWithoutYear() {
		final TemporalAccessor result = new JavaTimeParseController().getTemporalAccessor("MMM dd 'at' HH:mm", "May 13 at 23:28");
		LocalDateTime.from(result);
	}

	@Test
	public void testJava8DateApi_localTimeWithYear() {
		final TemporalAccessor result = new JavaTimeParseController().getTemporalAccessor("MMM dd 'at' HH:mm, yyyy", "May 13 at 23:28, 2017");
		LocalDateTime.from(result);
	}

	@Test
	public void testParseJava8DateApi_localTimeWithYear() {
		final Map<String, Object> result = new JavaTimeParseController().parse("MMM dd 'at' HH:mm, yyyy", "May 13 at 23:28, 2017");
	}

	/**
	 * See https://github.com/paulwellnerbou/java-time-parse-debugger/issues/1
	 */
	@Test
	public void testParseJava8DateApi_withOffset() {
		final Map<String, Object> result = new JavaTimeParseController().parse("dd/MMM/yyyy:HH:mm:ss Z", "11/Oct/2017:13:30:26 +0200");
		Assertions.assertThat(result).containsEntry("Year", 2017L);
		Assertions.assertThat(result).containsEntry("ClockHourOfDay", 13L);
		Assertions.assertThat(result).containsEntry("OffsetSeconds", 7200L);
	}

	@Test(expected = DateTimeException.class)
	public void testJava8DateApi_ZonedTimeWithoutZone() {
		final TemporalAccessor result = new JavaTimeParseController().getTemporalAccessor("MMM dd 'at' HH:mm, yyyy", "May 13 at 23:28, 2017");
		ZonedDateTime.from(result);
	}

	@Test
	public void parse() {
		final Object result = new JavaTimeParseController().parse("MMM dd 'at' HH:mm", "May 13 at 23:28");
		assertThat(result).isNotNull();
	}
}

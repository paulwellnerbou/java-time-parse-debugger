package de.wellnerbou.jodatimeparse;

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

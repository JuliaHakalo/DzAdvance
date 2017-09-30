package ua.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.OpenClose;
import ua.repository.OpenCloseRepository;

@Component
public class LocalTimeConverter implements Converter<String, LocalTime> {

	@Override
	public LocalTime convert(String arg0) {
//		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//		LocalTime dt = LocalTime.parse(arg0, dtf);
		return LocalTime.parse(arg0);
	}

}

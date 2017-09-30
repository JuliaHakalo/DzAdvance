package ua.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.OpenClose;
import ua.repository.OpenCloseRepository;

@Component
public class OpenCloseConverter implements Converter<String, OpenClose>{
	
private final OpenCloseRepository repositopy;

	public OpenCloseConverter(OpenCloseRepository repositopy) {
	this.repositopy = repositopy;
}

	@Override
	public OpenClose convert(String arg0) {
//			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//			LocalTime dt = LocalTime.parse(arg0, dtf);
		return repositopy.findByTime(LocalTime.parse(arg0));
	}

}

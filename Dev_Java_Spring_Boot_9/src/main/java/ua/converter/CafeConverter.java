package ua.converter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.Cafe;
import ua.repository.CafeRepository;
@Component
	public class CafeConverter implements Converter<String, Cafe>{

		private final CafeRepository repository;
		
		public CafeConverter(CafeRepository repository) {
			this.repository = repository;
		}

		@Override
		public Cafe convert(String source) {
			int id = source.indexOf("=");
			source = source.substring(id+1, id+2);
			return repository.findById(Integer.valueOf(source));
		}

	}


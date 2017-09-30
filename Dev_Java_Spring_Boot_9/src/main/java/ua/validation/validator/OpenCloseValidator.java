package ua.validation.validator;

import java.time.LocalTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import ua.entity.OpenClose;
import ua.repository.OpenCloseRepository;
import ua.validation.annotation.UniqueOpenClose;


@Component
public class OpenCloseValidator implements ConstraintValidator<UniqueOpenClose, String> {

	private final OpenCloseRepository openCloseRepository; 
	
	public OpenCloseValidator(OpenCloseRepository openCloseRepository) {
		this.openCloseRepository = openCloseRepository;
	}

	@Override
	public void initialize(UniqueOpenClose arg0) { }

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
//		if(arg0.matches("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$")) {
			if (!arg0.trim().isEmpty()) {
				return openCloseRepository.findByTime(LocalTime.parse(arg0))!=null?false:true;
			} else return false;
//		}
//		return false;
	}
}
package ua.model.request;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import ua.validation.annotation.UniqueOpenClose;
import ua.validation.flag.OpenCloseFlag;

public class OpenCloseRequest {
	Integer id;
	@UniqueOpenClose(message="Такий час вже існує в БД.", groups= {OpenCloseFlag.class})
	@NotBlank(message="Це поле має бути заповненим", groups= {OpenCloseFlag.class})
	@Pattern(regexp = "^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$", message="Введіть годину за типом hh:mm", groups= {OpenCloseFlag.class})
	private String time;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}

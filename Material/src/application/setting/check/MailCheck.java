package application.setting.check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailCheck {
	
	
	public static boolean checkClientMail(String mail) {
		Pattern emailPattern = Pattern.compile(
				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		if (!mail.trim().isEmpty()) {
			Matcher m = emailPattern.matcher(mail);
			if (m.matches()) {
				return true;
			} else {
				return false;
			}
		} else {
			
			return true;
		}
	}

}

package utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		try {
			return (T) new InitialContext().lookup("java:global/tbcapp/tbcapp-server/" + clazz.getSimpleName());
		} catch (NamingException e) {
			throw new RuntimeException("Error occurred while " + clazz.getSimpleName() + " bean lookup", e);
		}
	}
}

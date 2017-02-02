package dialect;

import org.hibernate.dialect.PostgreSQLDialect;

import java.sql.Types;

public class CustomPostgreSQLDialect extends PostgreSQLDialect {

	public CustomPostgreSQLDialect() {
		super();
		registerColumnType(Types.VARCHAR, "varchar");
	}
}
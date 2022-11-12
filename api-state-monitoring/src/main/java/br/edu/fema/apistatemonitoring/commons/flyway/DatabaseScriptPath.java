package br.edu.fema.apistatemonitoring.commons.flyway;

import java.util.stream.Stream;

public enum DatabaseScriptPath {
    POSTGRESQL("org.hibernate.dialect.PostgreSQLDialect", "classpath:db/migration/postgres");

    private String dialect;
    private String scriptPath;

    DatabaseScriptPath(String dialect, String scriptPath) {
        this.dialect = dialect;
        this.scriptPath = scriptPath;
    }

    public static DatabaseScriptPath getByDialect(String dialect) {
        return Stream.of(DatabaseScriptPath.values())
                .filter(database -> database.dialect.equals(dialect))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getScriptPath() {
        return this.scriptPath;
    }
}

# Ecommerce Demo app

Ecommerce web app built with Spring Boot, Oracle database, Oracle Weblogic server.

## Setup

Requires following dependencies:

- Oracle JDK 8

- Oracle database 12c + Oracle Weblogic server 12c (or Docker)

Refer to `oracle-tools-setup/README.md` for more information.

Development tools:

- Eclipse 2020-06 (newer version doesn't work well with OEPE)

- Oracle Enterprise Pack for Eclipse (OEPE)

- Oracle JDK 8 or 11 (newer version doesn't work well with OEPE)

## Notes

### Spring Session

For Spring Session to work with Oracle Database, the following steps are necessary:

- Set these properties in `application.properties`

```
    spring.datasource.jndi-name=<datasource jndi name>
    spring.session.store-type=jdbc
    spring.session.jdbc.initialize-schema=never
```

- Manually create the tables in database (SQL file included in the repo).

### JPA

Enable Hibernate to initialize database tables by adding this to `application.properties`:

```
    spring.jpa.hibernate.ddl-auto=create-drop
```

Alternatively, Spring can also initialize the database.

```
    spring.sql.init.mode=always
    spring.datasource.platform=oracle
```

Then define tables in `schema.sql` file and data in `data.sql` file.
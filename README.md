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
    spring.session.store-type=jdbc
    spring.session.jdbc.initialize-schema=never
```

- Manually create the tables in database (SQL file included in the repo).
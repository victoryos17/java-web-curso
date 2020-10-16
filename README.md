# Container banco

```
$ docker run --rm --name mysql -v mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=segredo -d mariadb:10.4.13
$ mysql --protocol=tcp -u root -p
```

# No Windows, ao conectar no MySQL
- Usar JDBC URL a seguir
jdbc:mysql://localhost/curso?useTimezone=true&serverTimezone=UTC
# Container banco

```
sudo docker run --rm --name curso-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=javawebcurso -d mysql:latest
mysql --protocol=tcp -u root -p
```
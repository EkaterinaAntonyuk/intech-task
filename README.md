## До запуска
Описание таблиц лежит в файле schema.sql. 
Для запуска необходимо наличие базы `postgres`, схема `public`.

Настройки подключения к БД: `subscriber/src/main/resources/application.properties`

## Запуск
Из корня проекта:
* `mvn install`
* `mvn -pl subscriber spring-boot:run` - запускаем subscriber
* `mvn -pl publisher spring-boot:run` - запускаем publisher
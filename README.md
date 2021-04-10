# Book Service 

## Описание
Сервис, предоставляющий возможность создавать заказы с книгами. Создано для практики написания SpringBoot-приложений c использованием REST API.

## Стек технологий
* SpringBoot 
* PostgreSQL - база данных
* JPA - для работы с базой данных
* Mockito для реализации тестирования

## Диаграмма классов с описанием
Представлено 5 сущностей: Книга, Заказ, Клиент, Автор, Жанр
![](https://github.com/LozovskiAlexey/JavaProject/blob/master/BookService.png)  

## API
### Book
1. POST /books - Загрузить список книг
2. GET /books - Получить список всех книг 
3. DELETE /books - Удалить список книг
5. PATCH /books/{BookId} - Отредактировать информацию о книге

### Client
1. POST /client - Добавить пользователя
2. GET /client/ClientId - Посмотреть информацию о пользователе 
3. PUT /client/ClientId - Обновить сведения о пользователе

### Order
Заказ может делать только существующий пользователь, поэтому
1. GET /orders - Получить все заказы в системе
2. GET /client/{ClientId}/orders/{OrderId} - Получить список заказов текущего пользователя
3. POST //client/{ClientId}/{BookId} - Создать заказ с книгой
4. PUT /client/{ClientId}/orders/{OrderId}/{BookId} - Добавить в заказ книгу
5. DELETE /client/{ClientId}/orders - Удалить все заказы

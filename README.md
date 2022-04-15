***TODO:***
-----------------------------

Develop a class **UserParser** containing methods:

***User parse(String user)*** - accepts text like *vasia@1234* and returns the user created based on it;

***List\<User> parseList(String user)*** - takes a string containing users separated by commas and returns a list of users.

---

There is text consisting of serialized users separated by commas. Each user is described like: **nickname:username@password**.

Wherein:
- if the user does not have *nickname*, then *username* is used as *nickname*;
- *password* may be missing.

*For example:*

- ***programmer:vasia@123*** matches the object *User(nickname="programmer", username="vasia",password="123");*

- ***programmer:vasia*** matches the object *User(nickname="programmer", username="vasia",password=null);*

- ***vasia@1234*** matches the object *User(nickname="vasia", username="vasia",password="1234");*

- ***vasia*** matches the object *User(nickname="vasia", username="vasia",password=null);*

- ***vasia:@trulala*** is an invalid user.

***Задание:***
-----------------------------
Написать класс **UserParser**, содержащий методы:

***User parse(String user)*** - принимает текст вида *vasia@1234* и возвращает созданого на основе него пользователя;

***List\<User> parseList(String user)*** - принимает строку содержащую пользователей, разделенных запятой и возвращающий список пользователей.

---
Имеется текст, состоящий из описания пользователей, разделенных запятой. Каждый пользователь описан как: **nickname:username@password** . 

При этом:
- если у пользователя нет *nickname*, то в качестве *nickname* используется *username*;
- *password* может отсутствовать.

*Например:*

- ***programmer:vasia@123*** соответствует объекту *User(nickname="programmer", username="vasia",password="123");*

- ***programmer:vasia*** объекту *User(nickname="programmer", username="vasia",password=null);*

- ***vasia@1234*** объекту *User(nickname="vasia", username="vasia",password="1234");*

- ***vasia*** объекту *User(nickname="vasia", username="vasia",password=null);*

- ***vasia:@trulala*** - невалидный пользователь.

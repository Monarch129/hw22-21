# language: ru

  Функционал: Открытие карточки товара

    Предыстория:
      Дано Пользователь заходит на главную страницу сайта
      Тогда Пользователь вводит логин "standard_user", пароль "secret_sauce" и нажимает кнопку Log in

    @line
    Структура сценария: При нажатии на товар на главной странице открывается карточка товара
      Когда Пользователь нажимает на название товара <name>
      Тогда Открывается карточка товара
      Примеры: 
      |name|
      |"Sauce Labs Backpack"|
      |"Sauce Labs Bike Light"|
      |"Sauce Labs Bolt T-Shirt"|
      |"Sauce Labs Fleece Jacket"|
      |"Sauce Labs Onesie"|
      |"Test.allTheThings() T-Shirt (Red)"|
      

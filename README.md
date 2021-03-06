<h1>Сервис запроса курса вылют со стороннего API</h1>

Ver. 1.1 (Добавлен WEB интерфейс)

Автор Пичугин Дмитрий

Для скачивания репозитория введите команду:
```
git clone git@github.com:Pichugin1996/service-currency.git
```

Запуск возможен как и в Tomcat, так и в Docker (При запуски назначьте свой порт в `application.yml` и `Dockerfile`)

Сервис обращается к api сайта openexchangerates.org, и получает ответ в виде json, с 
значениями валюты по отношению к USD, далее происходит фильтрация к какой либе одной валюте.

Реализован простой web интерфейс доступный по адресу `"/index"`

Где в поле можно ввести интересующую валюту или оставить поле пустым и нажать кнопку.

![](scr/22-06-2022155031.jpg) ![](scr/22-06-2022155051.jpg)

Так же реализованы API endpoints 

![](scr/22-06-2022160053.jpg)

RESPONSE (HTTP GET):

`"/api/getCurrency"`

с параметром: `?codCurrency=RUB`  - интересующий код валюты (Не обязательный параметр)    

RESPONSE:


    {"disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
    "timestamp": "1655881200",
    "base": "USD",
    "value": 53.85,
    "rates": {
        "AED": 3.672985,
        "AFN": 89.590428}}

Конфигурация происходит в файле `application.properties`

где:

    currency.url= URL Стороннего API
    
    currency.key= API KEY Стороннего API

    
(Для получения своего ключа, зарегистрируйтесь на сайте `https://openexchangerates.org`)

 В файле `application.yml` Можно задать порт.



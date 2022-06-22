Сервис запроса курса вылют со стороннего API

Ver. 1.1 (Добавлен WEB интерфейс)
Автор Пичугин Дмитрий

Для скачивания репозитория введите команду:
git clone git@github.com:Pichugin1996/service-currency.git
запуск возможен как и в Tomcat, так и в Docker(При запуски назначьте свой порт в application.yml и Dockerfile)

Сервис обращается к api сайта openexchangerates.org, и получает ответ в виде json, с 
значениями валюты по отношению к USD, далее происходит фильтрация к какой либе одной валюте.

Реализован простой web интерфейс доступный по адресу "/index"
Где в поле можно ввести интересующую валюту или оставить поле пустым и нажать кнопку.

Так же реализованы API endpoints 

RESPONSE:
"/api/getCurrency" (HTTP GET)
с параметром: ?codCurrency=RUB  - интересующий код валюты (Не обязательный параметр)    

RESPONSE:
{
    "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
    "timestamp": "1655881200",
    "base": "USD",
    "value": 53.85,
    "rates": {
    "AED": 3.672985,
    "AFN": 89.590428,
/* ...*/
}


Конфигурация происходит в файле application.properties
где:
    currency.url= URL Стороннего API
    currency.key= API KEY Стороннего API
(Для получения своего ключа, зарегистрируйтесь на сайте https://openexchangerates.org)
 В файле application.yml Можно задать порт.



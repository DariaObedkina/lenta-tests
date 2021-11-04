# Автотесты для сайта https://lenta.com/
![image](https://user-images.githubusercontent.com/43385864/140053479-ee03e1f4-376c-41be-8bd3-ace45a378bf7.png)

### Список UI проверок
- Отображение кнопок разделов на основной странице сайта
- Переход в категорию каталога
- Поиск по наименованию продукта
- Отображение соответствующих подсказок при поиске товара
- Добавление одного товара в корзину

### Технологии, использованные в поекте
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="50" height="50"  alt="IntelliJ IDEA"></span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="50" height="50"  alt="Java"><span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Selenium.svg" width="50" height="50"  alt="Selenium"></span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="50" height="50"  alt="Selenide"><span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="50" height="50"  alt="Selenoid"></span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="50" height="50"  alt="Allure Report"><span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="50" height="50"  alt="Gradle"></span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="50" height="50"  alt="JUnit5"><span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="50" height="50"  alt="Jenkins"></span>
<span><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="50" height="50"  alt="Telegram"><span>

IntelliJ IDEA, Java, Selenium, Selenide, Selenoid, Allure Report, Gradle, JUnit5, Jenkins, Telegram.
  
## Пример выполнения проверки "Переход в категорию каталога"
![1037ce1170f2e48c (1)](https://user-images.githubusercontent.com/43385864/140057507-2f1f3f55-3dd0-4409-aae3-f24009cb103a.gif)

## Запуск автотестов в CI <a href="https://jenkins.autotests.cloud/job/08-Daria_Obedkina-lenta-tests/">Jenkins</a>
![image](https://user-images.githubusercontent.com/43385864/140061240-51c89351-94e5-4b17-bc12-65fc41ed1c84.png)
![image](https://user-images.githubusercontent.com/43385864/140061317-5d0b2fb7-8c1c-475a-ad5e-83ced4b95f66.png)

### Параметры для запуска тестов
baseUrl передается в файле app.properties (src/test/resources/config/lenta/app.properties) в формате:
```
webUrl=https://lenta.com/
```

В файле remote.properties (src/test/resources/config/remote.properties) можно указать параметры для запуска тестов:
```
browser=
browserVersion=
browserSize=
browserMobileView=
remoteDriverUrl=
videoStorage=  
```  
Если файл remote.properties заполнен, команда для запуска тестов:
```  
gradle clean test
```
Если remote.properties не заполнен, используется следующая команда:
```  
gralde clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView=${BROWSER_MOBILE}
-DremoteDriverUrl=https://%s:%s@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/

```
${BROWSER} - браузер для запуска тестов (значение по умолчанию chrome)
  
${BROWSER_VERSION} - версия браузера (значение по умолчанию 91.0)
  
${BROWSER_SIZE} - разрешение браузера (значение по умолчанию 1920x1080)
  
${BROWSER_MOBILE} - мобильная платформа, параметр опциональный (например, Iphone X)
  
${REMOTE_DRIVER_URL} - адрес удаленного сервера
  
%s:%s - логин и пароль для удаленного сервера 
  
Генерация отчета:
```
allure serve build/allure-results
```

## Генерация отчета в <a href="https://jenkins.autotests.cloud/job/08-Daria_Obedkina-lenta-tests/33/allure/">Allure</a>
![image](https://user-images.githubusercontent.com/43385864/140063076-e1cff983-180d-473b-985d-a248c91f1c60.png)

## Оповещение в Telegram
![image](https://user-images.githubusercontent.com/43385864/140063225-e51720c6-040a-4b2d-b851-c9c49c033443.png)
  

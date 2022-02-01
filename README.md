## Задача №2 - Report Portal (необязательная)

Мы сразу предупреждаем, что это задача может оказаться очень сложной, т.к. мы вас поставим в такие условия, когда "разбираться придётся самим". Будьте готовы к этому и в работе, т.к. такое обязательно может случиться - кто-то примет решение попробовать использовать определённую технологию, а разбираться, настраивать и устанавливать всё придётся вам самим. Кроме того, что нужно будет разобраться, нужно будет ещё и "задокументировать это для будущих поколений", чтобы они не тратили столько же времени, сколько потратите вы.

При этом вы должны понимать, что в отличие от материалов курса, которые проверены авторами курса, информация, содержащаяся в онлайн-источниках, может быть неполной, устаревшей и даже ошибочной.

Что нужно сделать: нужно попробовать интегрировать ваш проект тестирования доставки карт с Report Portal. Нам будет достаточно, если логи вашего теста будут отправляться в запущенный экземпляр Report Portal.

Как это сделать - у вас есть несколько ссылок, с которых следует начать поиск:
* https://reportportal.io/
* https://github.com/reportportal

В результате: обновляете ваш проект на Github для интеграции с Report Portal и выкладываете краткий Manual в виде README.md, в котором описываете необходимые действия для воспроизведения вашей интеграции.

<details>
   <summary>Подсказка</summary>

1. Достаточно часто разработчики решений предоставляют готовые Docker-файлы и даже docker-compose.yml, для того, чтобы вы могли "быстро развернуть" сервис и попробовать его в действии.
1. Часто такое бывает, что в официальном репо на Github выкладываются примеры интеграции. Возможно, стоит посмотреть там (по стеку используемых вами технологий: как минимум, JUnit5).
</details>

### Manual :

1. Add simple test method.
2. Add log4j2.xml file to resources folder.
3. Open ReportPortal UI

Go to `http:$IP_ADDRESS_OF_REPORT_PORTAL:8080:ui` (by default it is http://localhost:8080)

Login as Admin user and create the project:
```
login: superadmin
password : erebus
```
4. Add users to your project:

Go to `Administrative -> My Test Project -> Members -> Add user`

5. Add reportportal.properties

After you have created new user in your project, you can get reportportal.properties file example from the user Profile page

To do that, login as created user and go to User icon in `header -> Profile`

There, in Configuration Examples section, you can find the example of reportportal.properties file for that user

Returning back to the code. In your project, create file named reportportal.properties in resources folder and copy&paste the contents form the user profile page

Example:
```
[reportportal.properties]
rp.endpoint = http://localhost:8080
rp.uuid = {{UUID_PROFILE}}
rp.launch = {{*username*_TEST_EXAMPLE}}
rp.project = {{*project_name*}}
rp.enable = true
```

6. Register Report Portal agent in JUnit 5

There are two options how you can enable ReportPortal extension in your tests:

By specifying `@ExtendWith` annotation
By service location
Register ReportPortal extension with annotation

Example in CardOrderTest:
```
@ExtendWith({ScreenShooterReportPortalExtension.class})
```

7. After you linked the Report Portal JUnit 5 agent using one of the approaches described above and ran your tests, you should be able to see the results in your ReportPortal UI instance

To do that, login to ReportPortal, and go to Left `Panel -> Launches`

You should see the launch there, with the name equal to the value of rp.launch from your `reportportal.properties` file.
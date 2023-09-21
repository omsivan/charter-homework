# charter-homework

### This application was built using Java 17 and Spring Boot ver. 3.1.3 using IntelliJ IDE
### Maven was used as the build tool. To build the application use the following command:
`mvn clean install`
### or run the `clean` and `install` Lifecycle Events in the Maven Window of the IDE.

### To run the Spring Boot Application, run the following command in a command prompt.

`java com.charter.homework.retail.charterhomework.CharterHomeworkApplication`

### Or right-click on the com.charter.homework.retail.charterhomework.CharterHomeworkApplication in IntelliJ and click on the "Run" menu item.

## Testing. 
### This application was tested using Postman. 
### Below is the cURl that was used for testing.

curl --location --request GET 'http://localhost:8080/reward-points' \
--header 'Content-Type: application/json' \
--data '{
"customerPurchases": [
{
"customerId": "001",
"amount": 50,
"dateTime": "2023-01-03 10:08:02"
},
{
"customerId": "001",
"amount": 60,
"dateTime": "2023-02-03 10:08:02"
},
{
"customerId": "001",
"amount": 75,
"dateTime": "2023-02-03 10:08:02"
},
{
"customerId": "001",
"amount": 200,
"dateTime": "2023-03-03 10:08:02"
},
{
"customerId": "002",
"amount": 5,
"dateTime": "2023-01-03 10:08:02"
},
{
"customerId": "002",
"amount": 55,
"dateTime": "2023-02-03 10:08:02"
},
{
"customerId": "002",
"amount": 77,
"dateTime": "2023-02-03 10:08:02"
},
{
"customerId": "002",
"amount": 100,
"dateTime": "2023-03-03 10:08:02"
}
]
}'

For questions please send me an email.
[om.sivanesan@gmail.com](mailto:om.sivanesan@gmail.com)

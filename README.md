# ClusteredData Warehouse

 To accept FX deals details from from customer and persist them into DB.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
### Technologies
* Java 8
* Maven
* Docker

### Installing

1) clone the project
2) cd to the root folder of the project
3) docker-compose up — This will execute Dockerfile commands and will run services defined in the docker-compose file.
4) access the endpoint on: http://localhost:8989/api/order
5) sample request:
 {
    "dealId": "2",
    "orderingCurrency": "NGN",
    "toCurrency": "USD",
    "orderingTime": "18/12/2020",
    "amount": 1000
}

6) docker-compose down — This will stop and remove all containers that were running by docker-compose file.


## Author

* **Adewale Ijalana** 

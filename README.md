# LPCA

## Instruction

1. git clone
2. mvn clean install
3. wait for compiled successfully.
4. mvn spring-boot:run
5. open browser or open api testing tool
6. hit the url http://localhost:8080/Birthday/Get, then will return the correct response.
7. if want to test different date, then you can change the {date}(yyyy/MM/dd) what you want by this url http://localhost:8080/Birthday/Get?date={date}.


## Built with

- [Springboot]
- [MySql]
- [H2Database]

## Problems

### Problem1: Simple Message (branch name: feature/V1)

Result: 

![image](https://github.com/billws/lpca/blob/main/images/V1-1.png?raw=true)

Structure:

![image](https://billws.github.io/lpca/images/V1-2.png)


### Problem2: Tailer-made Message for different gender (branch name: feature/V2)

Result: 

![image](https://billws.github.io/lpca/images/V2-1.png)

Structure:

![image](https://billws.github.io/lpca/images/V2-2.png)

Important change:

Using gender value from database to get the different service to generate the message.

![image](https://billws.github.io/lpca/images/V2-3.png)


### Problem3: Message with an Elder Picture for those whose age is over 49 (branch name: feature/V3)

Result: 

![image](https://billws.github.io/lpca/images/V3-1.png)

Structure:

![image](https://billws.github.io/lpca/images/V3-2.png)

Important change:

Create the new component for elder message.

![image](https://billws.github.io/lpca/images/V3-3.png)



### Problem4: Simple Message with full name (branch name: feature/V4)

Result: 

![image](https://billws.github.io/lpca/images/V4-1.png)

Structure:

![image](https://billws.github.io/lpca/images/V1-2.png)

Important change:

Changed the template in application properties file.

![image](https://billws.github.io/lpca/images/V4-3.png)




### Problem5: Simple Message but database changes (branch name: feature/V5)

Result: 

![image](https://billws.github.io/lpca/images/V1-1.png)

Structure:

![image](https://billws.github.io/lpca/images/V1-2.png)

Important change:

Used same code base but just only change the profiles for different database.

![image](https://billws.github.io/lpca/images/V5-3.png)


### Problem6: Simple Message but different output data format (branch name: feature/V6)

Result: 

![image](https://billws.github.io/lpca/images/V6-1.png)

Structure:

![image](https://billws.github.io/lpca/images/V6-2.png)

Important change:

Added a new model for XML tree also accept action return different response data format.

![image](https://billws.github.io/lpca/images/V6-3.png)





# CST438_CarRental_Team5

Project outline and requirements (Springboot, REST, JPA, etc)

  

API’s with versioning

  

Problem tracking Tracing/logging

  

Failure, recovery, and security features

  

Junit tests

  

Video link

<br/><br/><br/>
<B>Databse UML</B> 

    



```mermaid
graph RL
A(<B>CarReservations DB</B><br/>CustID - Long?<br/>CPLocation - String <br/>CPDate - DateTime <br/>CPTime - Datetime... Consolidate?<br/><br/>CRLocation - String<br/>CRDate - DateTime <br/>CRTime - Datetime... Consolidate? ) 

B(<B>CarInventory DB</B><br/>CType - SUV, FS, ECON, COMP <br/>CPrice - Float <br/>CAvail - Bool)

C(<B>Car Reservation Form</B><br/>CPLocation<br/>CPDate<br/>CPTime<br/>CRLocation <br/>)


A --> B
C --> A


```

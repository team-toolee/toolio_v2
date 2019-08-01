# Toolio

> ![Homepage](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/logo.png)

## Summary

> It is application that lets user to allow users to exchange tool. Toolio lets you to rent different hardware tools that are made avialable by thousands of Toolio users just like yourself.

## Setting Up

 > How to get and set up our app:
 
 * From our GH [repository](https://github.com/team-toolee/toolio_v2) copy the link under the clone or download button.
 * In your command line terminal go to whatever directory you want to the app to be in.  
     * `git clone <paste in copied link here>`
    
## How to Use toolio!
> Create a database on your RDS account with database or:
    - On your terminal, enter ``psql``
    - Enter create database ``tooliodb``
    
> Specify the database that you're using (local or rds) on your application.properties file

> For the first time when creating the database table, enable the following code in application.properties:
    - ``spring.jpa.hibernate.ddl-auto=create-drop``
    
> Once you run your application for the first time, run the following code:
    - ``spring.jpa.hibernate.ddl-auto=update``
    
> Create a bucket in AWS S3 to store images of the tools

> Specify your bucket's accesskey, secret key, bucket, and S3 endpoint on environment variables.

> Enable server port 5000 on application.properties.

> On your browser, type localhost:5000 to access the app

> After successfully running the application, user would land into the login page as shown below :
  ![App Start](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/homePage.png)

> First time user needs to create a username with unique username
![Signup](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/signup.png)

> Sucessfully creating an account user can login
![Login](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/login.png)

> Sucessfully login , user would be redirected to profile page
![Profile](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/discoverPage_initial.png)

> User can add tool to be rented in the application
![Add tool](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/addTool.png)

> After successfully adding the tool, user would be redirected to the profile and the newly added tool would be shown
![tool_added](https://github.com/team-toolee/toolio_v2/blob/master/src/main/resources/static/img/addTool_done.png)

> To discover other application user, user can click `discover` button on navigation bar which you display all user with the current user's area.

> Based on the listed tool user can send message to the user who have listed the tool

> Upon sucessfully sending message, user who have listed the tool would recived the text message on their listed phone

 
## Architectural Design
   * Model View Controller design
    ![MVC](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/mvc.png)

   * Data base design 
    ![Data base design]()

## Technologies Used
* Java
* Spring Boot
* Thymeleaf
* Amazon AWS
* BootStrap

## Versions
> Version 1.0 - Setup repo and added planning files.

## Authors
* **Saurav Kadariya** - *Initial work* - [skadariya](https://github.com/skadariya)
* **Kishor Pandey** - *Initial work* - [kishor](https://github.com/kishorpan2)
* **Osunkwo Williams** - *Initial work* - [wosunkwo](https://github.com/wosunkwo)
* **Sudip Adhikari** - *Initial work* - [sudip](https://github.com/sadhikari07)
* **Dough Klemp** - *Initial work* - [Dough](https://github.com/idothestamping)

## License
> This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.


Testing adding to the dev branch

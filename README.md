# Toolio

![Homepage](./src/static/img/pliers.jpg)

## Summary
> Coming Soon [Summary of application]

## Setting Up

 How to get and set up our app:
 
 * From our GH [repository](https://github.com/team-toolee/toolee) copy the link under the clone or download button.
 * In your command line terminal go to whatever directory you want to the app to be in.  
     * `git clone <paste in copied link here>`
    
## How to Use toolio!
- Create a database on your RDS account with database or:
    - On your terminal, enter psql
    - Enter create database tooliodb
- Specify the database that you're using (local or rds) on your application.properties file
- For the first time when creating the database table, enable the following code in application.properties:
    - spring.jpa.hibernate.ddl-auto=create-drop
- Once you run your application for the first time, run the following code:
    - spring.jpa.hibernate.ddl-auto=update
- Create a bucket in AWS S3 to store images of the tools
- Specify your bucket's accesskey, secret key, bucket, and S3 endpoint on environment variables.
- Enable server port 5000 on application.properties.
- On your browser, type localhost:5000 to access the app

> Coming Soon [..screen shot of each page in application..]
 * After successfully running the application, user would land into the login page as shown below :
  
 
## Architectural Design
   * Model View Controller design
    ![MVC](https://github.com/team-int-finance/kid-doh/blob/master/src/main/resources/static/images/mvc.png)

   * Data base design 
    ![Data base design](./assests/dbDesign.png)

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
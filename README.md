# springboot-android-chat-server

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![Build Status](https://travis-ci.org/Fnil/springboot-android-chat-client.svg?branch=master)](https://travis-ci.org/Fnil/springboot-android-chat-client)

## What is it?

Backend springboot project for android chat app. Get android part code [here](https://github.com/Fnil/springboot-android-chat-client).



<img src="https://github.com/Fnil/springboot-android-chat-client/blob/master/screenshot/demo1.gif?raw=true" alt="A screenshot illustratrating the UI of the app" width="150" style="display: inline; "/> <img src="https://github.com/Fnil/springboot-android-chat-client/blob/master/screenshot/demo2.gif?raw=true" alt="A screenshot illustratrating the UI of the app" width="150" style="display: inline; "/>

## Why?

Good starting template for anyone that is interested in building their own chat app. Fast, compact, highly-customizable.

## How to use?

An instance compiled from this project is already running on aws. You can directly access it from the android side.

To create your own backend, first create the 'chat' and 'user' table. 


```sql
CREATE DATABASE IF NOT EXISTS `DB`;
USE `DB`;

DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` int(11) DEFAULT NULL,
  `receiver` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```


```sql
CREATE DATABASE IF NOT EXISTS `DB`;
USE `DB`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `status` int(11)  NULL, 
  `imageURL` varchar(2083) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

Then change [application.properties](https://github.com/Fnil/springboot-android-chat-server/blob/master/src/main/resources/application.properties) to your url, username, password.

```
server.port=8080

spring.datasource.url=jdbc:mysql://enter-your-url:3306/DB?serverTimezone=UTC

spring.datasource.username = enter-your-username
spring.datasource.password= enter-your-password
```
# spring mysql 연동 error 

## 1. sql계정 문제

**sql 계정의 Authentication Type 항목이 standard이어야 한다.**

```mysql
mysql -u root -p
password
use mysql;
alter user '계정입력'@'localhost' identified with mysql_native_password by '비밀번호입력';
select host, user, plugin, authentication_string from user;
flush previleges;

```



## 2. POM.xml 수정

mysql-connector-java 버전을 8.0.11로 수정
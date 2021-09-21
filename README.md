# springboot-sql-injection


Building app
> ./build

Running app
> ./run


After application starts, run below from cmd-line for sql-injection

curl "http://localhost:9080/test?age=15&name=TestUser1'%20or%20'1'='1"
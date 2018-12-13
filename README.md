# spring-boot-example

#### oauth
##### 获取token
`http://localhost:801/oauth/token?username=root&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456`
##### 访问API
`http://localhost:801/order/1?access_token=eaae33a0-77db-416f-9fc9-f21565158e46`
##### 刷新token
`http://localhost:801/oauth/token?grant_type=refresh_token&client_id=client_2&client_secret=123456&refresh_token=bb18efb1-7ec0-4194-a6bc-95a887d8c3a2`
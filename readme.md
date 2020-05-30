# springmvc入门
1. 新建web项目
2. 导包
3. 配置web.xml中的中央控制器dispatchServlet
4. 配置spring-mvc.xml配置文件
5. 书写入门程序HelloController

# 请求映射和请求数据绑定
## url和请求方法限定(PartOneController)
1. 一个方法匹配多个路径  
@RequestMapping(value= {"/multi1","/multi2","/multi3"})
2. 匹配通配符(Ant风格映射,*表示一层，**表示多层,?表示匹配一个字符)
	1. `@RequestMapping("/user/*/addUser")`:/user/sss/addUser
	2. `@RequestMapping("/user/**/addUser")`:/user/555/666/777/addUser
3. url模板映射,{userId}表示接收一个用户的id
```
@RequestMapping("/user/{userId}")
public String four(@PathVariable("userId")int userId) {
```
4. 通过get或post来区分请求的不同
GET方式
```
@RequestMapping(value="/user/add",method=RequestMethod.GET)
public String five() {
```
POST方式
```
@RequestMapping(value="/user/add",method=RequestMethod.POST)
public String six() {
```

## 根据请求参数限定url(PartTwoController)
1. 使用@RequestParam注解参数，@RequestParam注意里面username要和表单参数名一致。一旦用了注解，参数时必须的。除非加一个属性required=false
```
@RequestMapping(value= {"regist"})
public String one(@RequestParam("username")String username,@RequestParam(value="password",required=false)String password) {
```
2. 不使用@RequestParam注解参数,参数可有可无，只需参数名与表单参数明一直即可
```
@RequestMapping(value= {"regist"})
public String one(@RequestParam("username")String username,@RequestParam(value="password",required=false)String password) {
```
3. 支持正则表达式的url
```
@RequestMapping(value="/updateUser/{userId:\\d+}-{userName:[a-z]+}")
public String three(@PathVariable("userId") String userId,@PathVariable("userName") String userName){
```
4. 封装对象的参数绑定，只需封装对象的属性与表单参数对应即可
```
@RequestMapping("/register2")
public String four(User user){
```

## 请求参数绑定(PartThreeController)
1. @ModelAttribute注解,@ModelAttribute注解会将参数放到request作用域
```
@RequestMapping("/register3")
public String register3(@ModelAttribute("user")User user){
```

## springMvc参数绑定机制
![参数绑定机制](WebContent/images/paramater.png)

## 参数绑定错误(可能为格式转换不成功)，报错400
三种解决方式
1. 页面用js判断该字段不能为空
2. 默认给input控件初始值，比如int型可以给value属性赋值0
3. 后台定义converter，然后进行注册，注册到conversion-service对应bean当中。
配置方式
```
<!-- 消息转换器服务类 -->
	<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
		<property name="converters">
			<list>
				<bean class="com.group.converter.StringToDateConverter"></bean>
			</list>
		</property>
	</bean>
	<!-- requestMappingHandler,handlerAdapter请求匹配处理器，适配器两个对象 -->
	<mvc:annotation-driven conversion-service="conversionService"/>
```

# 模型和视图解析ModelAndView



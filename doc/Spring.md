Spring源码训练营


`
1. SpringIOC
2. Spring程序是如何启动的？
3. Spring是如何加载配置文件到应用程序的？
4. 掌握核心接口BeanDefintionReader
5. 掌握核心接口BeanFactory
6. Spring的refresh方法
7. BeanPostProcessor接口的作用和实现
8. BeanFactoryPostProcessor接口的作用及实现
9. Spring Bean有没有必要实现Aware接口
10. Spring Bean 的实例化过程
11. Spring Bean的初始化到底干了什么？
12. 彻底理解FactoryBean接口
13. 完美解析Spring Bean的生命周期
14. 为什么会产生循环依赖问题
15. 循环依赖在Spring中是如何解决的
16. 如何巧妙回到Spring IOC面试题
17. cglib和jdk的动态代理机制
18. aop是如何处理的
`




方法论

1. 先梳理脉络，然后再抠细节。
2. 不要忽略注释。
3. 学会使用小工具，translate。
4. 见名知意。
5. 大胆猜测，小心验证。
6. 坚持看







IOC/AOP ------>容器 		从对象的创建到对象的使用再到对象的销毁全部都由容器来帮我们控制，用户只需要使用即可。







```java
//反射
Constructor ctor = Clazz.getDeclareConstrutor();
Object obj = ctor.newInstance();
```



BeanPostProcessor.java  --->  AopProxy.java







容器和对象的创建流程

1. 先创建容器

2. 加载配置文件，封装成BeanDefinition

3. 调用执行BeanFactoryPostProcessor

   准备工作：

   ​	准备beanPostProcessor

   ​	准备监听器，事件，广播器

4. 实例化

5. 初始化

6. 获取到完整对象





do开头的方法才是干活的方法 核心逻辑




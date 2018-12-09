
1. 在IoC容器中注册组件三种方式
    - 包扫描+组件注解(@Component , @Service , @Controller , @Component),针对本地代码
    - @Bean , 应用于本地/第三方组件
    - @Import 
        - 快速给容器导入组件 , id默认是全类名
        - 实现ImportSelector
        - 实现ImportBeanDefinitionRegistrar
    - 使用Spring提供的FactoryBean(工厂bean)，通过getObject()获取到工厂代理的对象，通过&beanName获取到工厂bean本身
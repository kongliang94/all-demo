package com.lagou;

import com.lagou.service.HelloService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboAdaptiveMain {
    public static void main(String[] args) {
        //Dubbo中的Adaptive功能,主要解决的问题是如何动态的选择具体的扩展点。通过
        //getAdaptiveExtension 统一对指定接口对应的所有扩展点进行封装,通过URL的方式对扩展点来进行
        //动态选择。 (dubbo中所有的注册信息都是通过URL的形式进行处理的。)
        // 这里同样采用相同的方式进行实现
        URL   url  = URL.valueOf("test://localhost/hello?hello.service=cat");
        HelloService  adaptiveExtension = ExtensionLoader.getExtensionLoader(HelloService.class).getAdaptiveExtension();
        String  msg = adaptiveExtension.sayHello(url);
        System.out.println(msg);
        //因为在这里只是临时测试,所以为了保证URL规范,前面的信息均为测试值即可,关键的点在于
        //hello.service 参数,这个参数的值指定的就是具体的实现方式。关于为什么叫
        //hello.service 是因为这个接口的名称,其中后面的大写部分被dubbo自动转码为 . 分割。
        //通过 getAdaptiveExtension 来提供一个统一的类来对所有的扩展点提供支持(底层对所有的扩展
        //点进行封装)。
        //调用时通过参数中增加 URL 对象来实现动态的扩展点使用。
        //如果URL没有提供该参数,则该方法会使用默认在 SPI 注解中声明的实现
    }
}

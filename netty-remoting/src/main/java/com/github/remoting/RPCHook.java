package com.github.remoting;

import com.github.remoting.protocol.RemotingCommand;

/**
 * 一、什么是 Hook 技术
 * Hook 技术又叫做钩子函数，在系统没有调用该函数之前，钩子程序就先捕获该消息，钩子函数先得到控制权，这时钩子函数既可以加工处理（改变）该函数的执行行为，还可以强制结束消息的传递。简单来说，就是把系统的程序拉出来变成我们自己执行代码片段。
 * 要实现钩子函数，有两个步骤：
 * 1. 利用系统内部提供的接口，通过实现该接口，然后注入进系统（特定场景下使用）
 * 2.动态代理（使用所有场景）
 *
 * 二、Hook 技术实现的步骤
 * Hook 技术实现的步骤也分为两步
 * 1.找到 hook 点（Java 层），该 hook 点必须满足以下的条件：需要 hook 的方法，所属的对象必须是静态的，因为我们是通过反射来获取对象的，我们获取的是系统的对象，所以不能够 new 一个新的对象，必须用系统创建的那个对象，所以只有静态的才能保证和系统的对象一致。
 * 2.将 hook 方法放到系统之外执行（放入我们自己的逻辑）
 *
 */
public interface RPCHook {

    void doBeforeRequest(final String remoteAddr, final RemotingCommand request);
    void doAfterResponse(final String remoteAddr, final RemotingCommand request, final RemotingCommand response);
}

package com.github.server.session;


import io.netty.channel.Channel;

public interface Session {

     void bind(Channel channel, String username);


    void unbind(Channel channel);


    Object getAttribute(Channel channel, String username);


    void setAttribute(Channel channel, String username,Object value);


    Channel getChannel(String username);
}

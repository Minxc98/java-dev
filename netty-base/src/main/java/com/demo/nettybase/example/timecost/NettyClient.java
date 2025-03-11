package com.demo.nettybase.example.timecost;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            // 创建一个启动Bootstrap(注意是Netty包下的)
            Bootstrap bootstrap = new Bootstrap();
            // 链式设置参数
            bootstrap.group(eventExecutors) // 设置线程组
                    .channel(NioSocketChannel.class) // 设置通道class
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ClientHandler());
                        }
                    });
            System.out.println("客户端is ok...");

            // 启动客户端连接服务器(ChannelFuture 是netty的异步模型)
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();
            // 监听关闭通道
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 关闭
            eventExecutors.shutdownGracefully();
        }
    }
}
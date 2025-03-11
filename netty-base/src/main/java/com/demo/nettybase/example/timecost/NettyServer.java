package com.demo.nettybase.example.timecost;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        // 1. 创建bossGrou好eworkerGroup
        // bossGroup只负责连接请求，其他交给workerGroup, 两个都是无线循环
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // 创建服务器端启动对象用于设置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 使用链式编程设置参数
        bootstrap.group(bossGroup, workerGroup)// 设置两个组
                .channel(NioServerSocketChannel.class) // 设置服务器的通道
                .option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列得到连接个数
                .childOption(ChannelOption.SO_KEEPALIVE, true) // 设置保持活动连接状态
                .childHandler(new ChannelInitializer<SocketChannel>() { // 设置通道测试对象(匿名对象)
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 给pipeline添加一个handler
                        socketChannel.pipeline().addLast(new ServerHandler());
                    }
                });

        System.out.println("服务端is ok。。。");

        // 启动服务器并绑定端口。绑定一个端口并且同步，生成一个ChannelFuture对象
        ChannelFuture channelFuture = bootstrap.bind(6666).sync();
        // 对关闭通道进行监控
        channelFuture.channel().closeFuture().sync();
    }
}
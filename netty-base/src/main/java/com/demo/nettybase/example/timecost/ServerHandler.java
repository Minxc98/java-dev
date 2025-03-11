package com.demo.nettybase.example.timecost;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles a server-side channel.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);

    /**
     * 读取事件
     *
     * @param ctx 上下文对象，含有pipeline管道；通道channel；地址address等信息
     * @param msg 客户端发送的数据(实际类型是ByteBuf - netty 封装的ByteBuffer)
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("当前线程： " + Thread.currentThread().getName());
        // 强转为netty的ByteBuffer(实际就是包装的ByteBuffer)
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("客户端发送的消息是：" + byteBuf.toString(CharsetUtil.UTF_8));
        log.info("客户端地址：" + ctx.channel().remoteAddress());

        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                // 比如这里我们将一个特别耗时的任务转为异步执行(也就是任务提交到NioEventLoop的taskQueue中)
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端！0!", CharsetUtil.UTF_8));
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端！1!", CharsetUtil.UTF_8));
            }
        });
    }

    /**
     * 数据读取完毕事件
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 将数据写到客户端(write + flush)
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端！", CharsetUtil.UTF_8));
    }

    /**
     * 发生异常事件
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
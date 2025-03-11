package com.demo.nettybase.example.timecost;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义服务器端处理handler，需要继承netty定义的ChannelInboundHandlerAdapter 类
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(ClientHandler.class);

    /**
     * 通道就绪事件
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("ClientHandler ctx: " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello， 服务器！", CharsetUtil.UTF_8));
    }

    /**
     * 读取事件
     *
     * @param ctx 上下文对象，含有pipeline管道；通道channel；地址address等信息
     * @param msg 客户端发送的数据(实际类型是ByteBuf - netty 封装的ByteBuffer)
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 强转为netty的ByteBuffer(实际就是包装的ByteBuffer)
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("服务器会送的消息是：" + byteBuf.toString(CharsetUtil.UTF_8));
        log.info("服务器地址：" + ctx.channel().remoteAddress());
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
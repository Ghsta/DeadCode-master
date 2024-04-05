package utils;/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelDuplexHandler
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPipeline
 *  io.netty.channel.ChannelPromise
 */
import classes.class11;
import mahiro.deadcode.deadcode.EventsHandler;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;

public class cw
extends ChannelDuplexHandler {
    private EventsHandler a;

    public cw(EventsHandler eventsHandler) {
        this.a = eventsHandler;
        try {
            ChannelPipeline channelPipeline = Wrapper.INSTANCE.getMinecraft().getConnection().getNetworkManager().channel().pipeline();
            channelPipeline.addBefore(class11.sb()[11], class11.sb()[12], (ChannelHandler)this);
            ChatUtils.debug("Connection: attached.");
        }
        catch (Exception exception) {
            ChatUtils.exception("Connection: Error on attaching.", exception);
        }
    }

    public void a(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        super.channelRead(channelHandlerContext, object);
        if (!this.a.a(object, bw.a)) {
            return;
        }
    }

    public void a(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise) throws Exception {
        super.write(channelHandlerContext, object, channelPromise);
        if (!this.a.a(object, bw.b)) {
            return;
        }
    }
}


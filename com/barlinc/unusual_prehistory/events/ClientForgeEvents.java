/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.util.Mth
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.Entity
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.client.event.RenderLivingEvent$Post
 *  net.minecraftforge.client.event.RenderLivingEvent$Pre
 *  net.minecraftforge.client.event.ViewportEvent$ComputeCameraAngles
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.TickEvent$ClientTickEvent
 *  net.minecraftforge.event.TickEvent$Phase
 *  net.minecraftforge.eventbus.api.Event
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 */
package com.barlinc.unusual_prehistory.events;

import com.barlinc.unusual_prehistory.UnusualPrehistory2;
import com.barlinc.unusual_prehistory.entity.mob.future.Barinasuchus;
import com.barlinc.unusual_prehistory.entity.mob.future.Manipulator;
import com.barlinc.unusual_prehistory.entity.mob.update_1.Megalania;
import com.barlinc.unusual_prehistory.entity.mob.update_4.Ulughbegsaurus;
import com.barlinc.unusual_prehistory.events.ScreenShakeEvent;
import com.barlinc.unusual_prehistory.network.ManipulatorOpenInventoryPacket;
import com.barlinc.unusual_prehistory.screens.ManipulatorContainer;
import com.barlinc.unusual_prehistory.screens.ManipulatorInventoryScreen;
import com.barlinc.unusual_prehistory.utils.ClientProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(value=Dist.CLIENT)
@Mod.EventBusSubscriber(modid="unusual_prehistory", bus=Mod.EventBusSubscriber.Bus.FORGE, value={Dist.CLIENT})
public class ClientForgeEvents {
    private static float shakeAmount;
    private static float prevShakeAmount;
    public static final List<ScreenShakeEvent> SCREEN_SHAKE_EVENTS;

    @SubscribeEvent
    public void preRenderLiving(RenderLivingEvent.Pre event) {
        if (ClientProxy.blockedEntityRenders.contains(event.getEntity().m_20148_())) {
            if (!UnusualPrehistory2.PROXY.isFirstPersonPlayer((Entity)event.getEntity())) {
                MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
                event.setCanceled(true);
            }
            ClientProxy.blockedEntityRenders.remove(event.getEntity().m_20148_());
        }
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.m_91087_();
        if (event.phase == TickEvent.Phase.END) {
            Entity cameraEntity = minecraft.m_91288_();
            prevShakeAmount = shakeAmount;
            float shake = 0.0f;
            Iterator<ScreenShakeEvent> groundShakeMomentIterator = SCREEN_SHAKE_EVENTS.iterator();
            while (groundShakeMomentIterator.hasNext()) {
                ScreenShakeEvent groundShakeMoment = groundShakeMomentIterator.next();
                groundShakeMoment.tick();
                if (groundShakeMoment.isDone()) {
                    groundShakeMomentIterator.remove();
                    continue;
                }
                if (cameraEntity == null) continue;
                shake = Math.max(shake, groundShakeMoment.getDegree(cameraEntity, 1.0f));
            }
            shakeAmount = shake * ((Double)minecraft.f_91066_.m_231924_().m_231551_()).floatValue();
        }
    }

    @SubscribeEvent
    public void computeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        Minecraft minecraft = Minecraft.m_91087_();
        Entity player = Minecraft.m_91087_().m_91288_();
        float partialTicks = (float)event.getPartialTick();
        float lerpedShakeAmount = Mth.m_14036_((float)(prevShakeAmount + (shakeAmount - prevShakeAmount) * partialTicks), (float)0.0f, (float)4.0f);
        if (lerpedShakeAmount > 0.0f) {
            float time = minecraft.f_91075_ == null ? 0.0f : (float)minecraft.f_91075_.f_19797_ + minecraft.getPartialTick();
            event.setRoll((float)((double)lerpedShakeAmount * Math.sin(2.0f * time)));
        }
        if (player != null && player.m_20159_() && event.getCamera().m_90594_()) {
            if (player.m_20202_() instanceof Ulughbegsaurus) {
                event.getCamera().m_90568_(-event.getCamera().m_90566_((double)1.9f), 0.0, 0.0);
            }
            if (player.m_20202_() instanceof Megalania) {
                event.getCamera().m_90568_(-event.getCamera().m_90566_((double)1.7f), 0.0, 0.0);
            }
            if (player.m_20202_() instanceof Barinasuchus) {
                event.getCamera().m_90568_(-event.getCamera().m_90566_(1.5), 0.0, 0.0);
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void openManipulatorInventory(ManipulatorOpenInventoryPacket packet) {
        Entity entity;
        LocalPlayer player = Minecraft.m_91087_().f_91074_;
        if (player != null && (entity = player.m_9236_().m_6815_(packet.getEntityId())) instanceof Manipulator) {
            Manipulator manipulator = (Manipulator)entity;
            LocalPlayer localPlayer = Minecraft.m_91087_().f_91074_;
            ManipulatorContainer container = new ManipulatorContainer(packet.getId(), player.m_150109_(), (Container)manipulator.manipulatorInventory, manipulator);
            localPlayer.f_36096_ = container;
            Minecraft.m_91087_().m_91152_((Screen)new ManipulatorInventoryScreen(container, player.m_150109_(), manipulator));
        }
    }

    static {
        SCREEN_SHAKE_EVENTS = new ArrayList<ScreenShakeEvent>();
    }
}


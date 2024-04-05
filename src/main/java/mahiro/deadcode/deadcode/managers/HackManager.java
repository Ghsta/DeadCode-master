/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent
 *  net.minecraftforge.client.event.RenderPlayerEvent
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.client.event.ScreenshotEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientConnectedToServerEvent
 */
package mahiro.deadcode.deadcode.managers;

import classes.class27;
import mahiro.deadcode.deadcode.hack.Hack;
import mahiro.deadcode.deadcode.utils.visual.ChatUtils;
import mahiro.deadcode.deadcode.value.Value;
import mahiro.deadcode.deadcode.value.types.BooleanValue;
import mahiro.deadcode.deadcode.hacks.combat.AimBot;
import mahiro.deadcode.deadcode.hacks.combat.AntiAim;
import mahiro.deadcode.deadcode.hacks.combat.AntiBot;
import mahiro.deadcode.deadcode.hacks.combat.AutoBuff;
import mahiro.deadcode.deadcode.hacks.combat.AutoDebuff;
import mahiro.deadcode.deadcode.hacks.combat.AutoGApple;
import mahiro.deadcode.deadcode.hacks.combat.AutoHeal;
import mahiro.deadcode.deadcode.hacks.combat.AutoTotem;
import mahiro.deadcode.deadcode.hacks.combat.BowAimBot;
import mahiro.deadcode.deadcode.hacks.combat.ClickPearl;
import mahiro.deadcode.deadcode.hacks.combat.Criticals;
import mahiro.deadcode.deadcode.hacks.combat.FastBow;
import mahiro.deadcode.deadcode.hacks.combat.GoldenAppleDelay;
import mahiro.deadcode.deadcode.hacks.combat.HitBox;
import mahiro.deadcode.deadcode.hacks.combat.KillAura;
import mahiro.deadcode.deadcode.hacks.combat.NoDamage;
import mahiro.deadcode.deadcode.hacks.combat.Reach;
import mahiro.deadcode.deadcode.hacks.combat.Refill;
import mahiro.deadcode.deadcode.hacks.combat.ShieldBreaker;
import mahiro.deadcode.deadcode.hacks.combat.TargetStrafe;
import mahiro.deadcode.deadcode.hacks.combat.TriggerBot;
import mahiro.deadcode.deadcode.hacks.combat.Velocity;
import mahiro.deadcode.deadcode.hacks.exploit.BedrockTeleport;
import mahiro.deadcode.deadcode.hacks.exploit.Blackout;
import mahiro.deadcode.deadcode.hacks.exploit.DeathBow;
import mahiro.deadcode.deadcode.hacks.exploit.HClip;
import mahiro.deadcode.deadcode.hacks.exploit.NoCom;
import mahiro.deadcode.deadcode.hacks.exploit.PluginsGetter;
import mahiro.deadcode.deadcode.hacks.exploit.PortalGodMode;
import mahiro.deadcode.deadcode.hacks.exploit.RodLeave;
import mahiro.deadcode.deadcode.hacks.exploit.SelfDamage;
import mahiro.deadcode.deadcode.hacks.exploit.Teleport;
import mahiro.deadcode.deadcode.hacks.exploit.TeleportDown;
import mahiro.deadcode.deadcode.hacks.exploit.TeleportUp;
import mahiro.deadcode.deadcode.hacks.exploit.VClip;
import mahiro.deadcode.deadcode.hacks.exploit.XCarry;
import mahiro.deadcode.deadcode.hacks.movement.AirJump;
import mahiro.deadcode.deadcode.hacks.movement.AntiWeb;
import mahiro.deadcode.deadcode.hacks.movement.AutoSprint;
import mahiro.deadcode.deadcode.hacks.movement.AutoStep;
import mahiro.deadcode.deadcode.hacks.movement.AutoWalk;
import mahiro.deadcode.deadcode.hacks.movement.FastLadder;
import mahiro.deadcode.deadcode.hacks.movement.FastStairs;
import mahiro.deadcode.deadcode.hacks.movement.Flight;
import mahiro.deadcode.deadcode.hacks.movement.Glide;
import mahiro.deadcode.deadcode.hacks.movement.HighJump;
import mahiro.deadcode.deadcode.hacks.movement.Jesus;
import mahiro.deadcode.deadcode.hacks.movement.LongJump;
import mahiro.deadcode.deadcode.hacks.movement.NoClip;
import mahiro.deadcode.deadcode.hacks.movement.NoJumpDelay;
import mahiro.deadcode.deadcode.hacks.movement.Parkour;
import mahiro.deadcode.deadcode.hacks.movement.Speed;
import mahiro.deadcode.deadcode.hacks.movement.Spider;
import mahiro.deadcode.deadcode.hacks.movement.Strafe;
import mahiro.deadcode.deadcode.hacks.movement.WaterLeave;
import mahiro.deadcode.deadcode.hacks.movement.WaterSpeed;
import mahiro.deadcode.deadcode.hacks.movement.WebLeave;
import mahiro.deadcode.deadcode.hacks.other.AutoAccept;
import mahiro.deadcode.deadcode.hacks.other.AutoImgur;
import mahiro.deadcode.deadcode.hacks.other.AutoJoin;
import mahiro.deadcode.deadcode.hacks.other.AutoLeave;
import mahiro.deadcode.deadcode.hacks.other.ChatCalc;
import mahiro.deadcode.deadcode.hacks.other.Debug;
import mahiro.deadcode.deadcode.hacks.other.Disconnect;
import mahiro.deadcode.deadcode.hacks.other.DiscordRPC;
import mahiro.deadcode.deadcode.hacks.other.FakeCreative;
import mahiro.deadcode.deadcode.hacks.other.FlagDetect;
import mahiro.deadcode.deadcode.hacks.other.HitSound;
import mahiro.deadcode.deadcode.hacks.other.MCF;
import mahiro.deadcode.deadcode.hacks.other.NoGuiEvents;
import mahiro.deadcode.deadcode.hacks.other.Optimization;
import mahiro.deadcode.deadcode.hacks.other.PacketFilter;
import mahiro.deadcode.deadcode.hacks.other.Sleep;
import mahiro.deadcode.deadcode.hacks.other.StaffDetector;
import mahiro.deadcode.deadcode.hacks.other.Targets;
import mahiro.deadcode.deadcode.hacks.other.Teams;
import mahiro.deadcode.deadcode.hacks.player.AntiAfk;
import mahiro.deadcode.deadcode.hacks.player.AntiFall;
import mahiro.deadcode.deadcode.hacks.player.AntiLevitate;
import mahiro.deadcode.deadcode.hacks.player.AutoArmor;
import mahiro.deadcode.deadcode.hacks.player.AutoEat;
import mahiro.deadcode.deadcode.hacks.player.AutoRespawn;
import mahiro.deadcode.deadcode.hacks.player.AutoTool;
import mahiro.deadcode.deadcode.hacks.player.GuiWalk;
import mahiro.deadcode.deadcode.hacks.player.NoPush;
import mahiro.deadcode.deadcode.hacks.player.NoRotate;
import mahiro.deadcode.deadcode.hacks.player.NoSlow;
import mahiro.deadcode.deadcode.hacks.player.PickupFilter;
import mahiro.deadcode.deadcode.hacks.render.Ambience;
import mahiro.deadcode.deadcode.hacks.render.AntiBadEffects;
import mahiro.deadcode.deadcode.hacks.render.AntiFire;
import mahiro.deadcode.deadcode.hacks.render.BeaconDistance;
import mahiro.deadcode.deadcode.hacks.render.BlockOverlay;
import mahiro.deadcode.deadcode.hacks.render.CameraClip;
import mahiro.deadcode.deadcode.hacks.render.ChestESP;
import mahiro.deadcode.deadcode.hacks.render.ChinaHat;
import mahiro.deadcode.deadcode.hacks.render.Crosshair;
import mahiro.deadcode.deadcode.hacks.render.CustomChat;
import mahiro.deadcode.deadcode.hacks.render.CustomFog;
import mahiro.deadcode.deadcode.hacks.render.CustomRain;
import mahiro.deadcode.deadcode.hacks.render.CustomSnow;
import mahiro.deadcode.deadcode.hacks.render.DeathCoords;
import mahiro.deadcode.deadcode.hacks.render.ESP;
import mahiro.deadcode.deadcode.hacks.render.EnchantColor;
import mahiro.deadcode.deadcode.hacks.render.FreeCam;
import mahiro.deadcode.deadcode.hacks.render.Glowing;
import mahiro.deadcode.deadcode.hacks.render.HUD;
import mahiro.deadcode.deadcode.hacks.render.Item360;
import mahiro.deadcode.deadcode.hacks.render.ItemESP;
import mahiro.deadcode.deadcode.hacks.render.JumpCircle;
import mahiro.deadcode.deadcode.hacks.render.NameProtect;
import mahiro.deadcode.deadcode.hacks.render.NightVision;
import mahiro.deadcode.deadcode.hacks.render.NoHurtCam;
import mahiro.deadcode.deadcode.hacks.render.NoScoreboard;
import mahiro.deadcode.deadcode.hacks.render.NoVisualBlock;
import mahiro.deadcode.deadcode.hacks.render.PlayerRadar;
import mahiro.deadcode.deadcode.hacks.render.Profiler;
import mahiro.deadcode.deadcode.hacks.render.Projectiles;
import mahiro.deadcode.deadcode.hacks.render.ReloadChunks;
import mahiro.deadcode.deadcode.hacks.render.SwingAnimate;
import mahiro.deadcode.deadcode.hacks.render.TargetDirection;
import mahiro.deadcode.deadcode.hacks.render.TextureChanger;
import mahiro.deadcode.deadcode.hacks.render.TotemCounter;
import mahiro.deadcode.deadcode.hacks.render.Tracers;
import mahiro.deadcode.deadcode.hacks.render.Trails;
import mahiro.deadcode.deadcode.hacks.render.Trajectories;
import mahiro.deadcode.deadcode.hacks.render.UserInterface;
import mahiro.deadcode.deadcode.hacks.render.ViewModel;
import mahiro.deadcode.deadcode.hacks.render.WallHack;
import mahiro.deadcode.deadcode.hacks.render.WaterVision;
import mahiro.deadcode.deadcode.hacks.render.WeatherClear;
import mahiro.deadcode.deadcode.hacks.render.WorldTime;
import mahiro.deadcode.deadcode.hacks.render.XRay;
import mahiro.deadcode.deadcode.hacks.render.XRayBypass;
import mahiro.deadcode.deadcode.hacks.render.Zoom;
import mahiro.deadcode.deadcode.hacks.world.AntiArmorStand;
import mahiro.deadcode.deadcode.hacks.world.BedFucker;
import mahiro.deadcode.deadcode.hacks.world.ChestStealer;
import mahiro.deadcode.deadcode.hacks.world.FastBreak;
import mahiro.deadcode.deadcode.hacks.world.LightningDetect;
import mahiro.deadcode.deadcode.hacks.world.MagicCarpet;
import mahiro.deadcode.deadcode.hacks.world.NoInteract;
import mahiro.deadcode.deadcode.hacks.world.Nuker;
import mahiro.deadcode.deadcode.hacks.world.Timer;
import mahiro.deadcode.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import utils.*;

import static utils.et.c;

public class HackManager {
    private static Hack a = null;
    private static ArrayList b;

    public HackManager() {
        b = new ArrayList();
        HackManager.addHack(new Debug());
        HackManager.addHack(new UserInterface());
        HackManager.addHack(new HUD());
        HackManager.addHack(new Blackout());
        HackManager.addHack(new Targets());
        HackManager.addHack(new Teams());
        HackManager.addHack(new NoGuiEvents());
        HackManager.addHack(new Glowing());
        HackManager.addHack(new Trajectories());
        HackManager.addHack(new Projectiles());
        HackManager.addHack(new XRay());
        HackManager.addHack(new XRayBypass());
        HackManager.addHack(new EnchantColor());
        HackManager.addHack(new ESP());
        HackManager.addHack(new ItemESP());
        HackManager.addHack(new ChestESP());
        HackManager.addHack(new Tracers());
        HackManager.addHack(new TargetDirection());
        HackManager.addHack(new Profiler());
        HackManager.addHack(new TextureChanger());
        HackManager.addHack(new Trails());
        HackManager.addHack(new WallHack());
        HackManager.addHack(new Flight());
        HackManager.addHack(new NoPush());
        HackManager.addHack(new Jesus());
        HackManager.addHack(new SwingAnimate());
        HackManager.addHack(new Crosshair());
        HackManager.addHack(new NightVision());
        HackManager.addHack(new WaterVision());
        HackManager.addHack(new NoVisualBlock( ));
        HackManager.addHack(new Ambience());
        HackManager.addHack(new WorldTime());
        HackManager.addHack(new AirJump());
        HackManager.addHack(new AutoTool());
        HackManager.addHack(new AntiBot());
        HackManager.addHack(new AntiArmorStand());
        HackManager.addHack(new AimBot());
        HackManager.addHack(new BowAimBot());
        HackManager.addHack(new TriggerBot());
        HackManager.addHack(new AutoGApple());
        HackManager.addHack(new GoldenAppleDelay());
        HackManager.addHack(new Criticals());
        HackManager.addHack(new KillAura());
        HackManager.addHack(new ShieldBreaker());
        HackManager.addHack(new Reach());
        HackManager.addHack(new SelfDamage());
        HackManager.addHack(new Timer());
        HackManager.addHack(new TotemCounter( ));
        HackManager.addHack(new NoInteract( ));
        HackManager.addHack(new Velocity( ));
        HackManager.addHack(new FastBow());
        HackManager.addHack(new AutoSprint( ));
        HackManager.addHack(new AutoArmor( ));
        HackManager.addHack(new AutoHeal( ));
        HackManager.addHack(new MCF());
        HackManager.addHack(new HitSound(   ));
        HackManager.addHack(new AutoAccept(   ));
        HackManager.addHack(new Disconnect(  ));
        HackManager.addHack(new StaffDetector(   ));
        HackManager.addHack(new ChestStealer(   ));
        HackManager.addHack(new ClickPearl(   ));
        HackManager.addHack(new NoHurtCam(  ));
        HackManager.addHack(new JumpCircle(   ));
        HackManager.addHack(new ViewModel(  ));
        HackManager.addHack(new CustomChat(   ));
        HackManager.addHack(new CustomFog(  ));
        HackManager.addHack(new CustomRain(  ));
        HackManager.addHack(new CustomSnow(   ));
        HackManager.addHack(new CameraClip(  ));
        HackManager.addHack(new WebLeave(   ));
        HackManager.addHack(new WaterLeave(   ));
        HackManager.addHack(new RodLeave(   ));
        HackManager.addHack(new WaterSpeed(   ));
        HackManager.addHack(new NoJumpDelay(   ));
        HackManager.addHack(new NoRotate(  ));
        HackManager.addHack(new NoDamage( ));
        HackManager.addHack(new NoSlow( ));
        HackManager.addHack(new NameProtect(  ));
        HackManager.addHack(new NoScoreboard(  ));
        HackManager.addHack(new BeaconDistance(   ));
        HackManager.addHack(new ReloadChunks(   ));
        HackManager.addHack(new Glide( ));
        HackManager.addHack(new Item360( ));
        HackManager.addHack(new AutoBuff(  ));
        HackManager.addHack(new AutoDebuff(  ));
        HackManager.addHack(new AntiLevitate(  ));
        HackManager.addHack(new Refill(  ));
        HackManager.addHack(new AutoEat( ));
        HackManager.addHack(new AutoJoin(  ));
        HackManager.addHack(new Nuker(   ));
        HackManager.addHack(new AntiFall(   ));
        HackManager.addHack(new NoClip(   ));
        HackManager.addHack(new DeathBow(  ));
        HackManager.addHack(new VClip(  ));
        HackManager.addHack(new HClip( ));
        HackManager.addHack(new TeleportUp(   ));
        HackManager.addHack(new TeleportDown(  ));
        HackManager.addHack(new BedrockTeleport(  ));
        HackManager.addHack(new HighJump(  ));
        HackManager.addHack(new LongJump(  ));
        HackManager.addHack(new MagicCarpet(  ));
        HackManager.addHack(new TargetStrafe(  ));
        HackManager.addHack(new AutoStep(  ));
        HackManager.addHack(new FreeCam(  ));
        HackManager.addHack(new NoCom(  ));
        HackManager.addHack(new BlockOverlay(  ));
        HackManager.addHack(new PluginsGetter(   ));
        HackManager.addHack(new Teleport(  ));
        HackManager.addHack(new GuiWalk( ));
        HackManager.addHack(new PlayerRadar(   ));
        HackManager.addHack(new DeathCoords(  ));
        HackManager.addHack(new Parkour(  ));
        HackManager.addHack(new WeatherClear(  ));
        HackManager.addHack(new AntiAim(   ));
        HackManager.addHack(new AntiWeb( ));
        HackManager.addHack(new AutoTotem(  ));
        HackManager.addHack(new AntiBadEffects(  ));
        HackManager.addHack(new AutoRespawn(   ));
        HackManager.addHack(new HitBox(  ));
        HackManager.addHack(new Speed(   ));
        HackManager.addHack(new FastStairs(   ));
        HackManager.addHack(new Strafe(  ));
        HackManager.addHack(new Spider(  ));
        HackManager.addHack(new FastLadder(   ));
        HackManager.addHack(new AutoWalk(   ));
        HackManager.addHack(new XCarry(  ));
        HackManager.addHack(new AntiAfk(  ));
        HackManager.addHack(new AntiFire(  ));
        HackManager.addHack(new ChinaHat( ));
        HackManager.addHack(new ChatCalc(  ));
        HackManager.addHack(new FastBreak(  ));
        HackManager.addHack(new AutoLeave(   ));
        HackManager.addHack(new FlagDetect(  ));
        HackManager.addHack(new Sleep(  ));
        HackManager.addHack(new class27(  ));
        HackManager.addHack(new BedFucker( ));
        HackManager.addHack(new PortalGodMode( ));
        HackManager.addHack(new PickupFilter(  ));
        HackManager.addHack(new PacketFilter(  ));
        HackManager.addHack(new FakeCreative(   ));
        HackManager.addHack(new Zoom( ));
        HackManager.addHack(new LightningDetect(  ));
        HackManager.addHack(new DiscordRPC(  ));
        HackManager.addHack(new Optimization( ));
        HackManager.addHack(new AutoImgur());
        ChatUtils.debug("Loaded [" + b.size() + "   hacks.");
        ChatUtils.debug("HackManager: initialized.");
    }

    public static Hack getHack(String paramString) {
        Hack hack = null;
        for (Hack hack1 : getHacks()) {
            if (hack1.getName().equalsIgnoreCase(paramString)) {
                hack = hack1;
                break;
            }
        }
        return hack;
    }

    public static List getSortedHacks() {
        List list = c();
        list.sort((Comparator)new eK());
        return list;
    }

    public static void addHack(Hack paramHack) {
        b.add(paramHack);
    }

    public static ArrayList<Hack> getHacks() {
        return b;
    }

    public static Hack d() {
        return a;
    }

    public static void a(int paramInt) {
        if ((Wrapper.INSTANCE.getMinecraft()).currentScreen != null)
            return;
        for (Hack hack : getHacks()) {
            if (hack.r() == paramInt) {
                hack.toggle();
                a = hack;
            }
        }
    }

    public static void b(int paramInt) {
        if ((Wrapper.INSTANCE.getMinecraft()).currentScreen != null)
            return;
        for (Hack hack : getHacks()) {
            if (hack.getKey() == paramInt) {
                hack.toggle();
                a = hack;
            }
            for (Value value : hack.getSettings()) {
                if (value instanceof BooleanValue) {
                    BooleanValue booleanValue = (BooleanValue)value;
                    if (booleanValue.a() == paramInt)
                        booleanValue.a(hack.getName());
                }
            }
        }
    }

    public static void a(PlayerSPPushOutOfBlocksEvent paramPlayerSPPushOutOfBlocksEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onPushOutOfBlocksEvent(paramPlayerSPPushOutOfBlocksEvent);
        }
    }

    public static void a(LivingEntityUseItemEvent paramLivingEntityUseItemEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onEntityUseItemEvent(paramLivingEntityUseItemEvent);
        }
    }

    public static void a(ScreenshotEvent paramScreenshotEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onScreenshotEvent(paramScreenshotEvent);
        }
    }

    public static void a(LivingEvent.LivingJumpEvent paramLivingJumpEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onJumpEvent(paramLivingJumpEvent);
        }
    }

    public static void a(GuiOpenEvent paramGuiOpenEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onGuiOpenEvent(paramGuiOpenEvent);
        }
    }

    public static void a(FMLNetworkEvent.ClientConnectedToServerEvent paramClientConnectedToServerEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onConnectedToServerEvent(paramClientConnectedToServerEvent);
        }
    }

    public static void a(InputUpdateEvent paramInputUpdateEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onInputEvent(paramInputUpdateEvent);
        }
    }

    public static void a(EntityItemPickupEvent paramEntityItemPickupEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onItemPickupEvent(paramEntityItemPickupEvent);
        }
    }

    public static void a(TickEvent.PlayerTickEvent paramPlayerTickEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onPlayerTickEvent(paramPlayerTickEvent);
        }
    }

    public static void a(TickEvent.ClientTickEvent paramClientTickEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onClientTickEvent(paramClientTickEvent);
        }
    }

    public static void a(LivingEvent.LivingUpdateEvent paramLivingUpdateEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onUpdateEvent(paramLivingUpdateEvent);
        }
    }

    public static void a(RenderPlayerEvent paramRenderPlayerEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.onRenderPlayerEvent(paramRenderPlayerEvent);
        }
    }

    public static void a(RenderWorldLastEvent paramRenderWorldLastEvent) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled()) {
                hack.onRenderWorldLastEvent(paramRenderWorldLastEvent);
                for (Object object : et.b())
                    hack.onRenderWorldLastEvent(paramRenderWorldLastEvent, object);
            }
        }
    }

    public static void a(float paramFloat) {
        for (Hack hack : getHacks()) {
            if (hack.isToggled())
                hack.a(paramFloat);
        }
    }
}


/* Location:              C:\Users\Administrator\Desktop\.minecraft\mods\DeadCode-Remap.jar!\i\gishreloaded\deadcode\managers\HackManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
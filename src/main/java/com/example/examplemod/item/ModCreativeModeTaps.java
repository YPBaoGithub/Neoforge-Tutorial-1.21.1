package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTaps {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

    public static final Supplier<CreativeModeTab> ZHUZHUZI_tab = CREATIVE_MODE_TAB.register("zhuzhuzi_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZHUZHUZI.get()))//自定义标签的样式
                    .title(Component.translatable("creativetab.examplemod.zhuzhuzi_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ZHUZHUZI);
                        output.accept(ModBlocks.ZHUZHUZI_BLOCK);
                        output.accept(ModItems.BISMUTH);



                    })



                    .build());



    public static void register(IEventBus bus) {

        CREATIVE_MODE_TAB.register(bus);
    }
}

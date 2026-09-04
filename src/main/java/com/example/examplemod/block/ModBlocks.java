package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ExampleMod.MODID);

    public static final DeferredBlock<Block> ZHUZHUZI_BLOCK = registerBlock("zhuzhuzi_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiredFeatures().sound(SoundType.AMETHYST)));//此处可以填写方块的特性 比如挖掘速度，需要什么工具挖，音效等


    //一键注册方块本体
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        //注册可以放置的方块
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        //注册物品栏图标
        registerBlockItem(name, toReturn);
        return toReturn;
    }




    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

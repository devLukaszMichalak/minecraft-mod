package com.luke.lukestorches.init;

import com.google.common.base.Supplier;
import com.luke.lukestorches.LukesTorches;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LukesTorches.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> VOID_BLOCK = register("void_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_MAGENTA)
                    .strength(1.0f)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()
                    .lightLevel(l->7))
            , object -> () -> new BlockItem(object.get(), new Item.Properties().tab(LukesTorches.LUKES_MOD)));




    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(
            final String name, final Supplier<? extends T> block,
            Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> object = registerBlock(name, block);
        ITEMS.register(name, item.apply(object));
        return object;
    }
}

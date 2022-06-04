package com.luke.lukestorches.init;

import com.google.common.base.Supplier;
import com.luke.lukestorches.LukesTorches;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LukesTorches.MOD_ID);
    public static final RegistryObject<Item> VOID_DUST = register("void_dust",
            () -> new Item(new Item.Properties().tab(LukesTorches.LUKES_MOD)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }
}

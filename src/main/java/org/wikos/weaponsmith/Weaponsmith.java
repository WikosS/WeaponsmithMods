package org.wikos.weaponsmith;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.wikos.weaponsmith.item.Oils;


public class Weaponsmith implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    public static final Item UNDEAD_OILS = new Oils(new FabricItemSettings());
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("weaponsmith", "undead_oils"), UNDEAD_OILS);
    }
}

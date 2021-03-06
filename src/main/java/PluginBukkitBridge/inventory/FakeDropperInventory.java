package PluginBukkitBridge.inventory;

import PluginBukkitBridge.block.FakeContainerBlockState;
import org.bukkit.event.inventory.InventoryType;

/**
 * Created by florian on 28.10.14.
 */
public class FakeDropperInventory extends FakeContainerInventory {
    public FakeDropperInventory(FakeContainerBlockState blockState, int maxStackSize) {
        super(blockState, maxStackSize);
    }

    @Override
    public InventoryType getType() {
        return InventoryType.DROPPER;
    }
}

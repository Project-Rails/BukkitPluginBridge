package PluginBukkitBridge;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

/**
 * Created by florian on 10.10.14.
 */
public class FakeChunk implements Chunk {

    int x, y;
    World world;

    public FakeChunk(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getZ() {
        return y;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public Block getBlock(int i, int i2, int i3) {
        return world.getBlockAt(i+x*16, i2, i3+y*16);
    }

    @Override
    public ChunkSnapshot getChunkSnapshot() {
        MyPlugin.fixme();
        return null;
    }

    @Override
    public ChunkSnapshot getChunkSnapshot(boolean b, boolean b2, boolean b3) {
        MyPlugin.fixme();
        return null;
    }

    @Override
    public Entity[] getEntities() {
        MyPlugin.fixme();
        return new Entity[0];
    }

    @Override
    public BlockState[] getTileEntities() {
        MyPlugin.fixme();
        return new BlockState[0];
    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public boolean load(boolean b) {
        return true;
    }

    @Override
    public boolean load() {
        return true;
    }

    @Override
    public boolean unload(boolean b, boolean b2) {
        MyPlugin.fixme();
        return false;
    }

    @Override
    public boolean unload(boolean b) {
        MyPlugin.fixme();
        return false;
    }

    @Override
    public boolean unload() {
        MyPlugin.fixme();
        return false;
    }
}
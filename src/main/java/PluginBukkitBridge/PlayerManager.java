package PluginBukkitBridge;

import PluginBukkitBridge.entity.FakePlayer;
import PluginReference.MC_Player;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by florian on 14.10.14.
 */
public class PlayerManager {

    public static Cache<UUID, FakePlayer> uuidMap = CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES).build();
    public static Cache<String, FakePlayer> nameMap = CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES).build();

    public static FakePlayer addPlayer(MC_Player player){
        FakePlayer old = uuidMap.getIfPresent(player.getUUID());
        if(old != null)return old;
        FakePlayer player1 = new FakePlayer(player);
        uuidMap.put(player1.getUniqueId(), player1);
        nameMap.put(player1.getName(), player1);
        return player1;
    }

    public static void removePlayer(UUID player){
        FakePlayer player1 = uuidMap.getIfPresent(player);
        if(player1 == null)return;
        uuidMap.invalidate(player);
        nameMap.invalidate(player1.getName());
    }

    public static Player getPlayer(MC_Player player){
		FakePlayer fakePlayer = uuidMap.getIfPresent(player.getUUID());
		if(fakePlayer == null){
			fakePlayer = addPlayer(player);
		}
		fakePlayer.refreshReference(player);
		return fakePlayer;
    }

    public static Player getPlayer(UUID uuid){
        return uuidMap.getIfPresent(uuid);
    }

    public static Player getPlayer(String name){
        return nameMap.getIfPresent(name);
    }
}

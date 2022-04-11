package ipvp.ranks.ipvp_ranks;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class IPVPRanks extends JavaPlugin {

    /*
        Roles:
            Owner: Red
            Co-owner: Red
            Staff: Purple, kick and TP perms
            Developer: Blue
            Ultra member: Black, maybe special items?
            Member: Yellow, given on join
     */

    private static IPVPRanks INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("setrank").setExecutor(new IPVPCommands());
        this.getServer().getPluginManager().registerEvents(new RankEvents(), this);
        INSTANCE = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static IPVPRanks getInstance()
    {
        return INSTANCE;
    }
}

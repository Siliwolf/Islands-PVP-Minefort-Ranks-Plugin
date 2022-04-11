package ipvp.ranks.ipvp_ranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.Permissions;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
        Roles:
            Owner: Red
            Co-owner: Red
            Staff: Purple, kick and TP perms
            Developer: Blue
            Ultra member: Black, maybe special items?
            Member: Yellow, given on join
     */

public class Ranks 
{
    public enum Rank
    {
        NONE(""),
        MEMBER((ChatColor.DARK_GREEN + "[") + (ChatColor.YELLOW + "Member") + (ChatColor.DARK_GREEN + "] ") + (ChatColor.YELLOW)),
        ULTRAMEMBER((ChatColor.GREEN + "[") + (ChatColor.AQUA + "UltraMember") + (ChatColor.GREEN + "] ") + (ChatColor.AQUA)),
        DEVELOPER((ChatColor.GOLD + "[") + (ChatColor.BLUE + "Developer") + (ChatColor.GOLD + "] ") + (ChatColor.BLUE)),
        STAFF((ChatColor.DARK_PURPLE + "[") + (ChatColor.LIGHT_PURPLE + "Staff") + (ChatColor.DARK_PURPLE + "] ") + (ChatColor.LIGHT_PURPLE)),
        COOWNER((ChatColor.DARK_RED + "[") + (ChatColor.RED + "Co-Owner") + (ChatColor.DARK_RED + "] ") + (ChatColor.RED)),
        OWNER((ChatColor.DARK_RED + "[") + (ChatColor.RED + "Owner") + (ChatColor.DARK_RED + "] ") + (ChatColor.RED));

        public final String prefix;

        Rank(String prefix) {
            this.prefix = prefix;
        }
    }

    Map<Player, Rank> ranks = new HashMap<>();

    HashMap<UUID, PermissionAttachment> permsList = new HashMap<>();

    public void GrantPerms(Player player)
    {
        PermissionAttachment attachment = player.addAttachment(IPVPRanks.getInstance());
        permsList.put(player.getUniqueId(), attachment);

        PermissionAttachment playerPerms = permsList.get(player.getUniqueId());

        if(player.getScoreboardTags().contains("um"))
        {
            //Possible custom items in future
        }

        if(player.getScoreboardTags().contains("stf"))
        {
            playerPerms.setPermission("minecraft.command.kick", true);
            playerPerms.setPermission("minecraft.command.teleport", true);
            playerPerms.setPermission("minecraft.command.tp", true);
            playerPerms.setPermission("minecraft.command.selector", true);
            playerPerms.setPermission("IPVPRanks.Staff", true);
        }
    }

    public void StripRanks(Player player)
    {
        if(player.getScoreboardTags().contains("um"))
        {
            player.removeScoreboardTag("um");
        }

        if(player.getScoreboardTags().contains("dev"))
        {
            player.removeScoreboardTag("dev");
        }

        if(player.getScoreboardTags().contains("stf"))
        {
            player.removeScoreboardTag("stf");
        }

        if(player.getScoreboardTags().contains("coowr"))
        {
            player.removeScoreboardTag("coowr");
        }

        if(player.getScoreboardTags().contains("owr"))
        {
            player.removeScoreboardTag("owr");
        }
    }


    public void setRank(Player player, Rank rank) {
        switch (rank)
        {
            case MEMBER:
                player.setDisplayName(Rank.MEMBER.prefix + player.getName());
                player.setPlayerListName(Rank.MEMBER.prefix + player.getName());
                player.addScoreboardTag("m");
                break;
            case ULTRAMEMBER:
                StripRanks(player);
                player.setDisplayName(Rank.ULTRAMEMBER.prefix + player.getName());
                player.setPlayerListName(Rank.ULTRAMEMBER.prefix + player.getName());
                player.addScoreboardTag("um");
                break;
            case DEVELOPER:
                StripRanks(player);
                player.setDisplayName(Rank.DEVELOPER.prefix + player.getName());
                player.setPlayerListName(Rank.DEVELOPER.prefix + player.getName());
                player.addScoreboardTag("dev");
                break;
            case STAFF:
                StripRanks(player);
                player.setDisplayName(Rank.STAFF.prefix + player.getName());
                player.setPlayerListName(Rank.STAFF.prefix + player.getName());
                player.addScoreboardTag("stf");
                break;
            case COOWNER:
                StripRanks(player);
                player.setDisplayName(Rank.COOWNER.prefix + player.getName());
                player.setPlayerListName(Rank.COOWNER.prefix + player.getName());
                player.addScoreboardTag("coowr");
                break;
            case OWNER:
                StripRanks(player);
                player.setDisplayName(Rank.OWNER.prefix + player.getName());
                player.setPlayerListName(Rank.OWNER.prefix + player.getName());
                player.addScoreboardTag("owr");
                break;
            default:
                player.setDisplayName(player.getName());
                player.setPlayerListName(player.getName());
                break;
        }
    }
}

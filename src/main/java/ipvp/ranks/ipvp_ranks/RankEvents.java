package ipvp.ranks.ipvp_ranks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RankEvents implements Listener
{
    /*
        Roles:
            Owner: Red
            Co-owner: Red
            Staff: Purple, kick and TP perms
            Developer: Blue
            Ultra member: Black, maybe special items?
            Member: Yellow, given on join
     */

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e)
    {
        Ranks ranksRef = new Ranks();

        if(!e.getPlayer().getScoreboardTags().contains("m"))
        {
            ranksRef.setRank(e.getPlayer(), Ranks.Rank.MEMBER);
        }

        ranksRef.GrantPerms(e.getPlayer());

        Player player = e.getPlayer();

        if(player.getScoreboardTags().contains("m"))
        {
            player.setDisplayName(Ranks.Rank.MEMBER.prefix + player.getName());
            player.setPlayerListName(Ranks.Rank.MEMBER.prefix + player.getName());
        }

        if(player.getScoreboardTags().contains("um"))
        {
            player.setDisplayName(Ranks.Rank.ULTRAMEMBER.prefix + player.getName());
            player.setPlayerListName(Ranks.Rank.ULTRAMEMBER.prefix + player.getName());
        }

        if(player.getScoreboardTags().contains("dev"))
        {
            player.setDisplayName(Ranks.Rank.DEVELOPER.prefix + player.getName());
            player.setPlayerListName(Ranks.Rank.DEVELOPER.prefix + player.getName());
        }

        if(player.getScoreboardTags().contains("stf"))
        {
            player.setDisplayName(Ranks.Rank.STAFF.prefix + player.getName());
            player.setPlayerListName(Ranks.Rank.STAFF.prefix + player.getName());
        }

        if(player.getScoreboardTags().contains("coowr"))
        {
            player.setDisplayName(Ranks.Rank.COOWNER.prefix + player.getName());
            player.setPlayerListName(Ranks.Rank.COOWNER.prefix + player.getName());
        }

        if(player.getScoreboardTags().contains("owr"))
        {
            player.setDisplayName(Ranks.Rank.OWNER.prefix + player.getName());
            player.setPlayerListName(Ranks.Rank.OWNER.prefix + player.getName());
        }
    }
}

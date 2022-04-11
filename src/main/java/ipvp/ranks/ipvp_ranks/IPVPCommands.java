package ipvp.ranks.ipvp_ranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class IPVPCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
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

        Ranks ranks = new Ranks();

        Player target = null;

        for(Player p : Bukkit.getOnlinePlayers())
        {
            if(p.getName().equals(args[1]))
            {
                target = Bukkit.getPlayer(args[1]);
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "Requested player is not online");
                return false;
            }
        }


        if(args[0].equals("member"))
        {
            ranks.setRank(target, Ranks.Rank.MEMBER);
        }
        else if(args[0].equals("ultramember"))
        {
            ranks.setRank(target, Ranks.Rank.ULTRAMEMBER);
        }
        else if(args[0].equals("developer") && sender instanceof ConsoleCommandSender)
        {
            ranks.setRank(target, Ranks.Rank.DEVELOPER);
        }
        else if(args[0].equals("staff") && sender instanceof ConsoleCommandSender)
        {
            ranks.setRank(target, Ranks.Rank.STAFF);
        }
        else if(args[0].equals("coowner") && sender instanceof ConsoleCommandSender)
        {
            ranks.setRank(target, Ranks.Rank.COOWNER);
        }
        else if(args[0].equals("owner") && sender instanceof ConsoleCommandSender)
        {
            ranks.setRank(target, Ranks.Rank.OWNER);
        }
        else
        {
            if(sender instanceof Player)
            {
                Player p = ((Player) sender).getPlayer();

                p.sendRawMessage(ChatColor.RED + "Incorrect usage of command! Accepted subcommands: member, ultramember, developer, staff, coowner, owner. Last four can only be executed in server console. Input player name after that");
            }
            if(sender instanceof ConsoleCommandSender)
            {
                Bukkit.getLogger().warning(ChatColor.RED + "Incorrect usage of command! Accepted subcommands: member, ultramember, developer, staff, coowner, owner. Last four can only be executed in server console. Input player name after that");
            }
        }

        return true;
    }
}

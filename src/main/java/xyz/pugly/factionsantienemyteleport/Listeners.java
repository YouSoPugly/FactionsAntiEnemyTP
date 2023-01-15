package xyz.pugly.factionsantienemyteleport;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.perms.Relation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (event.getTo() == null) return;

        if (!(event.getCause().equals(PlayerTeleportEvent.TeleportCause.CHORUS_FRUIT))) {
            return;
        }

        Player p = event.getPlayer();

        if (p.hasPermission("factionsteleport.bypass")) {
            return;
        }

        FLocation toLoc = new FLocation(event.getTo());


        FPlayer fp = FPlayers.getInstance().getByPlayer(p);

        Faction fac = fp.getFaction();
        Faction toFac = Board.getInstance().getFactionAt(toLoc);

        Relation relation = fac.getRelationTo(toFac);

        if (!relation.isMember()) {
            event.setCancelled(true);
            p.sendMessage("§cYou cannot chorus fruit into other player's land!");
        }
    }

}

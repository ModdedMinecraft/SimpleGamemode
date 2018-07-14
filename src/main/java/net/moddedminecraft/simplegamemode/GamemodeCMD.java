package net.moddedminecraft.simplegamemode;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class GamemodeCMD implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player player;
        if (src instanceof Player) {
            player = (Player) src;
            if (player.gameMode().get().equals(GameModes.CREATIVE))
            {
                player.offer(player.gameMode().set(GameModes.SURVIVAL));
                player.sendMessage(Text.of(TextColors.GOLD, "Changed your Gamemode to ", TextColors.RED ,"Survival", TextColors.GOLD ,"!"));
                return CommandResult.success();
            }
            if (player.gameMode().get().equals(GameModes.SURVIVAL))
            {
                player.offer(player.gameMode().set(GameModes.CREATIVE));
                player.sendMessage(Text.of(TextColors.GOLD, "Changed your Gamemode to ", TextColors.RED ,"Creative", TextColors.GOLD ,"!"));
                return CommandResult.success();
            }
            if (player.gameMode().get().equals(GameModes.ADVENTURE))
            {
                player.offer(player.gameMode().set(GameModes.CREATIVE));
                player.sendMessage(Text.of(TextColors.GOLD, "Changed your Gamemode to ", TextColors.RED ,"Creative", TextColors.GOLD ,"!"));
                return CommandResult.success();
            }
            if (player.gameMode().get().equals(GameModes.SPECTATOR))
            {
                player.offer(player.gameMode().set(GameModes.CREATIVE));
                player.sendMessage(Text.of(TextColors.GOLD, "Changed your Gamemode to ", TextColors.RED ,"Creative", TextColors.GOLD ,"!"));
                return CommandResult.success();
            }
            return CommandResult.success();

        } else {
            src.sendMessage(Text.of("Only players can run this command!"));
            return CommandResult.success();
        }
    }
}

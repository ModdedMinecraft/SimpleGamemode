package net.moddedminecraft.simplegamemode;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;

import java.util.Optional;

public class GamemodeCMD implements CommandExecutor {

    private final Main plugin;

    public GamemodeCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Optional<String> gmOp = args.<String>getOne("Gamemode");
        Optional<Player> plOP = args.<Player>getOne("Player");
        if (src instanceof Player) {
            Player player = (Player) src;
            GameMode gamemode = player.gameMode().get();
            if (gmOp.isPresent()) {
                String gmode = gmOp.get();
                if (plOP.isPresent()) {
                    if (player.hasPermission("simplegamemode.other")) {
                        throw new CommandException(plugin.fromLegacy("&cYou do not have permission to change another users gamemode."));
                    } else {
                        Player player2 = plOP.get();
                        switch (gmode) {
                            case "s":
                                player2.offer(player.gameMode().set(GameModes.SURVIVAL));
                                player.sendMessage(plugin.fromLegacy("&6Changed " + player2.getName() + "'s Gamemode to &4Survival&6!"));
                                player2.sendMessage(plugin.fromLegacy("&6Your Gamemode has been changed to &4Survival&6!"));
                                break;
                            case "c":
                                player2.offer(player.gameMode().set(GameModes.CREATIVE));
                                player.sendMessage(plugin.fromLegacy("&6Changed " + player2.getName() + "'s Gamemode to &4Creative&6!"));
                                player2.sendMessage(plugin.fromLegacy("&6Your Gamemode has been changed to &4Creative&6!"));
                                break;
                            case "a":
                                player2.offer(player.gameMode().set(GameModes.ADVENTURE));
                                player.sendMessage(plugin.fromLegacy("&6Changed " + player2.getName() + "'s Gamemode to &4Adventure&6!"));
                                player2.sendMessage(plugin.fromLegacy("&6Your Gamemode has been changed to &4Adventure&6!"));
                                break;
                            case "sp":
                                player2.offer(player.gameMode().set(GameModes.SPECTATOR));
                                player.sendMessage(plugin.fromLegacy("&6Changed " + player2.getName() + "'s Gamemode to &4Spectator&6!"));
                                player2.sendMessage(plugin.fromLegacy("&6Your Gamemode has been changed to &4Spectator&6!"));
                                break;
                            default:
                                throw new CommandException(plugin.fromLegacy("&cInvalid usage: /gm [s/c/a/sp] [Player]"));
                        }
                        return CommandResult.success();
                    }
                } else {
                    switch (gmode) {
                        case "s":
                            player.offer(player.gameMode().set(GameModes.SURVIVAL));
                            player.sendMessage(plugin.fromLegacy("&6Changed Gamemode to &4Survival&6!"));
                            break;
                        case "c":
                            player.offer(player.gameMode().set(GameModes.CREATIVE));
                            player.sendMessage(plugin.fromLegacy("&6Changed Gamemode to &4Creative&6!"));
                            break;
                        case "a":
                            player.offer(player.gameMode().set(GameModes.ADVENTURE));
                            player.sendMessage(plugin.fromLegacy("&6Changed Gamemode to &4Adventure&6!"));
                            break;
                        case "sp":
                            player.offer(player.gameMode().set(GameModes.SPECTATOR));
                            player.sendMessage(plugin.fromLegacy("&6Changed Gamemode to &4Spectator&6!"));
                            break;
                        default:
                            throw new CommandException(plugin.fromLegacy("&cInvalid usage: /gm [s/c/a/sp]"));
                    }
                    return CommandResult.success();
                }
            } else {
                if (gamemode.equals(GameModes.CREATIVE)) {
                    player.offer(player.gameMode().set(GameModes.SURVIVAL));
                    player.sendMessage(plugin.fromLegacy("&6Changed your Gamemode to &4Survival&6!"));
                } else if (gamemode.equals(GameModes.SURVIVAL)) {
                    player.offer(player.gameMode().set(GameModes.CREATIVE));
                    player.sendMessage(plugin.fromLegacy("&6Changed your Gamemode to &4Creative&6!"));
                } else if (gamemode.equals(GameModes.ADVENTURE)) {
                    player.offer(player.gameMode().set(GameModes.SURVIVAL));
                    player.sendMessage(plugin.fromLegacy("&6Changed your Gamemode to &4Survival&6!"));
                } else if (gamemode.equals(GameModes.SPECTATOR)) {
                    player.offer(player.gameMode().set(GameModes.SURVIVAL));
                    player.sendMessage(plugin.fromLegacy("&6Changed your Gamemode to &4Survival&6!"));
                } else {
                    throw new CommandException(plugin.fromLegacy("Gamemode not set"));
                }
                return CommandResult.success();
            }
        } else {
            throw new CommandException(plugin.fromLegacy("Only players can run this command!"));
        }
    }
}

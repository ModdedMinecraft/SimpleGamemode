package net.moddedminecraft.simplegamemode;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(id = "simplegamemode", name = "SimpleGamemode", version = "1.0")
public class Main {

    @Inject
    public Logger logger;

    private CommandManager cmdManager = Sponge.getCommandManager();

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        // /gm
        CommandSpec gm = CommandSpec.builder()
                .description(Text.of("Change Gamemode easily"))
                .permission("simplegamemode.gamemode")
                .executor(new GamemodeCMD())
                .build();
        cmdManager.register(this, gm, "gm");

        logger.info("SimpleGamemode Enabled");
    }
}

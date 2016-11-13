import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.text.Text;

public class Main {

    @Inject
    public Logger logger;

    private CommandManager cmdManager = Sponge.getCommandManager();

    public void onServerStart(GameStartedServerEvent event) {
        // /gm
        CommandSpec gm = CommandSpec.builder()
                .description(Text.of("Change Gamemode easily"))
                .permission("mmce.Gamemode")
                .executor(new GamemodeCMD())
                .build();
        cmdManager.register(this, gm, "gm");
        logger.info("SimpleGamemode Enabled");
    }
}

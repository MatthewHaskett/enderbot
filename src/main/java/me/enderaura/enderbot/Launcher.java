package me.enderaura.enderbot;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.enderaura.enderbot.listener.ReadyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.reflections.Reflections;

import javax.security.auth.login.LoginException;

/**
 * @author Enderaura
 * @since 26/10/2018 17:49.
 */
public class Launcher {

    private JDA jda;

    public static void main(String[] args){
        new Launcher().start();
    }

    private void start(){

        try {

            CommandClientBuilder commandClientBuilder = new CommandClientBuilder()
                    .setOwnerId("178806549710503936")
                    .setPrefix("!");

            for (Class<? extends Command> clazz : new Reflections("me.enderaura.enderbot").getSubTypesOf(Command.class)) {
                try {
                    System.out.println("Registering " + clazz.getSimpleName());
                    commandClientBuilder.addCommand(clazz.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

            new JDABuilder(AccountType.BOT)
                    .setToken("NTA1NDI0Nzk2ODUxNTAzMTA0.DrTZUQ.GksIm_9h9Bh-tp6XMjTMvJz_5Pc")
                    .addEventListener(
                            commandClientBuilder.build(),
                            new ReadyListener()
                    )
                    .build();

        } catch (LoginException e) {
            System.out.println("Error logging in to bot account!");
        }
    }


}

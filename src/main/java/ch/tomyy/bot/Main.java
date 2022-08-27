package ch.tomyy.bot;

import ch.tomyy.bot.events.ButtonInteractionListener;
import ch.tomyy.bot.events.JoinListener;
import ch.tomyy.bot.events.MessageReceived;
import ch.tomyy.bot.events.QuitListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {


    public static void main(String[] args) {
        try {
            JDA jda = JDABuilder.createDefault("OTkwNTI5NjM2NTIzOTk1MTU2.Gk9C3d.5dJrmRfrVF345GegKoXbLC0mXR0Y8JV44FXvsE", GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)
                    .setStatus(OnlineStatus.ONLINE)
                    .setActivity(Activity.listening("T0myy zu"))
                    .build();

            jda.addEventListener(new JoinListener());
            jda.addEventListener(new QuitListener());
            jda.addEventListener(new MessageReceived());
            jda.addEventListener(new ButtonInteractionListener());

        }catch (LoginException e) {
            System.out.println("Der Bot Token ist falsch");
        }


    }
}
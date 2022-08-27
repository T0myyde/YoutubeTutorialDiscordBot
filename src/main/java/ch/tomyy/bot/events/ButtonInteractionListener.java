package ch.tomyy.bot.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonInteractionListener extends ListenerAdapter {


    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        event.deferEdit().queue();
        Guild guild = event.getGuild();
        int min = 1000;
        int max = 99999;
        int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (event.getButton().getId().equalsIgnoreCase("support")) {
            guild.createTextChannel("Support-ticket-" + randomInt, guild.getCategoryById("991979639469776936")).queue();

        } else if (event.getButton().getId().equalsIgnoreCase("bug")) {
            guild.createTextChannel("Bug-ticket-" + randomInt, guild.getCategoryById("991979639469776936")).queue();
        }
    }

}

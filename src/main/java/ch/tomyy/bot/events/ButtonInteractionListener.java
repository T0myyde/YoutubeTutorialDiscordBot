package ch.tomyy.bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.EnumSet;

public class ButtonInteractionListener extends ListenerAdapter {


    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        event.deferEdit().queue();
        Guild guild = event.getGuild();
        Member member = event.getMember();
        int min = 1000;
        int max = 99999;
        int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (event.getButton().getId().equalsIgnoreCase("support")) {
            guild.createTextChannel("Support-ticket-" + randomInt, guild.getCategoryById("991979639469776936"))
                    .addPermissionOverride(event.getMember(), EnumSet.of(Permission.VIEW_CHANNEL), null)
                    .addPermissionOverride(guild.getRoleById("749338072377720923"), EnumSet.of(Permission.VIEW_CHANNEL), null)
                    .addPermissionOverride(guild.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                    .complete()
                    .sendMessageEmbeds(ticketEmbed("support", member).build()).setActionRow(Button.danger("close", "Schliessen"))
                    .queue();

        } else if (event.getButton().getId().equalsIgnoreCase("bug")) {
            guild.createTextChannel("Bug-ticket-" + randomInt, guild.getCategoryById("991979639469776936"))
                    .addPermissionOverride(event.getMember(), EnumSet.of(Permission.VIEW_CHANNEL), null)
                    .addPermissionOverride(guild.getRoleById("749338072377720923"), EnumSet.of(Permission.VIEW_CHANNEL), null)
                    .addPermissionOverride(guild.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                    .complete()
                    .sendMessageEmbeds(ticketEmbed("bug", member).build()).setActionRow(Button.danger("close", "Schliessen"))
                    .queue();

        } else if (event.getButton().getId().equalsIgnoreCase("close")) {
            event.getInteraction().getChannel().delete().queue();
        }
    }

    private EmbedBuilder ticketEmbed(String text, Member member) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.BLUE);
        embedBuilder.setTitle("Ticket System");
        embedBuilder.setDescription("Dir wird bald geholfen <@"+member.getId()+">");
        embedBuilder.addField("Kategorie", text, true);

        return embedBuilder;
    }

}

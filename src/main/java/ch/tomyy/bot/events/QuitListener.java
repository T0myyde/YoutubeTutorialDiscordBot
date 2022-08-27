package ch.tomyy.bot.events;


import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class QuitListener extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        TextChannel channel = event.getGuild().getTextChannelById("991238215958798356");

        if (channel != null) {
            channel.sendMessage("Bye ! " + event.getUser().getName()).queue();
        } else {
            System.out.println("Der Channel Exsistiert nicht");
        }
    }

}

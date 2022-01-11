package StudyingBot.StudyingBot;

import java.util.HashMap;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Commands extends ListenerAdapter {
HashMap<User, Person> Members= new HashMap<User,Person>();

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		User user=event.getMember().getUser();
		String name= Members.containsKey(user)? Members.get(user).getName():user.getName();
		if(!(Members.containsKey(user))) {
			Members.put(user, new Person(name));
		}
		
		String[] words= event.getMessage().getContentRaw().split("\\s+");
		if(words[0].equalsIgnoreCase(StudyBot.prefix+"test")) {
			event.getChannel().sendMessage(name+ " Is Currently Studying").queue();;
			for(int i =0;i<words.length;i++) {
				String s= words[i];
				System.out.print(s+", ");
			}
			
		}
		//start study time command
		if(words[0].equalsIgnoreCase(StudyBot.prefix+"start")) {
			event.getChannel().sendMessage(name+" has started studying").queue();;
			if(Members.containsKey(user)) {
				Members.get(user).startStudying();
			}else {
				Members.put(user, new Person(user.getName()));
				Members.get(user).startStudying();
			}
		}
		//check study time command
		if(words[0].equalsIgnoreCase(StudyBot.prefix+"time")) {
			
			if(!(Members.get(user).studying)) {
				event.getChannel().sendMessage(name+" has not started studying. Type !start to start.").queue();
			}
			Person p = Members.get(user);
			event.getChannel().sendMessage(name+" has been study for "+p.getStudyTime()+" seconds").queue();
		}
		//sets name
		if(words[0].equalsIgnoreCase(StudyBot.prefix+"setname")){
			if(words.length>1) {
					Members.get(user).setName(words[1]);
					event.getChannel().sendMessage("I will now adress you as "+ words[1]).queue();
			}
		}
		
		
		
	};
}

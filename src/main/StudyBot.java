package StudyingBot.StudyingBot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


public class StudyBot {
static JDA jda;
public static String prefix = "!";
public static void main(String[] args) throws Exception  {
	jda = JDABuilder.createDefault("ODQ0MzQ3MjY5MDU0ODU3MjU2.YKRFrA.4QBEh5vHVNHyG-gy3rMKl8dDobA")
			.setActivity(Activity.watching("You Study"))
			.setStatus(OnlineStatus.ONLINE)
			.addEventListeners(new Commands())
			.build()
			.awaitReady();
}

}

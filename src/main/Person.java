package StudyingBot.StudyingBot;

public class Person {
	
	private String name;
	private long studyStartTime=0;
	public boolean studying=false;
	Person(String name){
	this.name=name;
}
	public void setName(String name){
	this.name=name;
}
	public String getName() {
		return name;
	}
	public void startStudying() {
		studyStartTime=System.currentTimeMillis();
		studying=true;
	}
	public int getStudyTime() {
		return (int) ((System.currentTimeMillis()-studyStartTime)/1000);
	}
	

}

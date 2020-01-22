package bespin.spring.domain;

public class User {
	private int bno;
	private String username;
	private String team;
	private int age;
	
	public User() {}
	public User(int bno, String username, String team, int age ) {
		this.bno=bno;
		this.username=username;
		this.team=team;
		this.age=age;
		
		
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [bno=" + bno + ", username=" + username + ", team=" + team + ", age=" + age + "]";
	}
	

}

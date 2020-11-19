
public class Student {
	public int id;
	public String name;
	public String surname;
	Student(int id, String n, String s){
		this.id = id;
		name = n;
		surname = s;
	}
	public void run() {
		System.out.println("run "+name);
	}
	public String toString() {
		return id+" "+name+" "+surname;
	}
}

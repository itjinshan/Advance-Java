package scale;

public class AssistDrive extends Thread {
	private EditOptions temp;
	private int operation = 0;
	private String[] changes;
	

	public AssistDrive(int oper, String[] chgs, EditOptions t) {
		operation = oper;
		changes = chgs;
		this.temp = t;
	}

	public void run() {
		ops();
	}
	
	public void ops()
	{
		switch (operation) {
		case 1: {
			temp.updateOptionSN(changes[0], changes[1], changes[2], changes[3]);
			break;
		}
		case 2: {
			temp.updateOptionP(changes[0], changes[1], changes[2], changes[3], Float.parseFloat(changes[4]));
			break;
		}
		}
	}
}

package scale;

import adpter.ProxyAutomobile;
import model.*;

public class EditOptions extends ProxyAutomobile {
	private boolean ava = false;

	public synchronized void updateOptionSN(String brand, String modelname, String optionSetname, String newName) {
		while (ava == false) {
			try {
				System.out.println("Waiting to update Name...");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Done waiting! ");
			}
		}

		Automobile a1;
		a1 = this.findAuto(brand);
		a1.updateOptionSet(optionSetname, newName);
		System.out.println("*********************************************");
		System.out.println("~ Option Set updated with synchronized method!");
		System.out.println("*********************************************");
		ava = false;
		notifyAll();
	}

	public synchronized void updateOptionP(String brand, String modelname, String optionSetname, String option,
			float newprice) {
		while (ava == true) {
			try {
				System.out.println("Waiting to update Price...");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Done waiting! ");
			}
		}

		Automobile a1;
		a1 = this.findAuto(brand);
		a1.updateOption(a1.getOptionSet(a1.findOptionSet(optionSetname)), option, newprice);
		System.out.println("**********************************************");
		System.out.println("~ Option Price updated with synchronized method!");
		System.out.println("**********************************************");
		ava = true;
		notifyAll();
	}
}
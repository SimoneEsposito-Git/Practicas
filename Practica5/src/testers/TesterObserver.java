package testers;

import registration.Registration;
import registration.RegistrationKind;

public class TesterObserver extends TesterStateChanges {
    public static void main(String[] args) {
        TesterObserver tsc = new TesterObserver();
        tsc.createRegistrations();
        Registration.withTracker(tsc.regState);
        System.out.println(tsc.regState);
        tsc.changeRegistrations();
        System.out.println(tsc.regState);
    }

    @Override
    protected void changeRegistrations() {
        this.annSmith.setAffiliation("University of Miskatonic"); // now it is filled
        this.johnDoe.pay(RegistrationKind.STUDENT.getPrice()); // becomes payed
        // regState.updateStates(); // not needed anymore
    }
}
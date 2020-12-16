public class SignalSwitch extends AbstractSignal {
    private int power;

    SignalSwitch(SignalType signalType, int address, boolean forward, int power) {
        setAddress(address);
        setType(signalType);
        setForward(forward);
        setPower(power);
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

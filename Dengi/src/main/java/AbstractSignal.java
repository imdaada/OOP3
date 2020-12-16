public abstract class AbstractSignal {
    private SignalType type;
    private int address;
    private boolean forward;

    public int getAddress() {
        return address;
    }

    public SignalType getType() {
        return type;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setType(SignalType type) {
        this.type = type;
    }

    public boolean isForward() {
        return forward;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }
}

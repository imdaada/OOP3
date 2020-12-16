public class Device {
    protected boolean state = true;
    protected int id;
    protected int power;
    protected Node node;

    Device (int id, int power) {
        this.id = id;
        this.power = power;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getPower() {
        return power;
    }

    public boolean isState() {
        return state;
    }

    /*public void signal(Signal signal) {
        if (signal.getAddress() == id) {
            if(signal.getType() == 1) {
                if (!state) {
                    state = true;
                    node.getHub().signal(new Signal(0, id, power));
                }
            }
            else if (signal.getType() == 2) {
                if (state) {
                    state = false;
                    node.getHub().signal(new Signal(-1, id, power));
                }
            }
        }
    }*/
    public void signal(AbstractSignal signal) {
        if (signal.getAddress() == id) {
            if(signal.getType() == SignalType.ON) {
                if (!state) {
                    state = true;
                    node.getHub().signal(new SignalSwitch(SignalType.ON_BACK, id, false, power));
                }
            }
            else if (signal.getType() == SignalType.OFF) {
                if (state) {
                    state = false;
                    node.getHub().signal(new SignalSwitch(SignalType.OFF_BACK, id, false, power));
                }
            }
        }
    }
}

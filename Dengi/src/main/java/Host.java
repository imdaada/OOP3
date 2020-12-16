public class Host extends Hub {
    private final int power;
    private int powerNow = 0;
    private Hub hub;

    Host (int power, Hub hub) {
        super(1);
        this.power = power;
        this.hub = hub;
        hub.setNode(new Node(this));
    }

    /*@Override
    public void signal(Signal signal) {
        if (signal.getType()>0) {
            hub.signal(signal);
        }
        else {
            if (signal.getType()==0) {
                this.powerNow += signal.getContent();
                if (powerNow>power) {
                    off(signal.getAddress());
                }
            }
            if (signal.getType()==-1) {
                this.powerNow -= signal.getContent();
            }
        }
    }*/

    @Override
    public void signal(AbstractSignal signal) {
        if (signal.isForward()) {
            hub.signal(signal);
        }
        else {
            if (signal.getType()==SignalType.ON_BACK) {
                this.powerNow += ((SignalSwitch) signal).getPower();
                if (powerNow>power) {
                    off(signal.getAddress());
                }
            }
            if (signal.getType()==SignalType.OFF_BACK) {
                this.powerNow -= ((SignalSwitch) signal).getPower();
            }
        }
    }

    public Hub getHub() {
        return hub;
    }

    public void on(int id) {
        hub.signal(new SignalSwitch(SignalType.ON, id, true, 0));
    }

    public void  off(int id) {
        hub.signal(new SignalSwitch(SignalType.OFF, id, true, 0));
    }

    public void print(int id, String string) {
        hub.signal(new SignalPrint(SignalType.PRINT, id, true, string));
    }
}

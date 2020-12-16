public class Printer extends Device {
    Printer(int id, int power) {
        super(id, power);
    }

    @Override
    public void signal(AbstractSignal signal) {
        super.signal(signal);
        if (signal.getAddress() == this.id && signal.getType() == SignalType.PRINT && isState())
            System.out.println(((SignalPrint)signal).getText());
    }
}

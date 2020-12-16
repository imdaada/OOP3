public class SignalPrint extends AbstractSignal {
    private String text;

    SignalPrint(SignalType signalType, int address, boolean forward, String text)
    {
        setAddress(address);
        setType(signalType);
        setForward(forward);
        setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

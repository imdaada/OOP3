import java.util.ArrayList;

public class Hub {
    private final int size;
    private int freeSize;
    private ArrayList<Device> devices = new ArrayList<Device>();
    private ArrayList<Hub> hubs = new ArrayList<Hub>();
    private Node node;

    Hub (int size) {
        this.size = size;
        freeSize = size;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void add(Device device) {
        if (freeSize>0) {
            devices.add(device);
            device.setNode(new Node(this));
            signal(new SignalSwitch(SignalType.ON_BACK, device.id, false,  device.getPower()));
        }
    }

    public void add(Hub hub) {
        if (freeSize>0) {
            hubs.add(hub);
            hub.setNode(new Node(this));
        }
    }

  /*  public void signal (Signal signal) {
        if (signal.getType()>0) {
            for (Device device : devices) {
                device.signal(signal);
            }
            for (Hub a : hubs) {
                a.signal(signal);
            }
        }
        else {
            node.getHub().signal(signal);
        }
    } */
  public void signal (AbstractSignal signal) {
      if (signal.isForward()) {
          for (Device device : devices) {
              device.signal(signal);
          }
          for (Hub a : hubs) {
              a.signal(signal);
          }
      }
      else {
          node.getHub().signal(signal);
      }
  }
}

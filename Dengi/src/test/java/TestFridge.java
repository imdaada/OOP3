import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

 public class TestFridge {
     @Test
     public void testMoney() {
         Mouse mouse = new Mouse(1, 100);
         Scanner scanner = new Scanner(2, 200);
         Printer printer = new Printer(3, 300);
         Hub hub = new Hub(4);
         Hub hub1 = new Hub(3);
         Host host = new Host(300, hub);
         hub.add(mouse);
         hub.add(scanner);
         hub.add(printer);
         assertTrue(mouse.isState());
         assertTrue(scanner.isState());
         assertFalse(printer.isState());
         host.off(1);
         host.off(2);
         host.on(3);
         assertFalse(mouse.isState());
         assertFalse(scanner.isState());
         assertTrue(printer.isState());
         host.print(3, "Hello world!");
     }
 }

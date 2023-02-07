import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Map;

import static java.lang.System.exit;

public class AutoClicker {
    public static boolean run = true;
    public static int interval;
    public static void main(String[] args) {
        //1000 = 1 second
        interval = 1000;
        Start();
    }


    public static void click(int x, int y) throws AWTException, InterruptedException {


        GlobalMouseHook mouseHook = new GlobalMouseHook();
        mouseHook.addMouseListener(new GlobalMouseAdapter() {
            @Override
            public void mousePressed(GlobalMouseEvent event) {
                if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
                    try {
                        run = false;
                        exit(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Robot bot = new Robot();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(interval);
        }
    }


    public static void Start() {
        // Might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails
        GlobalMouseHook mouseHook = new GlobalMouseHook(); // Add true to the constructor, to switch to raw input mode

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("| Press [middle] mouse wheel to begin. Press [middle] mouse wheel again to terminate |");
        System.out.println("--------------------------------------------------------------------------------------\n\n");
        System.out.println("Global mouse hook successfully started. Connected mice:");

        for (Map.Entry<Long, String> mouse : GlobalMouseHook.listMice().entrySet()) {
            System.out.format("%d: %s\n", mouse.getKey(), mouse.getValue());
        }
        mouseHook.addMouseListener(new GlobalMouseAdapter() {

            @Override
            public void mousePressed(GlobalMouseEvent event) {
                if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
                    try {
                        click(event.getX(), event.getY());
                    } catch (AWTException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        try {
            while (run) {
                Thread.sleep(128);
            }
        } catch (InterruptedException e) {
            //Do nothing
        } finally {
            mouseHook.shutdownHook();
        }
    }
}

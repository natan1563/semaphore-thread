package thread;

import colors.BaseCollor;

public class ThreadOfColors extends Thread{
    private long timeout = 0;

    private Thread notifier;

    private BaseCollor color;

    public ThreadOfColors(long timeout, BaseCollor color) {
        this.timeout = timeout;
        this.color = color;
    }

    @Override
    public void run() {
        try {
            this.syncColor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void syncColor() throws InterruptedException {
        synchronized (this) {
            Thread actualThread = new Thread(this);
            this.color.showCollor();
            actualThread.wait(this.getTimeout());
        }
    }

    private long getTimeout() {
        return this.timeout;
    }

    private Thread getNotifier() {
        return notifier;
    }

    public void setNotifier(Thread notifier) {
        this.notifier = notifier;
    }
}

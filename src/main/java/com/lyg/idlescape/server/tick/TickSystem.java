package com.lyg.idlescape.server.tick;

public class TickSystem implements Runnable {
    private Thread thread;
    private volatile boolean isRunning;
    private final long TICK_DURATION = 600; // Tick duration in ms

    private long accumulatedTime;
    private long lastTime;
    private int tick;

    public void start() {
        if(thread != null && thread.isAlive() && Thread.currentThread() != thread){
            stop();
        }

        thread = new Thread(this);
        resetState();
        isRunning = true;
        thread.start();
        System.out.println("Tick System started");
    }

    private void resetState(){
        accumulatedTime = 0;
        lastTime = System.currentTimeMillis();
        tick = 0;
    }

    public void stop() {
        isRunning = false;
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tick System stopped");
    }

    @Override
    public void run() {
        while(isRunning) {
            var currentTime = System.currentTimeMillis();
            var deltaTime = currentTime - lastTime;
            lastTime = currentTime;

            accumulatedTime += deltaTime;

            while(accumulatedTime >= TICK_DURATION){
                accumulatedTime -= TICK_DURATION;
                tick++;
                System.out.println(tick);
            }
            try{
                var sleep = Math.clamp(TICK_DURATION - accumulatedTime, 1, TICK_DURATION);
                Thread.sleep(sleep);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}

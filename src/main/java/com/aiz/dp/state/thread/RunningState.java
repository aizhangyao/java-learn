package com.aiz.dp.state.thread;

public class RunningState extends ThreadState_{
    private _Thread t;

    public RunningState(_Thread t) {
        this.t = t;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}

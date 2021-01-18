package com.aiz.dp.state.thread;

public class TerminatedState extends ThreadState_{
    private _Thread t;

    public TerminatedState(_Thread t) {
        this.t = t;
    }

    @Override
    void move(Action input) {
        if(input.msg == "start")
            t.state = new RunningState(t);
    }

    @Override
    void run() {

    }
}

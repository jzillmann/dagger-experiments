package io.morethan.dagger_experiments.models;

import com.google.common.base.MoreObjects;

public class App {

    private final Server _server;
    private final double _threshold;

    public App(Server server, double threshold) {
        _server = server;
        _threshold = threshold;
    }

    public Server server() {
        return _server;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .addValue(_server)
                .addValue(_threshold)
                .toString();
    }
}

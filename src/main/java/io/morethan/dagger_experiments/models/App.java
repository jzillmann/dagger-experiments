package io.morethan.dagger_experiments.models;

import com.google.common.base.MoreObjects;

public class App {

    private final Server _server;

    public App(Server server) {
        _server = server;
    }

    public Server server() {
        return _server;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(_server).toString();
    }
}

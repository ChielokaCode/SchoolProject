package org.school.schoolproject.services;

@FunctionalInterface
public interface QueueInterface<P,S> {
    void accept(P p, S s);
}

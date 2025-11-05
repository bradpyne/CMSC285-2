package main;/*
You will want to make a small class hierarchy for time distributions, with an abstract base class
like this:
abstract class main.RandomDistribution {
abstract double sample();
}
You will then implement subclasses for exponential and normal distribution, using the
generating techniques of sections 2.2 and 2.3.
 */

import java.util.Random;

public abstract class RandomDistribution {
    protected final Random rng = new Random();

    // Each subclass must define how to draw a sample
    public abstract double sample();
}

package com.jpenzes.smawing.utils;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 10:57
 */
public interface IObjectContainer<Identifier, TClass> extends Iterable<TClass> {

    TClass register(Identifier identifier, TClass object);

    <TClass> TClass get(Identifier identifier);
}


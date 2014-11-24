package com.jpenzes.smawing.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Author: Jirka Penzes
 * Date: 25/03/14 10:57
 */
public class ObjectContainer<Identifier, TClass> implements IObjectContainer<Identifier, TClass> {

    private final Map<Identifier, TClass> objectsMap;

    public ObjectContainer() {
        objectsMap = new HashMap<Identifier, TClass>();
    }

    @Override
    public TClass register(Identifier identifier, TClass object) {
        objectsMap.put(identifier, object);
        return object;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <TClass> TClass get(Identifier identifier) {
        return (TClass) objectsMap.get(identifier);
    }

    @Override
    public Iterator<TClass> iterator() {
        return objectsMap.values().iterator();
    }
}

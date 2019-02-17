package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.HashMap;
import java.util.Map;

class CountMapImpl <T> implements CountMap <T> {

    private HashMap<T,Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        if (o!=null) {
            int i = map.get(o) == null ? 0 : map.get(o);
            map.put(o, ++i);
        }
        else {throw new NullPointerException();}
    }

    @Override
    public int getCount(T o) {
        if (o!=null) {
            return map.get(o);
        }
        else {throw new NullPointerException();}
    }

    @Override
    public int remove(T o) {
        if (o!=null) {
            int i = map.get(o) == null ? 0 : map.get(o);
            i--;
            if (i <= 0) {
                map.remove(o);
            } else {
                map.put(o, i);
            }
            return ++i;
        }
        else {throw new NullPointerException();}
    }

    @Override
    public int size() {
        return map.keySet().size()+1;
    }

    @Override
    public void addAll(CountMap <T> source) {
        if (source!=null) {
            Map<T, Integer> newMap = source.toMap();
            for (T o : newMap.keySet()) {
                int j = map.get(o) == null ? 0 : map.get(o);
                map.put(o, j + newMap.get(o));
            }
        }
        else {throw new NullPointerException();}
    }

    @Override
    public Map toMap() {
        HashMap<T,Integer> mapCopy = new HashMap<>();
        mapCopy.putAll(map);
        return mapCopy;
    }

    @Override
    public void toMap(Map destination) {
        if (destination!=null) {
            destination.clear();
            destination.putAll(map);
        }
        else {throw new NullPointerException();}
    }
}

public class Solution {

    /**
     * 1. Интерфейс {@link CountMap} реализует контейнер, осуществляющий посчёт количества добавленных ссылок на объекты.
     * Например, если два раза вызвать метод {@link CountMap#add(Object)} с одинаковой ссылкой, то вызов метода
     * {@link CountMap#getCount(Object)} с той же ссылкой вернёт значение 2.
     *
     * 2. Сделайте интерфейс {@link CountMap} и метод {@link Solution#getCountMap()} обобщеными.
     *
     * 3. Реализуйте интерфейс {@link CountMap} в классе CountMapImpl.
     *
     * 4. Верните экземпляр объекта класса {@link CountMapImpl} в методе {@link Solution#getCountMap()}
     *
     * 5. Раскомментируйте тест для проверки.
     */



    public static <T> CountMap getCountMap() {
        CountMapImpl<T> ci = new CountMapImpl<>();
        return ci;
    }
}

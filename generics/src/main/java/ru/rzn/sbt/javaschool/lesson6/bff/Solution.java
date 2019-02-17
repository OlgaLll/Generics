package ru.rzn.sbt.javaschool.lesson6.bff;

import java.util.ArrayList;
import java.util.Collection;

class TwoItems<T>  {
    private T item1;
    private T item2;

    public T getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    public TwoItems(T item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
}

public class Solution {

    /**
     * 1. Создайте обобщённый класс TwoItems, параметризовынный типом <T> и хранящий две ссылки на объекты типа T.
     * Введите конструктор, принимающий два аргумента и get-методы.
     *
     * 2. В {@link Collection} persons найдите персоны, у которых взаимно совпадают ссылки на лучших друзей
     * {@link Person#bestFriend}, сформируйте из них экземпляры класса TwoItems<Person> и разместите
     * в {@link Collection}<TwoItems>.
     *
     * 3. В качестве результата выполнения метода {@link Solution#findBestFriends(Collection)} верните размер коллекции
     * с парами лучших друзей.
     */
    public static int findBestFriends(Collection<Person> persons) {
        Collection<TwoItems> clTwoItems = new ArrayList<>();
        for (Person p: persons) {
            for (Person p2: persons) {
                if (p!=p2) {
                    if (p.getBestFriend() == p2 & p2.getBestFriend() == p) {
                        boolean contains = false;
                        for (TwoItems<Person> tp: clTwoItems) {
                            if ((tp.getItem1()==p & tp.getItem2()==p2)||(tp.getItem1()==p2 & tp.getItem2()==p)) {
                                contains = true;
                            }
                        }
                        if (!contains) {
                            TwoItems<Person> ti = new TwoItems<>(p,p2);
                            clTwoItems.add(ti);
                        }
                    }
                }
            }
        }
        return clTwoItems.size();

    }
}

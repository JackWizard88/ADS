package com.geekbrains.krilov.algorythms.homework4.example;

public class LinkIteratorApp {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertAfter("Andrey", 25);
        itr.insertAfter("Ivan", 26);
        itr.insertAfter("Maxim", 27);
        itr.insertBefore("Sergey", 10);

        list.display();

        itr.reset();

        while(true) {
            itr.nextLink();
            if (itr.getCurrent().name.equals("Ivan")) {
                System.out.println(itr.deleteCurrent());
                break;
            }
        }

        list.display();
    }

}
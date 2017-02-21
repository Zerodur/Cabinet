package com.javarush.test.level17.lesson10.bonus03;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cooking();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("����� ��������");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cooking() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // ����� ����� ����� �� �������
        System.out.println(String.format("����� ����� ���������� %d �� ��� ����� �%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // ������� �����
        Dishes dishes = new Dishes(order.getTableNumber());       //  ��� ������� �����
        manager.getDishesQueue().add(new Dishes(order.getTableNumber()));
        System.out.println(String.format("����� ��� ����� �%d �����", dishes.getTableNumber()));
    }
}

package com.gb.design.mode.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������-������ģʽ
 * <p>
 * �����߳���������ֱ�����������������������������󣬼�������
 * �����߳������ѣ�ֱ���������գ����������������պ󣬼�������
 * �����߿����ж����������Ҳ�����ж��
 * <p>
 * ��ͨ������������֤ģ��ʵ�ֵ���ȷ�ԣ�
 * ͬһ��Ʒ��������Ϊһ��������������Ϊ֮��
 * ����ʱ�̣���������С��С��0����������������
 */
public class BlockingQueueModel implements Model {

    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int cap) {
        // LinkedBlockingQueue �Ķ����� lazy-init �ģ��� ArrayBlockingQueue �ڴ���ʱ���Ѿ� init
        this.queue = new LinkedBlockingQueue<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    class ConsumerImpl extends AbstractConsumer {

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            // �̶�ʱ�䷶Χ�����ѣ�ģ������ȶ��ķ������������
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.no);
        }
    }

    class ProducerImpl extends AbstractProducer {

        @Override
        public void produce() throws InterruptedException {
            // ������������ģ��������û�����
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            queue.put(task);
            System.out.println("produce: " + task.no);
        }
    }

    public static void main(String[] args) {
        Model model = new BlockingQueueModel(3);
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}

package com.gb.design.mode.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者-消费者模式
 * <p>
 * 生产者持续生产，直到缓冲区满，阻塞；缓冲区不满后，继续生产
 * 消费者持续消费，直到缓冲区空，阻塞；缓冲区不空后，继续消费
 * 生产者可以有多个，消费者也可以有多个
 * <p>
 * 可通过如下条件验证模型实现的正确性：
 * 同一产品的消费行为一定发生在生产行为之后
 * 任意时刻，缓冲区大小不小于0，不大于限制容量
 */
public class BlockingQueueModel implements Model {

    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int cap) {
        // LinkedBlockingQueue 的队列是 lazy-init 的，但 ArrayBlockingQueue 在创建时就已经 init
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
            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.no);
        }
    }

    class ProducerImpl extends AbstractProducer {

        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
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

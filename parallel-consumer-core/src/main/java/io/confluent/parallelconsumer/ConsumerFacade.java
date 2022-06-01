package io.confluent.parallelconsumer;

import io.confluent.parallelconsumer.internal.AbstractParallelEoSStreamProcessor;
import io.confluent.parallelconsumer.internal.ConsumerRebalanceHandler;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedTransferQueue;
import java.util.regex.Pattern;

/**
 * todo docs
 * <p>
 * This exposes a limited subset of the {@link Consumer} interface that is valid to be used within the PC context.
 * <p>
 * Generally, you can only... And you can't...
 * <p>
 * All methods are / must be thread safe.
 */
@Slf4j
@RequiredArgsConstructor
public class ConsumerFacade implements Consumer {

    static class Bus {
        Queue<ConsumerRebalanceHandler.Message> queue;
        Exchanger<ConsumerRebalanceHandler.Message> exchanger;
        LinkedTransferQueue<ConsumerRebalanceHandler.Message> transferQueue;

        public void blockingEnqueue(SeekMessage seekMessage) {
//            queue.add(seekMessage);
//            exchanger.exchange(seekMessage);
//            transferQueue.transfer(seekMessage);
        }

//        public SeekMessage poll() {
////            exchanger.
//        }
    }

    private final Bus bus;
    private final AbstractParallelEoSStreamProcessor<?, ?> controller;

    /// above
    @Override
    public Set<TopicPartition> assignment() {
//        controller.getWm().getPm().assignment();
        return null;
    }

    @Override
    public Set<String> subscription() {
        return null;
    }

    @Override
    public void subscribe(final Pattern pattern, final ConsumerRebalanceListener callback) {

    }

    @Override
    public void subscribe(final Pattern pattern) {

    }

    @Override
    public void unsubscribe() {

    }


    @Value
    @EqualsAndHashCode(callSuper = true)
    static class SeekMessage extends ConsumerRebalanceHandler.Message {
        TopicPartition partition;
        long offset;
    }

    @Override
    public void seek(final TopicPartition partition, final long offset) {
        bus.blockingEnqueue(new SeekMessage(partition, offset));
    }

    @Override
    public void seek(final TopicPartition partition, final OffsetAndMetadata offsetAndMetadata) {

    }

    @Override
    public long position(final TopicPartition partition) {
        return 0;
    }

    @Override
    public long position(final TopicPartition partition, final Duration timeout) {
        return 0;
    }

    @Override
    public OffsetAndMetadata committed(final TopicPartition partition) {
        return null;
    }

    @Override
    public OffsetAndMetadata committed(final TopicPartition partition, final Duration timeout) {
        return null;
    }

    @Override
    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    @Override
    public List<PartitionInfo> partitionsFor(final String topic) {
        return null;
    }

    @Override
    public List<PartitionInfo> partitionsFor(final String topic, final Duration timeout) {
        return null;
    }

    @Override
    public Map<String, List<PartitionInfo>> listTopics() {
        return null;
    }

    @Override
    public Map<String, List<PartitionInfo>> listTopics(final Duration timeout) {
        return null;
    }

    @Override
    public Set<TopicPartition> paused() {
        return null;
    }


    @Override
    public OptionalLong currentLag(final TopicPartition topicPartition) {
        return null;
    }

    @Override
    public ConsumerGroupMetadata groupMetadata() {
        return null;
    }

    @Override
    public void enforceRebalance() {

    }

    @Override
    public void close() {

    }

    @Override
    public void close(final Duration timeout) {

    }


    @Override
    public Map<TopicPartition, Long> endOffsets(final Collection collection, final Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> endOffsets(final Collection collection) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> beginningOffsets(final Collection collection, final Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, Long> beginningOffsets(final Collection collection) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(final Map timestampsToSearch, final Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(final Map timestampsToSearch) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndMetadata> committed(final Set set, final Duration timeout) {
        return null;
    }

    @Override
    public Map<TopicPartition, OffsetAndMetadata> committed(final Set set) {
        return null;
    }

    @Override
    public void seekToEnd(final Collection collection) {

    }

    @Override
    public void seekToBeginning(final Collection collection) {

    }

    @Override
    public void assign(final Collection collection) {

    }

    @Override
    public void subscribe(final Collection topics, final ConsumerRebalanceListener callback) {

    }

    @Override
    public void subscribe(final Collection topics) {

    }

    // no-ops


    @Override
    public ConsumerRecords poll(final long timeout) {
        return null;
    }

    @Override
    public ConsumerRecords poll(final Duration timeout) {
        return null;
    }

    @Override
    public void commitSync() {

    }

    @Override
    public void commitSync(final Duration timeout) {

    }

    @Override
    public void commitAsync() {

    }

    @Override
    public void commitAsync(final OffsetCommitCallback callback) {

    }

    @Override
    public void commitAsync(final Map offsets, final OffsetCommitCallback callback) {

    }

    @Override
    public void commitSync(final Map offsets, final Duration timeout) {

    }

    @Override
    public void commitSync(final Map offsets) {

    }

    @Override
    public void resume(final Collection collection) {

    }

    @Override
    public void pause(final Collection collection) {

    }

    @Override
    public void wakeup() {

    }
}

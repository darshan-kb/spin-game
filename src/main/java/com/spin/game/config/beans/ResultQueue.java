package com.spin.game.config.beans;

import com.spin.game.model.projection.GameResult;
import com.spin.game.payloads.QueuePayload;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

@Component
public class ResultQueue {
    private Queue<QueuePayload> queue;

    public ResultQueue(){
        queue = new ArrayDeque<>();
    }

    public void initializeQueue(List<GameResult> top5GameList){
        //List<GameSlot1AndSlot2> top5GameList = gameRepository.fetchTop5GameOverRow();
        top5GameList.forEach((i)->queue.add(new QueuePayload(i.getResultValue(),i.getGameTimeStamp())));

    }

    public Queue<QueuePayload> getQueue() {
        return queue;
    }

    public boolean push(QueuePayload queueElement){
        return queue.add(queueElement);
    }

    public QueuePayload pop(){
        return queue.poll();
    }

    @Override
    public String toString() {
        return "ResultQueue{" +
                "queue=" + queue.toString() +
                '}';
    }
}

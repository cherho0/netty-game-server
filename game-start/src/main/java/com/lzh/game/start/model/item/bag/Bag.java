package com.lzh.game.start.model.item.bag;

import com.lzh.game.repository.db.PersistEntity;
import com.lzh.game.start.model.item.bag.model.ItemStorage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * PlayerEnt pack
 */
@Document
@ToString
public class Bag extends PersistEntity<Long> implements Serializable {

    @Id
    @Getter
    @Setter
    private long playerId;

    @Getter
    @Setter
    private ItemStorage pack;

    @Override
    public Long cacheKey() {
        return playerId;
    }


    public static Bag of(long playerId) {
        Bag bag = new Bag();
        bag.playerId = playerId;
        bag.pack = ItemStorage.of();
        return bag;
    }
}

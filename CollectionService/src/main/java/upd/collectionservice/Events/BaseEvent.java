package upd.collectionservice.Events;

import java.util.Objects;

public abstract class BaseEvent {
    private final String id;

    public BaseEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEvent baseEvent = (BaseEvent) o;
        return Objects.equals(getId(), baseEvent.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

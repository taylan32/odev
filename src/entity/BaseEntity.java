package entity;

import java.util.Date;

public abstract class BaseEntity {
    private Date createdAt = new Date();
    private Date updatedAt = new Date();

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

}

package com.example.platform.models;

<<<<<<< Updated upstream
import jakarta.persistence.*;

import java.util.Date;
=======
import javax.persistence.*;
import java.time.LocalDateTime;
>>>>>>> Stashed changes

@Entity
public class Session {
    @Id
    private Long id;

    @ManyToOne
<<<<<<< Updated upstream
    @JoinColumn(name = "userId")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
=======
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    public Session() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getters and Setters
>>>>>>> Stashed changes
}

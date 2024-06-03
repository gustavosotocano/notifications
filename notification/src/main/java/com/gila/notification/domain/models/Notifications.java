package com.gila.notification.domain.models;



import com.gila.notification.infrastructure.adapters.outbound.persistence.entity.CategoryEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notifications")
public class Notifications {
    @Id
    private Integer id;
    /**
     * Categoria ID.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_name", nullable = false,foreignKey = @ForeignKey(name = "fk_category_notification"))
    private CategoryEntity categoriesName;

    /**
     * User ID.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false,foreignKey = @ForeignKey(name = "fk_user_notification"))
    private  User users;

    /**
     * Notification Type.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "channel_name", nullable = false,foreignKey = @ForeignKey(name = "fk_channel_notification"))
    private Channel channels;



}

package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Table(name = "notification")
@SuppressFBWarnings
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Entity
public class Notification {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "notification_type", length = 45)
    private String type;


    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device deviceId;

    @ManyToOne
    @JoinColumn(name = "hub_id", referencedColumnName = "id")
    private Hub hubNotificationId;


}

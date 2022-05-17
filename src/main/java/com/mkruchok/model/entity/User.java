package com.mkruchok.model.entity;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Collection;


@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@SuppressFBWarnings
@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "user_password", length = 45)
    private String password;
    @CreationTimestamp
    @Column(name = "date_created")
    private Timestamp dateCreated;
    @Column(name = "user_name", length = 45)
    private String name;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group groupId;
    @OrderColumn
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_has_hub",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hub_id"))
    @ToString.Exclude
    Collection<Hub> userHasHubs;
    @OrderColumn
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_has_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @ToString.Exclude
    Collection<Permission> userHasPermissions;


}

package com.mkruchok.model.entity;


import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")

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
  private Collection<Hub> userHasHubs;
  @OrderColumn
  @ManyToMany
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name = "user_has_permission",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  @ToString.Exclude
  private Collection<Permission> userHasPermissions;


}

package com.mkruchok.entity;


import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
  @Column(name = "email",
      length = MagicNumber.L45)
  private String email;
  @Column(name = "user_password",
      length = MagicNumber.L45)
  private String password;
  @CreationTimestamp
  @Column(name = "date_created")
  private Timestamp dateCreated;
  @Column(name = "user_name",
      length = MagicNumber.L45)
  private String name;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "users_group_id",
      referencedColumnName = "id")
  private UsersGroup usersGroupId;
  @OrderColumn
  @ManyToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name = "user_has_hub",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "hub_id"))
  @ToString.Exclude
  private Collection<Hub> userHasHubs;
  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "userId",
      cascade = CascadeType.ALL)
  @ToString.Exclude
  private Collection<Permission> permissions;


}

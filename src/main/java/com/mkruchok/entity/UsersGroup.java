package com.mkruchok.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Table(name = "users_group")

@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@NoArgsConstructor
public class UsersGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "group_name",
      length = MagicNumber.L45)
  private String name;
  @Column(name = "group_description",
      length = MagicNumber.L150)
  private String groupDescription;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubGroupId;
  @OrderColumn
  @OneToMany(mappedBy = "usersGroupId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<User> users;
  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "usersGroupId")
  @ToString.Exclude
  private Collection<Permission> permissions;

}

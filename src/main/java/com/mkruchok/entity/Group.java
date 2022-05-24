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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Table(name = "hub_group")
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Group {
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
  @OneToMany(mappedBy = "groupId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<User> users;
  @OrderColumn
  @ManyToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name = "group_has_permission",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  @ToString.Exclude
  private Collection<Permission> groupHasPermissions;
}


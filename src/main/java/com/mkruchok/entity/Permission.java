package com.mkruchok.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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


@Table(name = "permission")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Setter
@ToString
@Entity
public class Permission {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "permission_name",
      length = MagicNumber.L45)
  private String name;
  @Column(name = "permission_description",
      length = MagicNumber.L45)
  private String permissionDescription;

  @OrderColumn
  @ManyToMany(mappedBy = "userHasPermissions",
      cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @ToString.Exclude
  private Set<User> permissionHasUsers = new HashSet<>();
  @OrderColumn
  @ManyToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name = "group_has_permission",
      joinColumns = @JoinColumn(name = "permission_id"),
      inverseJoinColumns = @JoinColumn(name = "group_id"))
  @ToString.Exclude
  private Set<Group> permissionHasGroups = new HashSet<>();

}

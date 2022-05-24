package com.mkruchok.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "rex")

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
public class Rex {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "rex_name",
      length = MagicNumber.L45)
  private String name;
  @Column(name = "rex_range",
      length = MagicNumber.L45)
  private String range;


  @ManyToOne(cascade = CascadeType.MERGE)

  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubRexId;


}

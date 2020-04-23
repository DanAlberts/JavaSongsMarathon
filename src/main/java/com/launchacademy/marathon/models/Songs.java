package com.launchacademy.marathon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name="songs")
public class Songs {
  @Id
  @SequenceGenerator(name="song_generator", sequenceName="songs_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="song_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name="song_title", nullable=false)
  private String songTitle;

  @Column(name="genre")
  private String genre;

  @Column(name="release_year", nullable=false)
  private Integer releaseYear;

  @Column(name="explicit_content", nullable=false)
  private Boolean explicitContent;


}

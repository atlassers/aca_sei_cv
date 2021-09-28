//import javax.persistence.EmbeddedId;

//package it.euris.academy.cinema.data.model;
//
//import java.time.Instant;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import it.euris.academy.cinema.data.archetype.Model;
//import it.euris.academy.cinema.data.dto.FilmScreeningDto;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
//
//@Table(name="film_screening")
//@Entity
//
//public class FilmScreening implements Model{
//  
//  @EmbeddedId
    //private FilmScreeningKey id;
//  @Column(name="id")
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//  
//  @Column(name= "time")//?
//  private Instant time;
//  
//  @Override
//  public FilmScreeningDto toDto() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//}

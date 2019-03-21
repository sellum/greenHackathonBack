//package com.hackathon.service;
//
//
//import entity.Categorie;
//import entity.Jeu;
//import entity.Progres;
//import entity.Utilisateur;
//import org.springframework.http.ResponseEntity;
//
//import javax.rmi.CORBA.Util;
//import javax.validation.UnexpectedTypeException;
//import java.util.Collection;
//import java.util.List;
//
//public interface UtilisateurService {
//    List<Utilisateur> findAll();
//    Utilisateur findById(Long id);
//    Boolean add(Utilisateur utilisateur);
//    ResponseEntity<Utilisateur> update(Long id, Utilisateur utilisateur);
//    Boolean delete(Long id);
//    Boolean login(Utilisateur utilisateur);
//    Boolean ajoutJeu(long idUtilisateur, Jeu jeu);
//    public Boolean suppressionJeu(long idUtilisateur,long idJeu);
//    public Boolean ajoutProgres(long idUtilisateur, Progres progres);
//    public Boolean suppressionProgres(long idUtilisateur,long idProgres);
//    public Utilisateur findUserOnlyByUsername(Utilisateur utilisateur);
//    public Collection<Jeu> findJeuxByUtilisateurId(Utilisateur utilisateur);
//    public Collection<Categorie> findCategoriesOwnedByUtilisateurId(Utilisateur utilisateur);
//    public Collection<Utilisateur> getUtilisateursOrderByRank();
//    public Collection<Progres> getProgresByIdGameAndIdUtilisateur(Utilisateur utilisateur, long idJeu);
//}

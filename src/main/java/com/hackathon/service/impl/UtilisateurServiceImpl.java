//package com.hackathon.service.impl;
//
//
//import entity.Categorie;
//import entity.Jeu;
//import entity.Progres;
//import entity.Utilisateur;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import com.hackathon.repository.CategorieRepository;
//import com.hackathon.repository.JeuRepository;
//import com.hackathon.repository.ProgresRepository;
//import com.hackathon.repository.UtilisateurRepository;
//import com.hackathon.service.UtilisateurService;
//
//import javax.transaction.Transactional;
//import javax.validation.UnexpectedTypeException;
//import java.util.*;
//
//
//@Service
//@Transactional
//public class UtilisateurServiceImpl implements UtilisateurService {
//
//
//
//    @Autowired
//    private UtilisateurRepository utilisateurRepository;
//    @Autowired
//    private JeuRepository jeuRepository;
//    @Autowired
//    private ProgresRepository progresRepository;
//    @Autowired
//    private CategorieRepository categorieRepository;
//
//
//    /**
//     * permet de creer un utilisateur
//     * @param utilisateur l'utilisateur a creer
//     * @return L'utilisateur créé
//     */
//    @Override
//    public Boolean add(Utilisateur utilisateur) throws UnexpectedTypeException {
//        Collection<Utilisateur> utilisateurs = utilisateurRepository.findAll();
//        for(Utilisateur utilisateurReel : utilisateurs){
//            if(utilisateurReel.getUsername().equals(utilisateur.getUsername())){
//                return false;
//            }
//        }
//        utilisateurRepository.save(utilisateur);
//        return true;
//    }
//
//    /**f
//     * permet de modifier un utilisateur
//     * @param id l'id de l'utilisateur a modifier
//     * @param utilisateur les donnes a modifié
//     * @return
//     */
//    @Override
//    public ResponseEntity<Utilisateur> update(Long id, Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
//        if (!utilisateurOptional.isPresent()){
//            return ResponseEntity.notFound().build();
//        }
//        Utilisateur utilisateurReel = utilisateurOptional.get();
//        // On merge les deux entité pour pas mettre des null en base
//        if(utilisateur.getPassword() == null){
//            utilisateur.setPassword(utilisateurReel.getPassword());
//        }
//        if(utilisateur.getUsername() == null){
//            utilisateur.setUsername(utilisateurReel.getUsername());
//        }
//        if(utilisateur.getJeux() == null){
//            utilisateur.setJeux(utilisateurReel.getJeux());
//        }
//        if(utilisateur.getProgres() == null){
//            utilisateur.setProgres(utilisateurReel.getProgres());
//        }
//        if(utilisateur.getName() == null){
//            utilisateur.setName(utilisateurReel.getName());
//        }
//        utilisateur.setId(id);
//        utilisateurRepository.save(utilisateur);
//        return ResponseEntity.noContent().build();
//    }
//
//    /**
//     * permet de supprimer un jeu
//     * @param id l'id du jeu a supprimer
//     * @return true si réussite de la suppression false sinon
//     */
//    @Override
//    public Boolean delete(Long id) {
//        utilisateurRepository.deleteById(id);
//        return true;
//    }
//
//    /**
//     * permet de se connecter
//     * @param utilisateur les informations de connection
//     * @return true si réussite de la connection false sinon
//     */
//    @Override
//    public Boolean login(Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByUsername(utilisateur.getUsername());
//        if(utilisateurOptional.isPresent()){
//            Utilisateur utilisateurReel = utilisateurOptional.get();
//            return utilisateurReel.getPassword().equals(utilisateur.getPassword());
//        }
//        return false;
//    }
//
//    /**
//     * permet d'obtenir un utilisateur depuis son id
//     * @param id id de l'utilisateur recherché
//     * @return l'utilisateur recherché
//     */
//    @Override
//    public Utilisateur findById(Long id) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
//        return utilisateurOptional.orElseGet(Utilisateur::new);
//    }
//
//
//    /**
//     * permet d'obtenir tout les utilisateurs
//     * @return l'ensemble des utilisateurs
//     */
//    @Override
//    public List<Utilisateur> findAll() {
//        return utilisateurRepository.findAll();
//    }
//
//    /**
//     * Permet d'ajouter un jeu à un utilisateur
//     * @param idUtilisateur l'id de l'utilisateur
//     * @param jeu le jeu a ajouter
//     * @return vrai si l'ajout est une réussite
//     */
//    @Override
//    public Boolean ajoutJeu(long idUtilisateur, Jeu jeu) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);
//        if(utilisateurOptional.isPresent()){
//            Utilisateur utilisateurReel = utilisateurOptional.get();
//            Collection<Jeu> jeux = utilisateurReel.getJeux();
//            jeux.add(jeu);
//            utilisateurReel.setJeux(jeux);
//            utilisateurRepository.save(utilisateurReel);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * Permet de supprimer un jeu à un utilisateur
//     * @param idUtilisateur l'id de l'utilsiateur
//     * @param idJeu l'id du jeu
//     * @return true si la suppression est un succès
//     */
//    @Override
//    public Boolean suppressionJeu(long idUtilisateur,long idJeu){
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);
//        if(utilisateurOptional.isPresent()){
//            Optional<Jeu> jeuOptional = jeuRepository.findById(idJeu);
//            if(jeuOptional.isPresent()){
//                Utilisateur utilisateurReel = utilisateurOptional.get();
//                Jeu jeuReel = jeuOptional.get();
//                Collection<Jeu> jeux = utilisateurReel.getJeux();
//                jeux.remove(jeuReel);
//                utilisateurReel.setJeux(jeux);
//                Collection<Progres> progresCollection = new ArrayList<>();
//                for(Progres progres: utilisateurReel.getProgres()){
//                    if(progres.getJeu().getId() != idJeu){
//                        progresCollection.add(progres);
//                    }
//                }
//                utilisateurReel.setProgres(progresCollection);
//                utilisateurRepository.save(utilisateurReel);
//                return true;
//            }
//
//        }
//        return false;
//    }
//
//    /**
//     * Permet d'ajouter un progres à un utilisateur
//     * @param idUtilisateur l'id de l'utilisateur
//     * @param progres le progres a ajouter
//     * @return vrai si l'ajout est une réussite
//     */
//    @Override
//    public Boolean ajoutProgres(long idUtilisateur, Progres progres) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);
//        if(utilisateurOptional.isPresent()){
//            Utilisateur utilisateurReel = utilisateurOptional.get();
//            Collection<Progres> progresCollection = utilisateurReel.getProgres();
//            progresCollection.add(progres);
//            utilisateurReel.setProgres(progresCollection);
//            utilisateurRepository.save(utilisateurReel);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * Permet de supprimer un progres à un utilisateur
//     * @param idUtilisateur l'id de l'utilisateur
//     * @param idProgres l'id du progres
//     * @return true si la suppression est un succés
//     */
//    @Override
//    public Boolean suppressionProgres(long idUtilisateur,long idProgres){
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);
//        if(utilisateurOptional.isPresent()){
//            Optional<Progres> progresOptional = progresRepository.findById(idProgres);
//            if(progresOptional.isPresent()){
//                Utilisateur utilisateurReel = utilisateurOptional.get();
//                Progres progresReel = progresOptional.get();
//                Collection<Progres> progresCollection = utilisateurReel.getProgres();
//                progresCollection.remove(progresReel);
//                utilisateurReel.setProgres(progresCollection);
//                utilisateurRepository.save(utilisateurReel);
//                return true;
//            }
//
//        }
//        return false;
//    }
//
//    @Override
//    public Utilisateur findUserOnlyByUsername(Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByUsername(utilisateur.getUsername());
//        if(utilisateurOptional.isPresent()){
//            Utilisateur utilisateurReel = utilisateurOptional.get();
//            utilisateur.setId(utilisateurReel.getId());
//            utilisateur.setName(utilisateurReel.getName());
//            return utilisateur;
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<Jeu> findJeuxByUtilisateurId(Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByUsername(utilisateur.getUsername());
//        if(utilisateurOptional.isPresent()){
//            Utilisateur utilisateurReel = utilisateurOptional.get();
//            return utilisateurReel.getJeux();
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<Categorie> findCategoriesOwnedByUtilisateurId(Utilisateur utilisateur) {
//        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByUsername(utilisateur.getUsername());
//        if(utilisateurOptional.isPresent()){
//            Utilisateur utilisateurReel = utilisateurOptional.get();
//            Collection<Long> gamesOwned = new ArrayList<>();
//            for(Jeu jeu: utilisateurReel.getJeux()){
//                gamesOwned.add(jeu.getId());
//            }
//            List<Categorie> categories = categorieRepository.findAll();
//            List<Categorie> ownedCategories = new ArrayList<>();
//            for(Categorie categorie : categories){
//                for(Jeu jeu: categorie.getJeux()) {
//                    if (gamesOwned.contains(jeu.getId())){
//                        ownedCategories.add(categorie);
//                    }
//                }
//            }
//            return ownedCategories;
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<Utilisateur> getUtilisateursOrderByRank() {
//
//        ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) utilisateurRepository.findAll();
//        ArrayList<Utilisateur> utilisateursTrie = new ArrayList<>();
//        Utilisateur bestUtilisateur;
//        int lengthIni = utilisateurs.size();
//        for(int i =0; i<lengthIni;i++){
//            bestUtilisateur = utilisateurs.get(0);
//            for(Utilisateur utilisateur:utilisateurs){
//                if(bestUtilisateur.getProgres().size() < utilisateur.getProgres().size()){
//                    bestUtilisateur=utilisateur;
//                }
//            }
//            utilisateursTrie.add(bestUtilisateur);
//        }
//        return utilisateurs;
//    }
//
//    @Override
//    public Collection<Progres> getProgresByIdGameAndIdUtilisateur(Utilisateur utilisateur, long idJeu) {
//        Collection<Progres> progresToReturn = new ArrayList<>();
//        Collection<Progres> progresCollections = utilisateurRepository.findById(utilisateur.getId()).get().getProgres();
//        for(Progres progres : progresCollections){
//            if(progres.getJeu().getId() == idJeu){
//                progresToReturn.add(progres);
//            }
//        }
//        return progresToReturn;
//    }
//
//
//}

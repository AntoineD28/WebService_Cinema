export interface Film {
    titre: String;
    duree: number;
    dateSortie: Date;
    budget: number;
    montantRecette: number;
    realisateur: Realisateur;
    categorie: Categorie;
    personnages: Personnage;
    noFilm: number;
  }

export interface Realisateur {
    norea: number;
    nomRea: String;
    prenRea: String;
}

export interface Categorie {
    codecat: String;
    libelleCat: String;
    image: String;
}

export interface Personnage {
    nomPers: String;
}
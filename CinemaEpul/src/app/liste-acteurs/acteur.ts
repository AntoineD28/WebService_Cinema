export interface Realisateur {
    norea: number;
    nomRea: string;
    prenRea: string;
}

export interface Categorie {
    codecat: string;
    libelleCat: string;
    image: string;
}

export interface Film {
    nofilm: number;
    titre: string;
    duree: number;
    dateSortie: Date;
    budget: number;
    montantRecette: number;
    realisateur: Realisateur;
    categorie: Categorie;
    noFilm: number;
}

export interface Personnage {
    nomPers: string;
    film: Film;
}

export interface Acteur {
    noact: number;
    nomAct: string;
    prenAct: string;
    dateNaiss: Date;
    dateDeces?: any;
    personnages: Personnage[];
    noAct: number;
}
export interface Film {
    nofilm: number
    titre: string
    duree: number
    dateSortie: string
    budget: number
    montantRecette: number
    realisateur: Realisateur
    categorie: Categorie
    personnages: Personnage[]
    noFilm: number
  }
  
  export interface Realisateur {
    norea: number
    nomRea: string
    prenRea: string
  }
  
  export interface Categorie {
    codecat: string
    libelleCat: string
    image: string
  }
  
  export interface Personnage {
    nomPers: string
    acteur: Acteur
  }
  
  export interface Acteur {
    noact: number
    nomAct: string
    prenAct: string
    dateNaiss: string
    dateDeces?: string
    noAct: number
  }
  
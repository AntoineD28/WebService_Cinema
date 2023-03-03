import 'package:ws_mobile/Model/personnage.dart';
import 'package:ws_mobile/Model/realisateur.dart';
import 'categorie.dart';

class Film {
  int? nofilm;
  String? titre;
  int? duree;
  DateTime? dateSortie;
  int? budget;
  int? montantRecette;
  Realisateur? realisateur;
  Categorie? categorie;
  List<Personnages>? personnages;
  int? noFilm;

  Film(
      {this.nofilm,
        this.titre,
        this.duree,
        this.dateSortie,
        this.budget,
        this.montantRecette,
        this.realisateur,
        this.categorie,
        this.personnages,
        this.noFilm});

  Film.fromJson(Map<String, dynamic> json) {
    nofilm = json['nofilm'];
    titre = json['titre'];
    duree = json['duree'];
    dateSortie = DateTime.parse(json['dateSortie'] as String);
    budget = json['budget'];
    montantRecette = json['montantRecette'];
    realisateur = json['realisateur'] != null
        ? new Realisateur.fromJson(json['realisateur'])
        : null;
    categorie = json['categorie'] != null
        ? new Categorie.fromJson(json['categorie'])
        : null;
    if (json['personnages'] != null) {
      personnages = <Personnages>[];
      json['personnages'].forEach((v) {
        personnages!.add(new Personnages.fromJson(v));
      });
    }
    noFilm = json['noFilm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['nofilm'] = this.nofilm;
    data['titre'] = this.titre;
    data['duree'] = this.duree;
    data['dateSortie'] = this.dateSortie;
    data['budget'] = this.budget;
    data['montantRecette'] = this.montantRecette;
    if (this.realisateur != null) {
      data['realisateur'] = this.realisateur!.toJson();
    }
    if (this.categorie != null) {
      data['categorie'] = this.categorie!.toJson();
    }
    if (this.personnages != null) {
      data['personnages'] = this.personnages!.map((v) => v.toJson()).toList();
    }
    data['noFilm'] = this.noFilm;
    return data;
  }
}
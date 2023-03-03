import 'acteur.dart';

class Personnages {
  String? nomPers;
  Acteur? acteur;

  Personnages({this.nomPers, this.acteur});

  Personnages.fromJson(Map<String, dynamic> json) {
    nomPers = json['nomPers'];
    acteur =
    json['acteur'] != null ? new Acteur.fromJson(json['acteur']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['nomPers'] = this.nomPers;
    if (this.acteur != null) {
      data['acteur'] = this.acteur!.toJson();
    }
    return data;
  }
}

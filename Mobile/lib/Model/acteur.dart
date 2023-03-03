class Acteur {
  int? noact;
  String? nomAct;
  String? prenAct;
  String? dateNaiss;
  String? dateDeces;
  int? noAct;

  Acteur(
      {this.noact,
        this.nomAct,
        this.prenAct,
        this.dateNaiss,
        this.dateDeces,
        this.noAct});

  Acteur.fromJson(Map<String, dynamic> json) {
    noact = json['noact'];
    nomAct = json['nomAct'];
    prenAct = json['prenAct'];
    dateNaiss = json['dateNaiss'];
    dateDeces = json['dateDeces'];
    noAct = json['noAct'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['noact'] = this.noact;
    data['nomAct'] = this.nomAct;
    data['prenAct'] = this.prenAct;
    data['dateNaiss'] = this.dateNaiss;
    data['dateDeces'] = this.dateDeces;
    data['noAct'] = this.noAct;
    return data;
  }
}
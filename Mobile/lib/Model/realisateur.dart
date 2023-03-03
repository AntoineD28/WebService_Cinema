class Realisateur {
  int? norea;
  String? nomRea;
  String? prenRea;

  Realisateur({this.norea, this.nomRea, this.prenRea});

  Realisateur.fromJson(Map<String, dynamic> json) {
    norea = json['norea'];
    nomRea = json['nomRea'];
    prenRea = json['prenRea'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['norea'] = this.norea;
    data['nomRea'] = this.nomRea;
    data['prenRea'] = this.prenRea;
    return data;
  }
}
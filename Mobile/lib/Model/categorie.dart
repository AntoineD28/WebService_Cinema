class Categorie {
  String? codecat;
  String? libelleCat;
  String? image;

  Categorie({this.codecat, this.libelleCat, this.image});

  Categorie.fromJson(Map<String, dynamic> json) {
    codecat = json['codecat'];
    libelleCat = json['libelleCat'];
    image = json['image'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['codecat'] = this.codecat;
    data['libelleCat'] = this.libelleCat;
    data['image'] = this.image;
    return data;
  }
}

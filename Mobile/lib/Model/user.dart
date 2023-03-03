class User {
  String nomUtil;
  String role;
  int num;
  String token;

  User(this.nomUtil,
      this.role,
      this.num,
      this.token);

  factory User.fromJson(Map<String, dynamic>json) {
    final nomUtil = json['nomUtil'] as String;
    final role = json['role'] as String;
    final token = json['jwttoken'] as String;
    final num = json['numUtil'] as int;
    return User(nomUtil, role, num, token);
  }
}
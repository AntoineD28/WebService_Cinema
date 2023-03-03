import 'dart:io';

import 'package:http/http.dart' as http;
import 'dart:convert';
import 'Exception.dart';
import 'Model/film.dart';
import 'Model/user.dart';

Future<User> login(String username, String pwd) async {
  final httpPackageUrl = Uri.http('10.0.2.2:8080', '/authentification/login');
  final httpPackageInfo = await http.post(httpPackageUrl, headers: {'Content-Type': 'application/json'}, body:jsonEncode({'nomUtil': username, 'motPasse': pwd}));

  // If the request didn't succeed, throw an exception
  if (httpPackageInfo.statusCode != 200) {
    throw PackageRetrievalException(
      packageName: "/authentification/login",
      statusCode: httpPackageInfo.statusCode,
    );
  }

  final user = json.decode(httpPackageInfo.body) as Map<String, dynamic>;
  return User.fromJson(user);
}

Future<List<Film>> getAllFilm(String token) async {
  final httpPackageUrl = Uri.http('10.0.2.2:8080', '/films/all');
  final httpPackageInfo = await http.get(httpPackageUrl, headers: {HttpHeaders.contentTypeHeader: "application/json", HttpHeaders.authorizationHeader: "Bearer $token"});

  // If the request didn't succeed, throw an exception
  if (httpPackageInfo.statusCode != 200) {
    throw PackageRetrievalException(
      packageName: "/films/all",
      statusCode: httpPackageInfo.statusCode,
    );
  }

  return (jsonDecode(httpPackageInfo.body) as List)
      .map((e) => Film.fromJson(e))
      .toList();
}
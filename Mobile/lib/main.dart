import 'dart:convert';
import 'dart:ffi';
import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:ws_mobile/Service.dart';
import 'package:ws_mobile/ViewFilm.dart';

import 'Model/user.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: LoginPage(),
    );
  }
}

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  String _errorMessage = '';
  Future<User?> _login() async {
    final username = _usernameController.text;
    final password = _passwordController.text;
    final User u;
    u = await login(username, password) ;
    return u;

    /*if (response.statusCode == 200) {
      final data = json.decode(response.body);
      final token = data['jwttoken'];
      // TODO: Store token securely, e.g. in secure storage or Keychain
      // Store token using SharedPreferences
      final prefs = await SharedPreferences.getInstance();
      await prefs.setString('token', token);
      return true;
      //Navigator.pushReplacementNamed(context, '/home'); // Redirect to home page
    } else {
      final data = json.decode(response.body);
      setState(() {
        _errorMessage = data['error'];
      });
      return false;
    }*/
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Login'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              controller: _usernameController,
              decoration: const InputDecoration(
                hintText: 'Username',
              ),
            ),
            const SizedBox(height: 16.0),
            TextField(
              controller: _passwordController,
              obscureText: true,
              decoration: const InputDecoration(
                hintText: 'Password',
              ),
            ),
            const SizedBox(height: 32.0),
            ElevatedButton(
              child: Text('Login'),
              onPressed: () async {
                User? user = await _login();
                if (!mounted) return;
                if(user != null) {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => ViewFilmPage(u: user)),
                  );
                }
                else {
                  Text(_errorMessage, style: const TextStyle(color: Colors.red));
                }
              },
            ),
            const SizedBox(height: 8.0),
            Text(_errorMessage, style: const TextStyle(color: Colors.red)),
          ],
        ),
      ),
    );
  }
}
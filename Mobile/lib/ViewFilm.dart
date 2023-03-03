import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:ws_mobile/Service.dart';

import 'Model/film.dart';
import 'Model/user.dart';
import 'ViewFilmDetail.dart';

class ViewFilmPage extends StatefulWidget {
  const ViewFilmPage({super.key, required this.u});
  final User u;

  @override
  _ViewFilmPageState createState() => _ViewFilmPageState();
}

class _ViewFilmPageState extends State<ViewFilmPage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey,
      appBar: AppBar(
        title: Text(widget.u.nomUtil),
      ),
      body: Center(
        child: ListView(
          scrollDirection: Axis.vertical,
          children: [
            FutureBuilder<List<Film>>(
              future: getAllFilm(widget.u.token),
              builder: (context, snapshot) {
                if (snapshot.hasData) {
                  List<Film> films = snapshot.data as List<Film>;
                  return ListView.builder(
                      shrinkWrap: true,
                      physics: const NeverScrollableScrollPhysics(),
                      itemCount: films.length,
                      itemBuilder: (context, index) {
                        return Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: InkWell(
                            onTap: () => Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => ViewFilmDetail(f: films[index])),
                            ),
                            child: Card(
                              child: Column(
                                mainAxisSize: MainAxisSize.min,
                                children: <Widget>[
                                  Container(
                                      alignment: Alignment.center,
                                      child: Image.asset('./IMG/${films[index].titre}.jpg')
                                  ),
                                ],
                              ),
                            ),
                          )
                        );
                      }
                  );
                }
                if (snapshot.hasError) {
                  print(snapshot.error.toString());
                  return const Text('error');
                }
                return const CircularProgressIndicator();
              },
            ),
          ],
        )
      ),
    );
  }
}
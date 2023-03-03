import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:ws_mobile/Service.dart';

import 'Model/film.dart';
import 'Model/user.dart';
import 'package:intl/intl.dart';

class ViewFilmDetail extends StatefulWidget {
  const ViewFilmDetail({super.key, required this.f});
  final Film f;

  @override
  _ViewFilmDetailState createState() => _ViewFilmDetailState();
}

class _ViewFilmDetailState extends State<ViewFilmDetail> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: Text(widget.f.titre ?? ''),
      ),
      body: Center(
        child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                const Padding(
                  padding: EdgeInsets.only(right: 25),
                  child: Text("Réalisateur", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30)),
                ),
                Text("${widget.f.realisateur?.prenRea} ${widget.f.realisateur?.nomRea}",
                    style: TextStyle(fontSize: 30)),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                const Padding(
                  padding: EdgeInsets.only(right: 25),
                  child: Text("Personnages", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30)),
                ),
                Column(
                  children: <Widget>[for(var pers in widget.f.personnages!)
                    Padding(padding: const EdgeInsets.only(bottom: 5),
                      child: Text("${pers.nomPers}", style: TextStyle(fontSize: 30)),)
                  ],
                ),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                const Padding(
                  padding: EdgeInsets.only(right: 25),
                  child: Text("Acteurs", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30)),
                ),
                Column(
                  children: <Widget>[for(var pers in widget.f.personnages!)
                    Padding(padding: const EdgeInsets.only(bottom: 5),
                      child: Text("${pers.acteur?.prenAct} ${pers.acteur?.nomAct}", style: TextStyle(fontSize: 30)),)
                  ],
                ),
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                const Padding(
                  padding: EdgeInsets.only(right: 25),
                  child: Text("Date de sortie", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30)),
                ),
                Text(DateFormat.yMMMd().format(widget.f.dateSortie!),
                    style: TextStyle(fontSize: 30)),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
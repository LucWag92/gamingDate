import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';

class AccountDataService {
//get from backend

  final String localBackend = "127.0.0.1:8080";

  Future<int> getAccountDataById(int id) async {
    debugPrint('getting account data by id:' + id.toString());
    Uri getAccountDataByIdUri = new Uri.http(localBackend, "/accountdata");
    final body = jsonEncode(id);
    var response = await post(
        getAccountDataByIdUri, headers: {"Access-Control-Allow-Origin": "*","Content-type": "application/json"},
        body:
        body);
    if (response.statusCode != 400) {
      throw new Exception("error while fetching data");
    }
    return jsonDecode(response.body);
  }
}

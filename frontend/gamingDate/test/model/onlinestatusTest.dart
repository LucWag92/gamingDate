import 'package:flutter_test/flutter_test.dart';
import 'package:gaming_date/model/onlineStatusEnum.dart';
import 'package:gaming_date/model/onlinestatus.dart';

void main() {
  test('Constructor and getter', () {
    final OnlineStatus onlineStatus =
        OnlineStatus('id', OnlineStatusEnum.online);
    expect(onlineStatus.onlineStatusId, 'id');
    expect(onlineStatus.onlineStatus, OnlineStatusEnum.online);
  });
}

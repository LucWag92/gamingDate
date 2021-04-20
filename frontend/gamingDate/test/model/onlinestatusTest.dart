import 'package:flutter_test/flutter_test.dart';
import 'package:gamingDate/model/onlineStatusEnum.dart';
import 'package:gamingDate/model/onlinestatus.dart';

void main() {
  test('Constructor and getter', () {
    final OnlineStatus onlineStatus = OnlineStatus(0, OnlineStatusEnum.online);
    expect(onlineStatus.onlineStatusId, 0);
    expect(onlineStatus.onlineStatus, OnlineStatusEnum.online);
  });
}

import 'package:flutter_test/flutter_test.dart';
import 'package:gamingDate/model/accountdata.dart';
import 'package:gamingDate/model/profile.dart';
import 'package:gamingDate/model/user.dart';

void main(){
  test('Constructor and getter',() {
    final User user = User(0, AccountData(null, null, null), Profile(null, null, null, null, null, null));
    expect(user.userId, 0);
    expect(user.accountData, isNot(null));
    expect(user.profile, isNot(null));
  });
}
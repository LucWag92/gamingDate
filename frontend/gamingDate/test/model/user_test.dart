import 'package:flutter_test/flutter_test.dart';
import 'package:gaming_date/model/accountdata.dart';
import 'package:gaming_date/model/profile.dart';
import 'package:gaming_date/model/user.dart';

void main() {
  test('Constructor and getter', () {
    final User user = User('id', AccountData(null, null, null),
        Profile(null, null, null, null, null, null));
    expect(user.userId, 'id');
    expect(user.accountData, isNot(null));
    expect(user.profile, isNot(null));
  });
}

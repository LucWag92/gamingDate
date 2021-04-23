import 'package:flutter_test/flutter_test.dart';
import 'package:gaming_date/model/accountdata.dart';

void main() {
  test('Constructor and getter', () {
    final AccountData accountData = AccountData('id', 'email', 'password');
    expect(accountData.accountDataId, 'id');
    expect(accountData.email, 'email');
    expect(accountData.password, 'password');
  });
}

import 'package:flutter_test/flutter_test.dart';
import 'package:gamingDate/model/accountdata.dart';

void main() {
  test('Constructor and getter', () {
    final AccountData accountData = AccountData(0, 'email', 'password');
    expect(accountData.accountDataId, 0);
    expect(accountData.email, 'email');
    expect(accountData.password, 'password');
  });
}

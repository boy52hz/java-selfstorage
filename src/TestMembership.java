import membership.MemberAccount;
import Base.Person;

public class TestMembership {
    public static void main(String[] args) {
        Person p1 = new Person("a", "aa");
        Person p2 = new Person("b", "bb");
        MemberAccount[] members = new MemberAccount[2];
        members[0] = new MemberAccount(p1);
        members[1] = new MemberAccount(p2, 420.2020);
        
        System.out.println(members[0].getAccountNo());
        System.out.println(members[0].getAccountName());
        System.out.println(members[0].getAccountOwner());
        System.out.println(members[0].getBalance());
        System.out.println(members[0].getTransactionHistory());
        
        System.out.println(members[1].getAccountNo());
        System.out.println(members[1].getAccountName());
        System.out.println(members[1].getAccountOwner());
        System.out.println(members[1].getBalance());
        members[1].deposit(10000.123456);
        System.out.println(members[1].getBalance());
        System.out.println(members[1].getTransactionHistory());
    }
}

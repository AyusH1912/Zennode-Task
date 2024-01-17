import java.util.Scanner;

public class devTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cart = 0;
        int totalProdA = 0;
        int totalProdB = 0;
        int totalProdC = 0;
        int total = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the product character from a/b/c:");
            char x = sc.next().charAt(0);
            if (x == 'a' || Character.toUpperCase(x) == 'A') {
                System.out.println("Enter the Quantity:");
                int q = sc.nextInt();
                prodA a = new prodA(q);
                cart += a.quantity;
                totalProdA = a.price * q;
                if (q > 10) {
                    double dis = 0.05 * totalProdA;
                    totalProdA -= (int) dis;
                    System.out.println("bulk_5_discount applied on Product A");
                }
                total += totalProdA;
                System.out.println(
                        "Product A selected, quantity=" + q + " and the amount of this product is $" + totalProdA);
            }
            if (x == 'b' || Character.toUpperCase(x) == 'B') {
                System.out.println("Enter the Quantity:");
                int q = sc.nextInt();
                prodB b = new prodB(q);
                cart += b.quantity;
                totalProdB = b.price * q;
                if (q > 10) {
                    double dis = 0.05 * totalProdB;
                    totalProdB -= (int) dis;
                    System.out.println("bulk_5_discount applied on Product B");
                }
                total += totalProdB;
                System.out.println(
                        "Product B selected, quantity=" + q + " and the amount of this product is $" + totalProdB);
            }
            if (x == 'c' || Character.toUpperCase(x) == 'C') {
                System.out.println("Enter the Quantity:");
                int q = sc.nextInt();
                prodC c = new prodC(q);
                cart += c.quantity;
                totalProdC = c.price * q;
                if (q > 10) {
                    double dis = 0.05 * totalProdC;
                    totalProdC -= (int) dis;
                    System.out.println("bulk_5_discount applied on Product C");
                }
                total += totalProdC;
                System.out.println(
                        "Product B selected, quantity=" + q + " and the amount of this product is $" + totalProdC);
            }
            if (i < 2) {
                System.out.println("Want more proucts: (y/n)?");
                char ask = sc.next().charAt(0);
                if (ask == 'y' || Character.toUpperCase(ask) == 'Y') {
                    continue;
                } else if (ask == 'n' || Character.toUpperCase(ask) == 'N') {
                    break;
                }
            }
        }
        int maxDis = Integer.MAX_VALUE;
        if (total > 200) {
            int temp = total;
            temp -= 10;
            if (temp < maxDis) {
                maxDis = 10;
                total = temp;
            }
            System.out.println("$10 discount applied, total is $" + total);
        }
        if (cart > 20) {
            double dis = 0.1 * (total + maxDis);
            if (dis > maxDis) {
                total += maxDis;
                System.out.println("10% discount applied, removed previous discount, ");
                int temp = total - (int) dis;
                maxDis = (int) dis;
                total = temp;
            }
            System.out.println("Total is $" + total);
        }
        System.out.println("Want to gift wrap the product(s)?");
        char gif = sc.next().charAt(0);
        if (gif == 'y' || Character.toUpperCase(gif) == 'Y') {
            int gift = cart * 1;
            total += gift;
            System.out.println("Gift wrap fee added $" + gift);
        }
        int pack = Math.round(cart / 10);
        if (cart % 10 != 0)
            pack++;
        int totalPackCost = pack * 5;
        total += totalPackCost;
        System.out.println("Shipping fee added $" + totalPackCost);
        System.out.println("Total of the cart value is $" + total);
    }
}

class prodA {
    final int price = 20;
    int quantity;

    public prodA(int q) {
        this.quantity = q;
    }
}

class prodB {
    final int price = 40;
    int quantity;

    public prodB(int q) {
        this.quantity = q;
    }
}

class prodC {
    final int price = 50;
    int quantity;

    public prodC(int q) {
        this.quantity = q;
    }
}
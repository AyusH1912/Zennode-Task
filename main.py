class ProdA:
    price = 20

    def __init__(self, q):
        self.quantity = q


class ProdB:
    price = 40

    def __init__(self, q):
        self.quantity = q


class ProdC:
    price = 50

    def __init__(self, q):
        self.quantity = q


def main():
    cart = 0
    total_prod_a = 0
    total_prod_b = 0
    total_prod_c = 0
    total = 0

    for i in range(3):
        print("Enter the product character from a/b/c:")
        x = input()[0]

        if x.lower() == 'a':
            print("Enter the Quantity:")
            q = int(input())
            a = ProdA(q)
            cart += a.quantity
            total_prod_a = a.price * q

            if q > 10:
                dis = 0.05 * total_prod_a
                total_prod_a -= int(dis)
                print("bulk_5_discount applied on Product A")

            total += total_prod_a
            print(f"Product A selected, quantity={q} and the amount of this product is ${total_prod_a}")

        elif x.lower() == 'b':
            print("Enter the Quantity:")
            q = int(input())
            b = ProdB(q)
            cart += b.quantity
            total_prod_b = b.price * q

            if q > 10:
                dis = 0.05 * total_prod_b
                total_prod_b -= int(dis)
                print("bulk_5_discount applied on Product B")

            total += total_prod_b
            print(f"Product B selected, quantity={q} and the amount of this product is ${total_prod_b}")

        elif x.lower() == 'c':
            print("Enter the Quantity:")
            q = int(input())
            c = ProdC(q)
            cart += c.quantity
            total_prod_c = c.price * q

            if q > 10:
                dis = 0.05 * total_prod_c
                total_prod_c -= int(dis)
                print("bulk_5_discount applied on Product C")

            total += total_prod_c
            print(f"Product C selected, quantity={q} and the amount of this product is ${total_prod_c}")

        if i < 2:
            print("Want more products: (y/n)?")
            ask = input()[0]
            if ask.lower() == 'y':
                continue
            elif ask.lower() == 'n':
                break

    max_dis = float('inf')
    if total > 200:
        temp = total
        temp -= 10
        if temp < max_dis:
            max_dis = 10
            total = temp
        print(f"$10 discount applied, total is ${total}")

    if cart > 20:
        dis = 0.1 * (total + max_dis)
        if dis > max_dis:
            total += max_dis
            print("10% discount applied, removed previous discount, ")
            temp = total - int(dis)
            max_dis = int(dis)
            total = temp
        print(f"Total is ${total}")

    print("Want to gift wrap the product(s)?")
    gif = input()[0]
    if gif.lower() == 'y':
        gift = cart * 1
        total += gift
        print(f"Gift wrap fee added ${gift}")

    pack = cart // 10
    if cart % 10 != 0:
        pack += 1
    total_pack_cost = pack * 5
    total += total_pack_cost
    print(f"Shipping fee added ${total_pack_cost}")
    print(f"Total of the cart value is ${total}")


if __name__ == "__main__":
    main()

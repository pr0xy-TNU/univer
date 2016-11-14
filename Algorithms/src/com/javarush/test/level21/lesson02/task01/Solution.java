package com.javarush.test.level21.lesson02.task01;

    /* Определяем адрес сети
    1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        for (Byte item : netAddress) {
            System.out.println(item);
        }
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        byte[] result = new byte[4];

        result[0] = (byte) (ip[0] & mask[0]);
        result[1] = (byte) (ip[1] & mask[1]);
        result[2] = (byte) (ip[2] & mask[2]);
        result[3] = (byte) (ip[3] & mask[3]);


        return result;
    }

    public static void print(byte[] bytes) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(" ","0") + " ";
        }
        System.out.println(result.toString());

    }
}
